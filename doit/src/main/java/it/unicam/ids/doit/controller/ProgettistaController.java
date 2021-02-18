package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Curriculum;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.ProgettistaService;
<<<<<<< Updated upstream
import it.unicam.ids.doit.service.UserHandlerService;
=======
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.UserHandlerService;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/progettista/")
public class ProgettistaController {
    @Autowired
    ProgettistaService progettistaService;

    @Autowired
    private UserHandlerService userHandlerService;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    @Autowired
    private UserHandlerService userHandlerService;

>>>>>>> Stashed changes
=======
    @Autowired
    private UserHandlerService userHandlerService;

>>>>>>> Stashed changes
    @PostMapping(value="/addprogettista")
    public Progettista addProgettista(@RequestParam @NotNull String name, @RequestParam @NotNull String surname, @RequestParam String email, @RequestParam @NotNull Long token){
        return progettistaService.createProgettista(name,surname,email, "");
    }
/*
    @GetMapping(value="/getprogettista/{id}")
    @ResponseBody
    public Progettista getProgettista(@PathVariable Long id){
        return progettistaService.getProgettista(id);
    }

    @GetMapping(value="/getprogettista/")
    @ResponseBody
    public List<Progettista> getProgettisti(){
        return progettistaService.getAllProgettisti();
    }
*/

