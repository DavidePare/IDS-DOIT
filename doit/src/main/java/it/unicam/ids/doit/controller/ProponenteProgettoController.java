package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.UserHandlerService;
import it.unicam.ids.doit.service.impl.ProponenteProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propProgetto/")
public class ProponenteProgettoController {
    @Autowired
    ProponenteProgettoServiceImpl propProgettoService;
    @Autowired
    UserHandlerService userHandlerService;

    /**
     * Ottenere tutti i progetti gestiti dal proponente progetto
     * @param idProponente id del proponente
     * @return ottiene tutti i progetti gestiti
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/progettigestiti/")
    @ResponseBody
    public List<Progetto> getprogettigestiti(@RequestParam @NotNull Long idProponente,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(idProponente,token)) {
                return propProgettoService.getProgettiGestiti(idProponente);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Prende progetto per id passato nel path
     * @return lista di tutti i progettisti che può invitare su quel progetto
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/progettigestiti/{id}/invite")
    @ResponseBody
    public List<Progettista> getprogettisti(@PathVariable @NotNull Long id,@RequestParam @NotNull Long idProponente,@RequestParam @NotNull Long token){
        try {
            if (userHandlerService.check(idProponente, token)) {
                return propProgettoService.getInvitableProgettisti(id, idProponente);
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * invito del progettista
     * @param id id del progetto
     * @param idProgettista id del progettista da invitarmi
     * @param idProp id del proponente progetto
     * @return messaggio di validazione o no
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/progettigestiti/{id}/invite/{idProgettista}")
    @ResponseBody
    public String invite(@PathVariable Long id , @PathVariable Long idProgettista, @RequestParam @NotNull Long idProp,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(idProp,token)) {
                propProgettoService.inviteProgettista(idProp, id, idProgettista);
                return "success";
            }
            return "not logged";
        }catch (Exception e){
            return e.getMessage();
        }
    }


    /**
     * ottenere la lista dei candidati ad un progetto
     * @param id id del progetto
     * @return lista progettisti
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/progettigestiti/{id}/candidati")
    @ResponseBody
    public List<Progettista> getcandidati(@PathVariable Long id,@RequestParam @NotNull Long token,@RequestParam @NotNull Long idProp) {
        try {
            if(userHandlerService.check(idProp,token)) {
                return propProgettoService.getCandidatiProgetto(id);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Proponete progetto accetta la candidatura del candidato X
     * @param id id del progetto
     * @param idCandidato id del candidato X
     * @param idProponente id del proponente progetto
     * @return messaggio di validazione o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/progettigestiti/{id}/candidati/{idCandidato}/accept")
    @ResponseBody
    public String acceptCandidato(@PathVariable @NotNull Long id, @PathVariable @NotNull Long idCandidato, @RequestParam Long idProponente,@RequestParam @NotNull Long token) {
        try {
            if(userHandlerService.check(idProponente,token)) {
                propProgettoService.acceptCandidatura(idProponente, id, idCandidato);
                return "Accettato!";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Proponente progetto rifiuta un candidato
     * @param id del progetto di interesse
     * @param idCandidato del progettista candidato
     * @param idProponente del proponente del progetto
     * @return messaggio di rifiuto o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/progettigestiti/{id}/candidati/{idCandidato}/decline")
    @ResponseBody
    public String declineCandidato(@PathVariable @NotNull Long id, @PathVariable @NotNull Long idCandidato, @RequestParam Long idProponente,@RequestParam @NotNull Long token) {
        try {
            if(userHandlerService.check(idProponente,token)) {
                propProgettoService.declineCandidatura(idProponente, id, idCandidato);
                return "Rifiutato!";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Il proponente progetto rimuove un suo progetto per id
     * @param id del progetto da rimuovere
     * @param idProponente del proponente progetto
     * @return messaggio di corretta rimozione o di errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value= "/progettigestiti/{id}/remove")
    @ResponseBody
    public String removeProgetto(@PathVariable Long id,@RequestParam @NotNull Long idProponente,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(idProponente,token)) {
                propProgettoService.removeProgettoGestito(idProponente, id);
                return "Rimosso";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Visualizzazione di tutti i componenti del team di quel progetot
     * @param id Progetto
     * @param idProponente gestore del progetto
     * @return componenti del team del progetto
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/progettigestiti/{id}/getTeam/")
    @ResponseBody
    public List<Progettista> getTeam(@PathVariable Long id, @RequestParam @NotNull Long idProponente,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(idProponente,token)) {
                return propProgettoService.getComponentOfTeam(id, idProponente);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Visualizzazione di un progettista nello specifico del team
     * @param idProgettista progettista da visualizzare
     * @param idProponente pgestore del progetto
     * @param id progetto
     * @return Progettista
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/progettigestiti/{id}/getTeam/{idProgettista}")
    @ResponseBody
    public Progettista getProgettista(@PathVariable Long idProgettista,@RequestParam @NotNull Long idProponente, @PathVariable Long id,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(idProponente,token)) {
                return userHandlerService.getProgettista(idProgettista);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Rimozione di un componente del team dal progetto
     * @param id Progetto
     * @param idProponente gestore del progetto
     * @param idProgettista progettista che subisce la rimozione
     * @return messaggio di corretta esecuzione o di errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value="/progettigestiti/{id}/getTeam/{idProgettista}/remove")
    @ResponseBody
    public String removeProgettistaFromProgetto(@PathVariable Long id,@RequestParam @NotNull Long idProponente, @PathVariable Long idProgettista,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(idProponente,token)) {
                propProgettoService.removeProgettistaFromProgetto(idProponente, id, idProgettista);
                return "Success";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/createProgetto/")
    @ResponseBody
    // @ResponseStatus(HttpStatus.OK)
    public Progetto createProgetto(@NotNull @RequestParam Long idProponenteProgetto, @NotNull @RequestParam String name , @RequestParam int nMaxProgettisti,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(idProponenteProgetto,token)) {
                return propProgettoService.createProgetto(idProponenteProgetto, name, nMaxProgettisti);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }
}
