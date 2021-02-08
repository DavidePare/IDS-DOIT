package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/esperto/")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    /*@PostMapping(value="/addsponsor")
    public Sponsor addSponsor(@RequestParam @NotNull String name){
        return sponsorService.createSponsor(name);
    }*/
    @GetMapping(value= "/progettisponsor/")
    @ResponseBody
    public List<Progetto> getProgettiSponsor(@RequestBody @NotNull Long id){
        try{
            return sponsorService.getProgetti(id);
        }catch(Exception e){
            return null;
        }
    }

    @PostMapping(value ="/progettisponsor/{id}/")
    @ResponseBody
    public Double getAmount(@PathVariable @NotNull Long id, @RequestBody @NotNull Long idSponsor){
        try{
            return sponsorService.getSponsor(idSponsor).getProgettiInv().get(id);
        }catch(Exception e){
            return -Double.MIN_VALUE;
        }
    }

    @PutMapping(value= "/progettisponsor/{id}/decrement")
    @ResponseBody
    public String decrementAmountProgetto(@PathVariable Long id,@RequestParam @NotNull Long idSponsor, @RequestParam Double amount){
        try {
            sponsorService.decrementAmountProgetto(id,idSponsor,amount);
            return "Decrementato";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    @PutMapping(value= "/progettisponsor/{id}/increment")
    @ResponseBody
    public String incrementAmountProgetto(@PathVariable Long id,@RequestParam @NotNull Long idSponsor, @RequestParam Double amount){
        try {
            sponsorService.addAmountProgetto(id,idSponsor,amount);
            return "Incrementato";
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
