package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.ProponenteProgetto;
import it.unicam.ids.doit.service.impl.EspertoServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProponenteProgettoServiceImpl;
import it.unicam.ids.doit.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProponenteProgettoServiceImpl proponenteProgettoService;
    @Autowired
    private ProgettistaServiceImpl progettistaService;
    @Autowired
    private EspertoServiceImpl espertoService;

    /**
     * Visualizzazione di tutti i progetti
     * @return tutti i progetti
     */
    @GetMapping(value="/getprogetti/")
    @ResponseBody
    public List<Progetto> getProgetto(){
        return userService.getProgetti();
    }

    /**
     * Visualizzazione tutti i progettisti
     * @return tutti i progettisti
     */
    @GetMapping(value="/getprogettisti/")
    @ResponseBody
    public List<Progettista> getProgettisti(){
        return userService.getProgettisti();
    }

    /**
     * Login dell'utente
     * @param email email
     * @param password .
     * @return sessione??
     */
    @PostMapping(value="/login/")
    @ResponseBody
    public String login(@PathVariable @NotNull String email, @PathVariable @NotNull String password){
        return "Success"; // qui ritornerà una sessione
    }


    /**
     * Creazione proponente progetto
     * @param name nome pp
     * @param surname cognome pp
     * @return proponente progetto
     */
    @PostMapping(value="/addpp")
    @ResponseBody
    public ProponenteProgetto addPropProgetto(@RequestParam String name, @RequestParam String surname){
        return proponenteProgettoService.createProponenteProgetto(name,surname);

    }

    @PostMapping(value="/addp")
    @ResponseBody
    public Progettista addProgettista(@RequestParam String name, @RequestParam String surname){
        return progettistaService.createProgettista(name,surname);
    }

    @PostMapping(value="/addesperto")
    @ResponseBody
    public Esperto addEsperto(@RequestParam String name, @RequestParam String surname){
        return espertoService.createEsperto(name,surname);
    }


    //TODO qui metterei le diverse creazioni tipo progettisti sponsor eccetera


}
