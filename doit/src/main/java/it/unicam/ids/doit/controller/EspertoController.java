package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.EspertoService;
import it.unicam.ids.doit.service.UserHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/api/esperto/")
public class EspertoController {

    @Autowired
    private EspertoService espertoService;
    @Autowired
    private UserHandlerService userHandlerService;

    /**
     * metodo che ricerca tutti i progetti che sono i stato di Waiting
     * @return lista dei progetti da valutare
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/getprogettidavalutare/")
    @ResponseBody
    public List<Progetto> getprogettidavalutare(@RequestParam @NotNull Long idEsperto, @RequestParam @NotNull Long token ){
        if(userHandlerService.check(idEsperto,token))   return espertoService.getAllProgettiValutare();
        return null;
    }

    /**
     * ottiene nel dettaglio uno dei progetti da valutare
     * @param id id del progetto
     * @return progetto con l'id, ritorna tutti i dati
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/getprogettidavalutare/{id}")
    @ResponseBody
    public Progetto getprogetto(@PathVariable Long id, @RequestParam @NotNull Long idEsperto , @RequestParam @NotNull Long token ){
        if(userHandlerService.check(idEsperto,token))  return espertoService.getProgetto(id);
        return null;
    }

    /**
     * metodo che permette di far passare un progetto dallo stato di attesa a quello di successo
     * @param idProgetto id progetto accettato
     * @param idEsperto id di colui che ha accettato
     * @return errore oppure messaggio di successo
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/getprogettidavalutare/{idProgetto}/confirm")
    @ResponseBody
    public String confirmProgetto(@PathVariable Long idProgetto, @RequestParam @NotNull Long idEsperto,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(idEsperto,token)) {
                espertoService.confirmProgetto(idProgetto, idEsperto);
                return "success";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * metodo che permette di far passare un progetto dallo stato di attesa a quello di blocked
     * @param idProgetto id progetto rifiutato
     * @param idEsperto id di colui che ha rifiutato
     * @return errore oppure messaggio di successo
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/getprogettidavalutare/{idProgetto}/decline")
    @ResponseBody
    public String declineProgetto(@PathVariable Long idProgetto, @RequestParam @NotNull Long idEsperto,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(idEsperto,token)) {
                espertoService.declineProgetto(idProgetto, idEsperto);
                return "success";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Rimozione dell'esperto dal sistema
     * @param idEsperto id del esperto da eliminare
     * @return messaggio di successo o insuccesso
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value="/remove")
    @ResponseBody
    public String removeAccount(@RequestParam @NotNull Long idEsperto,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(idEsperto,token)) {
                espertoService.deleteEsperto(idEsperto);
                return "Eliminato correttamente";
            }
            return "Not logged";
        }catch (Exception e){
            return e.getMessage();
        }
    }



}
