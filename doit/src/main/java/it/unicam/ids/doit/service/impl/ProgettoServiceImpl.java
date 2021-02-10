package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProgettoRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Waiting;
import it.unicam.ids.doit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProgettoServiceImpl implements ProgettoService {

    @Autowired
    private ProgettoRepository progettoRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ProgettistaService progettistaService;

    @Autowired
    private SponsorService sponsorService;

    @Autowired
    private EspertoService espertoService;

    @Autowired
    private ProponenteProgettoService propProgService;


    @Override
    public Progetto createProgetto(Long proponenteProgettoID, String name, int nMaxProgettisti){
        Progetto p = new Progetto(proponenteProgettoID,name,nMaxProgettisti);
        progettoRepository.save(p);
        return p;
    }

    @Override
    public void deleteProgetto(Long idProgetto){
        Progetto p = getProgetto(idProgetto);
        propProgService.removeProgettoGestito(p.getProponenteProgettoID(),idProgetto);
        espertoService.removeProgetto(p.getEspertoId(),idProgetto);
        if(!p.getCandidati().isEmpty()) p.getCandidati().forEach(c -> progettistaService.removeprogettoCandidato(idProgetto,c));
        if(!p.getProgettistiInvitati().isEmpty()) p.getProgettistiInvitati().forEach(c -> progettistaService.refuseInvito(idProgetto,c));
        if(!p.getTeam().getProgettistiTeam().isEmpty()) p.getTeam().getProgettistiTeam().
                forEach(pt -> progettistaService.removeProgetto(idProgetto,pt));
        if(!p.getSponsors().isEmpty()) p.getSponsors().forEach(s -> sponsorService.removeProgetto(idProgetto,s));
        if(p.getTeam() != null )teamService.deleteTeam(p.getTeam().getId());
        progettoRepository.delete(p);
    }

    @Override
    public Progetto getProgetto(Long id){
        return progettoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Progetto> getAllProgetti() {
        return progettoRepository.findAll();
    }

    @Override
    public void confirmProgetto(Long idProgetto,Long idEsperto) {
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().confirm(progetto);
        progetto.setEspertoId(idEsperto);
        progetto.getTeam().setProgettoID(progetto.getId());
        //state.confirm();
        progettoRepository.save(progetto);
    }

    @Override
    public void declineProgetto(Long idProgetto,Long idEsperto) {
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().decline(progetto);
        progetto.setEspertoId(idEsperto);
        //state.decline();
        progettoRepository.save(progetto);

    }

    @Override
    public void addCandidato(Long idProgetto, Long idProgettista){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().addCandidato(idProgetto, idProgettista);
        //state.addCandidato(progettista);
        progettoRepository.save(progetto);

    }

    @Override
    public void removeCandidato(Long idProgetto, Long idProgettista) {
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().removeCandidato(idProgetto, idProgettista);
        //state.removeCandidato(p);
        progettoRepository.save(progetto);

    }

    @Override
    public void addProgettistaInvitato(Long idProgetto, Long idProgettista){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().addInvitoProgettista(idProgetto, idProgettista);
        //state.addCandidato(progettista);
        progettoRepository.save(progetto);
    }

    @Override
    public void removeProgettistaInvitato(Long idProgetto, Long idProgettista){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().removeInvitoProgettista(idProgetto, idProgettista);
        //state.addCandidato(progettista);
        progettoRepository.save(progetto);
    }

    @Override
    public void addSponsor(Long idProgetto, Long idSponsor){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getSponsors().add(idSponsor);
        //sponsors.add(s.getID());
        progettoRepository.save(progetto);
    }

    @Override
    public void removeSponsor(Long idProgetto, Long idSponsor){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getSponsors().remove(idSponsor);
        //sponsors.remove(s.getID());
        progettoRepository.save(progetto);
    }

    @Override
    public void addEsperto(Long idProgetto, Long idEsperto){
        Progetto progetto = getProgetto(idProgetto);
        progetto.setEspertoId(idEsperto);
        progettoRepository.save(progetto);
    }

    @Override
    public void removeEsperto(Long idProgetto){
        Progetto progetto = getProgetto(idProgetto);
        progetto.setEspertoId((long)0);
        progettoRepository.save(progetto);
    }

    @Override
    public void removeTeam(Long idProgetto){
        Progetto progetto = getProgetto(idProgetto);
        progetto.setTeam(null);
        progettoRepository.save(progetto);
    }

    @Override
    public void incrementAmount(Long idProgetto, double amount){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().incrementAmount(idProgetto, amount);
        //state.incrementAmount(a);
        progettoRepository.save(progetto);
    }

    @Override
    public void decrementAmount(Long idProgetto, double amount){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().decrementAmount(idProgetto, amount);
        //state.decrementAmount(a);
        progettoRepository.save(progetto);
    }

    /**
     * Metodo usato dall'esperto per ricevere tutti i progetti in stato di Waiting
     * @return tutti i progetti in stato di Waiting
     */
    @Override
    public List<Progetto> getAllProgettiValutare(){
        List<Progetto> progettidavalutare= progettoRepository.findAll();
        List<Progetto> app=new ArrayList<>();
        for(Progetto p : progettidavalutare){
            if(p.getState() instanceof Waiting) app.add(p);
        }
        return app;
    }

    /**
     * metodo per ottenere la lista di tutti i candidati di un progetto
     * @param idProgetto progetto
     * @return lista di progettisti candidati
     */
    @Override
    public List<Progettista> getCandidati(Long idProgetto){
        Progetto p=progettoRepository.findById(idProgetto).orElseThrow(NoSuchElementException::new);
        List<Progettista> lProgettisti = new ArrayList<>();
        for(Long idProgettista : p.getCandidati()){
            lProgettisti.add(progettistaService.getProgettista(idProgettista));
        }
        return lProgettisti;
    }
}
