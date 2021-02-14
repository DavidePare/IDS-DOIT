package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.EspertoService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.impl.EspertoServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/api/esperto/")
public class EspertoController {

    @Autowired
    private ProgettoService progettoService;
    @Autowired
    private EspertoService espertoService;

    /**
     * metodo che ricerca tutti i progetti che sono i stato di Waiting
     * @return lista dei progetti da valutare
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/getprogettidavalutare/")
    @ResponseBody
    public List<Progetto> getprogettidavalutare(/*@RequestParam Long idEsperto*/){
        return progettoService.getAllProgettiValutare();
    }

    /**
     * ottiene nel dettaglio uno dei progetti da valutare
     * @param id id del progetto
     * @return progetto con l'id, ritorna tutti i dati
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/getprogettidavalutare/{id}")
    @ResponseBody
    public Progetto getprogetto(@PathVariable Long id){
        return progettoService.getProgetto(id);
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
    public String confirmProgetto(@PathVariable Long idProgetto, @RequestParam @NotNull Long idEsperto){
        try {
            espertoService.confirmProgetto(idProgetto,idEsperto);
            return "success";
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
    public String declineProgetto(@PathVariable Long idProgetto, @RequestParam @NotNull Long idEsperto){
        try{
            espertoService.declineProgetto(idProgetto, idEsperto); //TODO se mettiamo confirm e decline dentro al service dell'esperto?
            return "success";
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
    public String removeAccount(@RequestParam @NotNull Long idEsperto){
        try{
            espertoService.deleteEsperto(idEsperto);
            return "Eliminato correttamente";
        }catch (Exception e){
            return e.getMessage();
        }
    }



}
