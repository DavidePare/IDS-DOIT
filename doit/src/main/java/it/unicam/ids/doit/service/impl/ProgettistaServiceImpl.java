package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.CurriculumRepository;
import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.dao.ProgettoRepository;
import it.unicam.ids.doit.entity.*;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class ProgettistaServiceImpl implements ProgettistaService {

    @Autowired
    private ProgettistaRepository progettistaRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private TeamService teamService;

    @Override
    public Progettista createProgettista(String name, String surname){
        Progettista p=new Progettista(name,surname);
        progettistaRepository.save(p);
        return p;
    }

    @Override
    public Progettista createProgettista(String name, String surname,String email, String password){
        Progettista p=new Progettista(name,surname,email,password);
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
                forEach(pc -> progettoService.removeCandidato(pc.getId(),idProgettista));
        if(!p.getTeamsProgettista().isEmpty()) p.getTeamsProgettista().
                forEach(t -> teamService.removeProgettista(t.getId(),idProgettista,t.getProgettoID()));
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
            Set<WorkingExperienceCurriculum> appoggio = progettista.getCurriculum().getWorkingExperience();
            appoggio.add(new WorkingExperienceCurriculum(experience));
            progettista.getCurriculum().setWorkingExperience(appoggio);
            Curriculum c= progettista.getCurriculum();
            curriculumRepository.save(c);
           // progettistaRepository.save(progettista);
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
            Set<WorkingExperienceCurriculum> appoggio = progettista.getCurriculum().getWorkingExperience();
            appoggio.removeIf(t-> t.getWorkingExperience().compareTo(experience)==0);
            progettista.getCurriculum().setWorkingExperience(appoggio);
            Curriculum c= progettista.getCurriculum();
            curriculumRepository.save(c);
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
            Set<LanguagesCurriculum> appoggio = progettista.getCurriculum().getLanguages();
            appoggio.add(new LanguagesCurriculum(language));
            progettista.getCurriculum().setLanguages(appoggio);
            curriculumRepository.save(progettista.getCurriculum());
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
            Set<LanguagesCurriculum> appoggio = progettista.getCurriculum().getLanguages();
            appoggio.removeIf(t-> t.getLanguage().compareTo(language)==0);
            progettista.getCurriculum().setLanguages(appoggio);
            curriculumRepository.save(progettista.getCurriculum());
        }
    }

    @Override
    public void addProgetto(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        if(progettista.getProgettiProgettista().stream().noneMatch(t-> t.getId().equals(idProgetto))) {
            progettista.getProgettiProgettista().add(progetto);
            progettistaRepository.save(progettista);
        }

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
        progettista.getProgettiProgettista().removeIf(t-> t.getId().equals(idProgetto));
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
        if(progettista.getInviti().stream().noneMatch(t-> t.getId().equals(progetto.getId()))) {
            progettista.getInviti().add(progetto);
            progettistaRepository.save(progettista);
        }
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
        if(progettista.getInviti().stream().anyMatch(t-> t.getId().equals(idProgetto))) {
           // teamService.addProgettista(progetto.getTeam().getId(), idProgettista);
            progettista.getInviti().removeIf(t-> t.getId().equals(progetto.getId()));
            teamService.addProgettista(progetto.getTeam().getId(), idProgettista);
            progettista.getTeamsProgettista().add(progetto.getTeam());
            progettista.getProgettiProgettista().add(progetto);
            progettoService.removeProgettistaInvitato(idProgetto,idProgettista);
            progettistaRepository.save(progettista);
        }

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
        if(progettista.getInviti().stream().anyMatch(t-> t.getId().equals(idProgetto))){
            progettista.getInviti().removeIf(t -> t.getId().equals(idProgetto));
            progettoService.removeProgettistaInvitato(idProgetto,idProgettista);
            progettistaRepository.save(progettista);
        }
    }

    @Override
    public void addTeam(Long idProgettista, Long idTeam){
        Progettista progettista = getProgettista(idProgettista);
        progettista.getTeamsProgettista().add(teamService.getTeam(idTeam));
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
        progettista.getTeamsProgettista().removeIf(t-> t.getId().equals(idTeam));
        progettistaRepository.save(progettista);
    }

    @Override
    public void addprogettoCandidato(Long idProgetto, Long idProgettista){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        if(progettista.getProgettiCandidati().stream().noneMatch(t-> t.getId().equals(idProgetto))){
            progettista.getProgettiCandidati().add(progettoService.getProgetto(idProgetto));
            progettistaRepository.save(progettista);
        }
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
        progettista.getProgettiCandidati().removeIf(p -> p.getId().equals(idProgetto));
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
        if(progettista.getProgettiCandidati().contains(progettoService.getProgetto(idProgetto))){ //TODO Test
            return false;
        }
        Progetto p=progettoService.getProgetto(idProgetto);
        if( progettoService.addCandidato(p.getId(), progettista.getId())) {
            progettista.getProgettiCandidati().add(p);
            progettistaRepository.save(progettista);
        }
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
        return getProgettista(idProgettista).getProgettiCandidati();
    }

    /**
     * Metodo per la creazione di un curriculum
     * @param idProgettista progettista
     * @param instruction dove ha studiato
     * @param formation formazione
     * @param phone telefono
     * @param email email
     */
    @Override
    public void createCurriculum(Long idProgettista , String instruction, String formation, Number phone,String email){
        Progettista p=getProgettista(idProgettista);
        p.addCurriculum(idProgettista,instruction,formation,phone,email);
        progettistaRepository.save(p);
    }
}
