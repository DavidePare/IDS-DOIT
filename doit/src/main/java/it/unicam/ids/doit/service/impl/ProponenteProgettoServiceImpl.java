package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProponenteProgettoRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.ProponenteProgetto;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.ProponenteProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProponenteProgettoServiceImpl implements ProponenteProgettoService {

    @Autowired
    private ProponenteProgettoRepository propProgRepository;


    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ProgettistaService progettistaService;

    @Override
    public ProponenteProgetto createProponenteProgetto(String name, String surname){
        ProponenteProgetto prop =new ProponenteProgetto(name,surname);
        propProgRepository.save(prop);
        return prop;
    }

    /**
     * Rimozione proponente progetto , verranno rimossi tutti i suoi progetti
     * @param idPropProgetto proponente progetto rimosso
     */
    @Override
    public void deleteProponenteProgetto(Long idPropProgetto){
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        if(!prop.getProgettiGestiti().isEmpty()) prop.getProgettiGestiti().
                forEach(p -> progettoService.deleteProgetto(p.getId()));
        propProgRepository.delete(prop);
    }

    /**
     * Metodo per ottenere un proponente progetto
     * @param id proponente ricercato
     * @return proponente progetto ricercato
     */

    @Override
    public ProponenteProgetto getProponenteProgetto(Long id){
        return propProgRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Metodo per ottenere tutti i proponenti progetto
     * @return lista contente tutti i proponenti progetto
     */
    @Override
    public List<ProponenteProgetto> getAllProponentiProgetto() {
        return propProgRepository.findAll();
    }

    /**
     * Aggiunta di un progetto da parte del proponente progetto
     * @param idPropProgetto proponente progetto che cha creato il progetto
     * @param idProgetto progetto istanziato
     */
    @Override
    public void addProgettoGestito(Long idPropProgetto, Long idProgetto) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progetto p= progettoService.getProgetto(idProgetto);
        if(!prop.getProgettiGestiti().contains(p)) {
            prop.getProgettiGestiti().add(p);
            propProgRepository.save(prop);
        }
    }

    /**
     * Proponente progetto decidere di rimuovere un suo progetto
     * @param idPropProgetto proponente progetto che rimuove il progett o
     * @param idProgetto progetto rimosso
     */
    @Override
    public void removeProgettoGestito(Long idPropProgetto, Long idProgetto) {
        //TODO manca la rimozione del progetto da tutte le diverse liste, viene richiamato forse da progetto???
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progetto p = progettoService.getProgetto(idProgetto);
        if(prop.getProgettiGestiti().stream().anyMatch(t-> t.getId().equals(idProgetto))){
            prop.getProgettiGestiti().removeIf(t -> t.getId().equals(idProgetto));

            propProgRepository.save(prop);
        }
    }

    /**
     * Metodo usato per richiamare la creazione di un progetto
     * @param idPropProgetto proponente che crea il progetto
     * @param name del progetto
     * @param nMaxProgettisti che possano partecipare al progetto
     */
    @Override
    public Progetto createProgetto(Long idPropProgetto, String name, int nMaxProgettisti) {
        Progetto p = progettoService.createProgetto(idPropProgetto,name,nMaxProgettisti);
        addProgettoGestito(idPropProgetto,p.getId());
        return p;
    }

    /**
     * Accettazione candidatura da parte di un proponente progetto nei confronti di un progettista
     * @param idPropProgetto proponente progetto che accetta progettista
     * @param idProgetto progetto del proponente progetto
     * @param idProgettista progettista aggiunto al team
     */
    @Override
    public void acceptCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progetto p = progettoService.getProgetto(idProgetto);
        if(prop.getProgettiGestiti().stream().anyMatch(t-> t.getId().equals(idProgetto)) //filter(t-> t.getProponenteProgettoID().equals(idProgetto)).count()==1
                && p.getCandidati().stream().anyMatch(t-> t.getId().equals(idProgettista))){ //TODO migliorabile
            //progetto.getTeam().addProgettista(progettista);
            teamService.addProgettista(progettoService.getProgetto(p.getId()).getTeam().getId(),idProgettista);
            progettistaService.addTeam(idProgettista,progettoService.getProgetto(p.getId()).getTeam().getId());
            //progetto.removeCandidato(progettista);
            progettoService.removeCandidato(idProgetto,idProgettista);
            //progettista.removeprogettoCandidato(progetto);
            progettistaService.addProgetto(idProgetto,idProgettista);
            progettistaService.removeprogettoCandidato(idProgetto,idProgettista);
        }
    }

    /**
     * Proponente progetto che rifiuta la candidatura di un progettista
     * @param idPropProgetto proponente progetto che rifiuta una candidatura
     * @param idProgetto progetto al quale è stata fatta la candidatura
     * @param idProgettista progettista candidato
     */
    @Override
    public void declineCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progetto p = progettoService.getProgetto(idProgetto);
        if(prop.getProgettiGestiti().stream().anyMatch(t-> t.getId().equals(idProgetto)) &&
                p.getCandidati().stream().anyMatch(t-> t.getId().equals(idProgettista))){
            progettoService.removeCandidato(idProgetto,idProgettista);
            progettistaService.removeprogettoCandidato(idProgetto,idProgettista);
        }
    }

    /**
     * Metodo per invitare un progettista su un progetto
     * @param idPropProgetto proponente progetto che invita
     * @param idProgetto progetto al quale viene invitato un progettista
     * @param idProgettista progettista invitato
     */
    @Override
    public void inviteProgettista(Long idPropProgetto,Long idProgetto,Long idProgettista) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progettista progettista= progettistaService.getProgettista(idProgettista);
        if(prop.getProgettiGestiti().stream().anyMatch(t-> t.getId().equals(idProgetto))
            && progettista.getInviti().stream().noneMatch(t->t.getId().equals(idProgetto))){
            progettistaService.addInvito(idProgetto,idProgettista);
            progettoService.addProgettistaInvitato(idProgetto,idProgettista);
        }
    }

    /**
     * Ritorna tutti i progetti gestiti dal proponente progetto
     * @param idPropProgetto proponente progetto
     * @return lista di tutti i progetti gestiti dal proponente
     */
    @Override
    public List<Progetto> getProgettiGestiti(Long idPropProgetto){
        ProponenteProgetto prop= propProgRepository.findById(idPropProgetto).orElseThrow(NullPointerException::new);
        List<Progetto> listaProgetti=new ArrayList<>();
        if(prop != null) prop.getProgettiGestiti().forEach(p -> listaProgetti.add(progettoService.getProgetto(p.getId())));
        return listaProgetti; //TODO verifica
    }

    /**
     * Rimozione di un progettista da un progetto, rimosso dalla lista del team
     * @param idPropProgetto proponente progetto
     * @param idProgetto progetto dal quale viene rimosso un progettista
     * @param idProgettista progettista da rimuovere
     */
    @Override
    public void removeProgettistaFromProgetto(Long idPropProgetto,Long idProgetto, Long idProgettista){
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progetto p = progettoService.getProgetto(idProgetto);
        teamService.removeProgettista(p.getTeam().getId(), idProgettista, idProgetto);

        progettistaService.getProgettista(idProgettista).notify("Sei stato eliminato dal progetto con id",p.getName(),p.getId());
        //TODO aggiunto da controllare
        progettistaService.removeProgetto(idProgetto,idProgettista);

    }

    /**
     * Metodo che ritorna tutti i componenti di un team
     * @param id progetto di interesse
     * @param idProponente proponente progetto
     * @return progettisti che compongono il team del progetto di interesse
     */
    @Override
    public List<Progettista> getComponentOfTeam(Long id,Long idProponente){
        ProponenteProgetto prop = getProponenteProgetto(idProponente);
        Progetto p = progettoService.getProgetto(id);
        if(p.getProponenteProgettoID().equals(idProponente) && p.getTeam()!=null){
            return new ArrayList<>(p.getTeam().getProgettistiTeam());

        }
        return null; //TODO ritornare eccezione
    }
}
