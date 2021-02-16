package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.SponsorService;
import it.unicam.ids.doit.service.UserHandlerService;
import it.unicam.ids.doit.service.impl.UserHandlerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sponsor/")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @Autowired
    private UserHandlerService userHandlerService;
    //TODO  assente metodo di ricerca di nuovi progetti per lo sponsor
    /*@PostMapping(value="/addsponsor")
    public Sponsor addSponsor(@RequestParam @NotNull String name){
        return sponsorService.createSponsor(name);
    }*/

    /**
     * Metodo che ritorna tutti i progetti dello sponsor
     * @param id dello sponsor
     * @return tutti i progetti in cui ha investito uno sponsor
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value= "/progettisponsor/")
    @ResponseBody
    public List<Progetto> getProgettiSponsor(@RequestParam @NotNull Long id,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)){

                return sponsorService.getProgetti(id);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * metodo che seleziona l'amount di uno dei progetti
     * @param id id del progetto selezionato
     * @param idSponsor sponsor che ha questa relazione
     * @return amount del progetto
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value ="/progettisponsor/{id}/")
    @ResponseBody
    public Double getAmount(@PathVariable @NotNull Long id, @RequestParam @NotNull Long idSponsor,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(id,token)) {
                return sponsorService.getSponsor(idSponsor).getProgettiInv().stream().filter(t -> t.getIdProgetto().equals(id)).collect(Collectors.toList()).get(0).getAmount();
            }
            return Double.MIN_VALUE;
        }catch(Exception e){
            return Double.MIN_VALUE;
        }
    }

    /**
     * Decremento della quota di denaro da un progetto
     * @param id del progetto
     * @param idSponsor sponsor che vuole decrementare la sua somma dal progetto
     * @param amount valore da sottrarre alla quota
     * @return messaggio di corretta esecuzione o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value= "/progettisponsor/{id}/decrement")
    @ResponseBody
    public String decrementAmountProgetto(@PathVariable Long id,@RequestParam @NotNull Long idSponsor, @RequestParam Double amount,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(id,token)) {
                sponsorService.decrementAmountProgetto(id, idSponsor, amount);
                return "Decrementato";
            }
            return "Not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Incremento della quota di denaro su un progetto
     * @param id progetto
     * @param idSponsor sponsor che effettua incremento
     * @param amount valore che aggiunge
     * @return messaggio di corretta esecuzione o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value= "/progettisponsor/{id}/increment")
    @ResponseBody
    public String incrementAmountProgetto(@PathVariable Long id,@RequestParam @NotNull Long idSponsor, @RequestParam Double amount,@RequestParam @NotNull Long token){
        try {
            if(userHandlerService.check(id,token)) {
                sponsorService.addAmountProgetto(id, idSponsor, amount);
                return "Incrementato";
            }
            return "Not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    /**
     * Cancellazione account di uno sponsor
     * @param idSponsor sponsor che viene rimosso
     * @return messaggio di corretta esecuzione o errore
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value="/remove/")
    @ResponseBody
    public String removeSponsor(@RequestParam @NotNull Long idSponsor,@RequestParam @NotNull Long token){
        try{
            if(userHandlerService.check(idSponsor,token)) {
                sponsorService.deleteSponsor(idSponsor);
                return "rimozione effettuata";
            }
            return "not logged";
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
