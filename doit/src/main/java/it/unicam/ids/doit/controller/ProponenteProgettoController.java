package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import it.unicam.ids.doit.service.impl.ProponenteProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/propProgetto/")
public class ProponenteProgettoController {
    @Autowired
    ProponenteProgettoServiceImpl propProgettoService;
    @Autowired
    ProgettistaServiceImpl progettistaService;
    @Autowired
    ProgettoServiceImpl progettoService;

    /**
     * Ottenere tutti i progetti gestiti dal proponente progetto
     * @param idProponente id del proponente
     * @return ottiene tutti i progetti gestiti
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/progettigestiti/")
    @ResponseBody
    public List<Progetto> getprogettigestiti(@RequestParam @NotNull Long idProponente){
        return propProgettoService.getProgettiGestiti(idProponente);
    }

    /**
     * Prende progetto per id passato nel path
     * @return lista di tutti i progettisti
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/progettigestiti/{id}/invite")
    @ResponseBody
    public List<Progettista> getprogettisti(){
        return progettistaService.getAllProgettisti();
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
    public String invite(@PathVariable Long id , @PathVariable Long idProgettista, @RequestParam @NotNull Long idProp){
        try {
            propProgettoService.inviteProgettista(idProp, id, idProgettista);
            return "success";
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
    public List<Progettista> getcandidati(@PathVariable Long id) {
        try {
            return progettoService.getCandidati(id);
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
    public String acceptCandidato(@PathVariable @NotNull Long id, @PathVariable @NotNull Long idCandidato, @RequestParam Long idProponente) {
        try {
            propProgettoService.acceptCandidatura(idProponente, id, idCandidato);
            return "Accettato!";
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
    public String declineCandidato(@PathVariable @NotNull Long id, @PathVariable @NotNull Long idCandidato, @RequestParam Long idProponente) {
        try {
            propProgettoService.declineCandidatura(idProponente, id, idCandidato);
            return "Rifiutato!";
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
    public String removeProgetto(@PathVariable Long id,@RequestParam @NotNull Long idProponente){
        try {
            propProgettoService.removeProgettoGestito(idProponente, id);
            return "Rimosso";
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
    public List<Progettista> getTeam(@PathVariable Long id, @RequestParam @NotNull Long idProponente ){
        try{
            return propProgettoService.getComponentOfTeam(id,idProponente);
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
    public Progettista getProgettista(@PathVariable Long idProgettista,@RequestParam @NotNull Long idProponente, @PathVariable Long id){
        try{
            return progettistaService.getProgettista(idProgettista);
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
    public String removeProgettistaFromProgetto(@PathVariable Long id,@RequestParam @NotNull Long idProponente, @PathVariable Long idProgettista){
        try{
            propProgettoService.removeProgettistaFromProgetto(idProponente,id,idProgettista);
            return "Success";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/createProgetto/")
    @ResponseBody
    // @ResponseStatus(HttpStatus.OK)
    public Progetto createProgetto(@NotNull @RequestParam Long idProponenteProgetto, @NotNull @RequestParam String name , @RequestParam int nMaxProgettisti){
        try {
            return propProgettoService.createProgetto(idProponenteProgetto, name, nMaxProgettisti);
            //return "success";
        }catch(Exception e){
            return null;//e.getMessage();
        }
    }
}
