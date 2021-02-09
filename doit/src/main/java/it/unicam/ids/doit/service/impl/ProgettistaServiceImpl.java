package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.entity.Curriculum;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Team;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProgettistaServiceImpl implements ProgettistaService {

    @Autowired
    private ProgettistaRepository progettistaRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private TeamService teamService;

    @Override
    public Progettista createProgettista(String name, String surname){
        Progettista p=new Progettista(name,surname);
        progettistaRepository.save(p);
        return p;
    }

    /**
     * Metodo che rimuove il progettista dal sistema la rimozione dovrà avvenire per ogni lista nella quale il progettista
     * può essere salvato
     * @param idProgettista id del progettista da eliminare
     */
    @Override
    public void deleteProgettista(Long idProgettista){
        Progettista p = getProgettista(idProgettista);
        if(!p.getInviti().isEmpty()) p.getInviti().forEach(pr -> progettoService.removeProgettistaInvitato(pr.getId(),idProgettista));
        if(!p.getProgettiCandidati().isEmpty()) p.getProgettiCandidati().
                forEach(pc -> progettoService.removeCandidato(pc,idProgettista));
        if(!p.getTeamsProgettista().isEmpty()) p.getTeamsProgettista().
                forEach(t -> teamService.removeProgettista(t,idProgettista));
        progettistaRepository.delete(p);
    }

    /**
     * Ricerca di un progettista per id
     * @param id progettista ricercato
     * @return progettista
     */
    @Override
    public Progettista getProgettista(Long id){
        return progettistaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Richiesta della lista di tutti i progettisti
     * @return tutti i progetti
     */
    @Override
    public List<Progettista> getAllProgettisti(){
        return progettistaRepository.findAll();
    }

    /**
     * Aggiunta di esperienze lavorative nel curriculum del progettista
     * @param id progettista che effettua modifiche
     * @param experience esperienze lavorative da aggiungere
     */
    @Override
    public void addWorkingExperience(Long id,String experience){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getWorkingExperience();
            appoggio.add(experience);
            progettista.getCurriculum().setWorkingExperience(appoggio);
            progettistaRepository.save(progettista);
        }
    }

    /**
     * Rimozione di esperienze lavorative nel curriculum del progettista
     * @param id progettista che effettua modifiche
     * @param experience da eliminare dalla lista
     */
    @Override
    public void removeWorkingExperience(Long id,String experience){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getWorkingExperience();
            appoggio.remove(experience);
            progettista.getCurriculum().setWorkingExperience(appoggio);
            progettistaRepository.save(progettista);
        }
    }

    /**
     * Aggiunta di lingue parlate nel curriculum del progettista
     * @param id progettista
     * @param language lingua da aggiungere
     */
    @Override
    public void addLanguages(Long id,String language){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getLanguages();
            appoggio.add(language);
            progettista.getCurriculum().setLanguages(appoggio);
            progettistaRepository.save(progettista);
        }
    }

    /**
     * Rimozione di una lingua parlata nel curriculum del progettista
     * @param id progettista
     * @param language lingua da rimuovere
     */
    @Override
    public void removeLanguages(Long id,String language){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getLanguages();
            appoggio.remove(language);
            progettista.getCurriculum().setLanguages(appoggio);
            progettistaRepository.save(progettista);
        }
    }

    @Override
    public void addProgetto(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiProgettista().add(progetto);
        progettistaRepository.save(progettista);

    }

    /**
     * Rimozione di un progetto dalla lista del progettista
     * @param idProgetto progetto da rimuovere dalla lista
     * @param idProgettista progettista che subisce la rimozione del progetto
     */
    @Override
    public void removeProgetto(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiProgettista().remove(progetto);
        //TODO aggiunto da ricontrollare
        removeTeam(idProgettista,progetto.getTeam().getId());
        //progettoRepository.save(progetto);
        progettistaRepository.save(progettista);
    }

    /**
     * Invito al progettista da parte di un proponente Progetto (N)
     * @param idProgetto del progetto dell'invito
     * @param idProgettista del progettista invitato
     */
    @Override
    public void addInvito(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getInviti().add(progetto);
        progettistaRepository.save(progettista);
    }

    /**
     * Metodo per accettare un invito nella casella del progettista
     * @param idProgetto progetto da accettare
     * @param idProgettista progettista che accetta il progetto
     */
    @Override
    public void acceptInvito(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        teamService.addProgettista(progetto.getTeam().getId(),idProgettista);
        progettista.getInviti().remove(progetto);
        progettista.getProgettiProgettista().add(progetto);
        progettistaRepository.save(progettista);

    }

    /**
     * Metodo per rifiutare un invito nella casella del progettista
     * @param idProgetto progetto da rifiutare
     * @param idProgettista profettista che rifiuta il progetto
     */
    @Override
    public void refuseInvito(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getInviti().remove(progetto);
        progettistaRepository.save(progettista);
    }

    @Override
    public void addTeam(Long idProgettista, Long idTeam){
        Progettista progettista = getProgettista(idProgettista);
        progettista.getTeamsProgettista().add(idTeam);
        progettistaRepository.save(progettista);

    }

    /**
     * Rimozione del progettista da un team a cui appartiene
     * @param idProgettista progettista che viene rimosso dal team
     * @param idTeam team al quale il progettista decide di rimuoversi
     */
    @Override
    public void removeTeam(Long idProgettista, Long idTeam){
        Progettista progettista = getProgettista(idProgettista);
        progettista.getTeamsProgettista().remove(idTeam);
        progettistaRepository.save(progettista);
    }

    //TODO cosa differisce da sendcandidatura???
    @Override
    public void addprogettoCandidato(Long idProgetto, Long idProgettista){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiCandidati().add(idProgetto);
        progettistaRepository.save(progettista);
    }

    /**
     * Rimozione di un progetto a cui si è candidato
     * @param idProgetto id del progetto al quale viene rimosso
     * @param idProgettista progettista che si rimuove
     */
    @Override
    public void removeprogettoCandidato(Long idProgetto, Long idProgettista){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiCandidati().remove(idProgetto);
        progettistaRepository.save(progettista);
    }


    /**
     * Invio della candidatura verso un progetto da parte di un progettista
     * @param idProgetto progetto al quale ci si vuole candidare
     * @param idProgettista progettista che si vuole candidare al progetto
     * @return ritorna l esito della candidatura
     */
    @Override
    public boolean sendCandidatura(Long idProgetto, Long idProgettista){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        if(progettista.getProgettiCandidati().contains(idProgetto)){
            return false;
        }
        progettoService.addCandidato(idProgetto, idProgettista);
        progettista.getProgettiCandidati().add(idProgetto);
        progettistaRepository.save(progettista);
        return true;
    }


    /**
     * Metodo che rida il curriculum del progettista
     * @param id del progettista
     * @return curriculum del progettista con quell id
     */
    @Override
    public Curriculum getCurriculum(Long id){
        try {
            Progettista p= progettistaRepository.findById(id).orElseThrow(NullPointerException::new);
            return p.getCurriculum();
        }catch(Exception e){
            return null;
        }
    }


    /**
     * Metodo che ritorna tutti gli inviti ricevuti dal progettista
     * @return lista di tutti i progetti a cui il progettista è stato invitato
     */

    @Override
    public List<Progetto> getInviti(Long idProgettista){
        return progettistaRepository.findById(idProgettista).orElseThrow(NullPointerException::new).getInviti();
    }


    /**
     * Metodo che ritorna tutti i progetti attivi dal progettista
     * @param idProgettista progettista del quale si vogliono vedere i progetti
     * @return tutti i progetti al quale partecipa il progettista
     */
    @Override
    public List<Progetto> getProgettiAttivi(Long idProgettista){
        return progettistaRepository.findById(idProgettista).orElseThrow(NullPointerException::new).getProgettiProgettista();
    }


    /**
     * Metodo che ritorna tutti i progetti al quale un progettista è candidato
     * @param idProgettista progettista
     * @return lista di progetti al quale il progettista è candidato
     */
    @Override
    public List<Progetto> getCandidature(Long idProgettista){
        List<Progetto> lProgetti= new ArrayList<>();
        for(Long idProgetto : progettistaRepository.findById(idProgettista).orElseThrow(NullPointerException::new).getProgettiCandidati()){
            lProgetti.add(progettoService.getProgetto(idProgetto));
        }
        return lProgetti;
    }

}