    /**
     * Richiesta per la rimozione del progettista dal sistema
     * @param id progettista che si vuole eliminare
     * @return messaggio di insuccesso o di errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping (value="/{id}/remove")
    @ResponseBody
    public String removeProgettista(@PathVariable @NotNull Long id,@RequestParam @NotNull Long token){ //TODO ci vorrà una verifica dell utenet!
        try{
            if(userHandlerService.check(id,token)) {
                progettistaService.deleteProgettista(id);
                return "Success";
            }
            return "Not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Aggiunta curriculum al progettista
     * @param id progettista
     * @param phone telefono
     * @param instruction istruzione
     * @param formaction formazione
     * @return successo o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value ="/{id}/addcurriculum/")
    @ResponseBody
    public String addCurriculum(@PathVariable @NotNull Long id,@RequestParam Number phone,@RequestParam  String instruction,
                                @RequestParam String formaction,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(id,token)){
                progettistaService.createCurriculum(id, instruction, formaction, phone, "email");
                return "success";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    /**
     * Richiesta del curriculum del progettista
     * @param id progettista
     * @return curriculum del progettista
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping (value ="/{id}/curriculum/")
    @ResponseBody
    public Curriculum getCurriculum(@PathVariable @NotNull Long id,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                return progettistaService.getCurriculum(id);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Aggiunta di esperienze lavorative dal curriculum di un progettista
     * @param id progettista
     * @param experience esperienze da aggiungere alla lista delle esperienze
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping (value="/{id}/curriculum/addworkingexperience/")
    @ResponseBody
    public String addWorkingExperience(@PathVariable @NotNull Long id, @RequestParam String experience,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                progettistaService.addWorkingExperience(id, experience);
                return "success";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Rimozione di esperienze lavorative dal curriculum di un progettista
     * @param id progettista
     * @param experience esperienze da rimuovere dalla lista delle esperienze
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping (value="/{id}/curriculum/removeworkingexperience/")
    @ResponseBody
    public String removeWorkingExperience(@PathVariable @NotNull Long id, @RequestParam String experience,@RequestParam @NotNull Long token){
        try{

            if(userHandlerService.check(id,token)) {
                progettistaService.addWorkingExperience(id, experience);
                return "success";
            }
            return "not logged!";
        }catch(Exception e){
            return e.getMessage();
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping (value="/{id}/inviti/")
    @ResponseBody
    public List<Progetto> getInviti(@PathVariable @NotNull Long id,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                return progettistaService.getInviti(id);
            }
            return null;
        }catch (Exception e) {
            return null;
        }
    }

    /**
     * Accettazione dell'invito del progettista
     * @param id progettista
     * @param idProgetto progetto da accettare
     * @return messaggio di successo o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping (value="/{id}/inviti/accept/")
    @ResponseBody
    public String accpetInvite(@PathVariable @NotNull Long id, @RequestParam @NotNull Long idProgetto,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                progettistaService.acceptInvito(idProgetto, id);
                return "Invito accettato";
            }
            return "not logged";
        }catch (Exception e){
            return "Errore non è stato possibile completare la sua operazione!";
        }
    }

    /**
     * Rrifiuto dell'invito da parte del progettista
     * @param id progettista
     * @param idProgetto progetto da rifiutare
     * @return messaggio di successo o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping (value="/{id}/inviti/decline/")
    @ResponseBody
    public String refuseInvite(@PathVariable @NotNull Long id, @RequestParam @NotNull Long idProgetto,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                progettistaService.refuseInvito(idProgetto, id);
                return "Invito rifiutato correttamente";
            }
            return "not logged";
        }catch (Exception e){
            return "Errore non è stato possibile completare la sua operazione!";
        }
    }
    /**
     * Aggiunta di una lingua dal curriculum di un progettista
     * @param id progettista
     * @param language lingua da aggiungere alla lista delle lingue
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping (value="/{id}/curriculum/addlanguage/")
    @ResponseBody
    public String addLanguage(@PathVariable @NotNull Long id, @RequestParam String language,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)){
                progettistaService.addLanguages(id,language);
                return "success";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Rimozione di una lingua dal curriculum di un progettista
     * @param id progettista
     * @param language lingua da rimuovere dalla lista delle lingue
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping (value="/{id}/curriculum/removelanguage/")
    @ResponseBody
    public String removeLanguage(@PathVariable @NotNull Long id, @RequestParam String language,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                progettistaService.removeLanguages(id, language);
                return "success";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Visualizzazione di tutti i progetti
     * @param id idprogettista
     * @return tutti i progetti dell'utente
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping (value="/{id}/getprogetti/")
    @ResponseBody
    public List<Progetto> getProgetti(@PathVariable @NotNull Long id,@RequestParam @NotNull Long token){
        //TODO quando visualizza tutti i progetti se su uno è già candidato ha metodo elimina candidatura
        if(userHandlerService.check(id,token)){
<<<<<<< Updated upstream
<<<<<<< Updated upstream
            return userHandlerService.getAllProgetti();
=======
            return progettoService.getAllProgetti();
>>>>>>> Stashed changes
=======
            return progettoService.getAllProgetti();
>>>>>>> Stashed changes
        }
        return null;
    }


    /**
     * Visualizzazione di un progetto
     * @param idProgetto da visualizzare
     * @param id progettista
     * @return progetto da visualizzare
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping (value="/{id}/getprogetti/{idProgetto}")
    @ResponseBody
    public Progetto getProgetto(@PathVariable @NotNull Long idProgetto, @PathVariable Long id,@RequestParam @NotNull Long token){
        if(userHandlerService.check(id,token)){
<<<<<<< Updated upstream
<<<<<<< Updated upstream
            return userHandlerService.getProgetto(idProgetto);
=======
            return progettoService.getProgetto(idProgetto);
>>>>>>> Stashed changes
=======
            return progettoService.getProgetto(idProgetto);
>>>>>>> Stashed changes
        }
        return null;
    }

    /**
     * Invio della candidatura verso un progetto
     * @param idProgetto progetto al quale si vuole candidare il progettista
     * @param id progettista che si vuole candidare
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/{id}/getprogetti/{idProgetto}/sendcandidatura/")
    @ResponseBody
    public String sendcandidatura(@PathVariable @NotNull Long idProgetto , @PathVariable @NotNull Long id,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                if (progettistaService.sendCandidatura(idProgetto, id)) return "invio canddidatura effettuato";
                return "Già candidato!";
            }
            return "not logged";
        }catch(Exception e){
            return "candidatura non effettuata correttamente";
        }
    }


    /**
     * Ottiene tutti i progetti al quale un progettista è candidato
     * @param id del progettista
     * @return tutte le candidature del progettista
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/{id}/getcandidature/")
    @ResponseBody
    public List<Progetto> getcandidature(@PathVariable @NotNull Long id,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(id,token)) {
                return progettistaService.getCandidature(id);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Ottiene un progetto al quale si è candidato
     * @param id del progettista
     * @param idProgetto al quale si candidat
     * @return il progetto selezionato
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/{id}/getcandidature/{idProgetto}/")
    @ResponseBody
    public Progetto getprogettocandidato(@PathVariable @NotNull Long id,@PathVariable @NotNull Long idProgetto,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(id,token)) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
                return userHandlerService.getProgetto(id);
=======
                return progettoService.getProgetto(id);
>>>>>>> Stashed changes
=======
                return progettoService.getProgetto(id);
>>>>>>> Stashed changes
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Progettista che rimuove una candidatura dal progetto
     * @param id progettista
     * @param idProgetto al quale viene rimossa la candidatura
     * @return messaggio di successo / insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value="/{id}/getcandidature/{idProgetto}/remove")
    @ResponseBody
    public String uscitadaprogettocandidato(@PathVariable @NotNull Long id,@PathVariable @NotNull Long idProgetto,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(id,token)){
                progettistaService.removeprogettoCandidato(idProgetto,id);
                return "success";
            }
            return "not logged";
        }catch(Exception e){
            return "Errore";
        }
    }

    /**
     * Rimozione da un progetto di appartenenza
     * @param idProgetto progetto al quale si desidera rimuoversi
     * @param id progettista che si rimuove
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value="/{id}/getcandidature/{idProgetto}/removecandidatura/")
    @ResponseBody
    public String removecandidatura(@PathVariable @NotNull Long idProgetto , @PathVariable @NotNull Long id,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                progettistaService.removeprogettoCandidato(idProgetto, id);
                return "Rimozione avvenuta correttamente";
            }
            return "Not logged";
        }catch(Exception e){
            return "Errore";
        }
    }

    /**
     * Visualizzazione di tutti i progetti attivi di un progettista
     * @param id progettista
     * @return tutti i progetti attivi di quel progettista
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/{id}/getprogettiattivi/")
    @ResponseBody
    public List<Progetto> getProgettiProgettista(@PathVariable @NotNull Long id){
        try{
            return progettistaService.getProgettiAttivi(id);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Visualizzazione di un progetto al quale il progettista partecipa
     * @param id progettista di interesse
     * @param idProgetto progetto di interesse
     * @return il progetto di interesse
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/{id}/getprogettiattivi/{idProgetto}")
    @ResponseBody
    public Progetto getProgettoProgettista(@PathVariable @NotNull Long id,@PathVariable @NotNull Long idProgetto) {
        try {
            return userHandlerService.getProgetto(idProgetto);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Uscita dal progetto da parte del progettista
     * @param id progettista che effettua l uscita
     * @param idProgetto progetto dal quale esce
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value="/{id}/getprogettiattivi/{idProgetto}/remove")
    @ResponseBody
    public String removeProgetto(@PathVariable @NotNull Long id,@PathVariable @NotNull Long idProgetto) {
        try {
            progettistaService.removeProgetto(idProgetto,id);
            return "Rimozione avvenuta con successo";
        } catch (Exception e) {
            return "Errore";
        }
    }

}
