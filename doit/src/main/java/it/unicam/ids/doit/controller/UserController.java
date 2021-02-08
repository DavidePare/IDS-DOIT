package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.ProponenteProgetto;
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

    @GetMapping(value="/getprogetti/")
    @ResponseBody
    public List<Progetto> getProgetto(){
        return userService.getProgetti();
    }

    @GetMapping(value="/getprogettisti/")
    @ResponseBody
    public List<Progettista> getProgettisti(){
        return userService.getProgettisti();
    }

    @PostMapping(value="/login/")
    @ResponseBody
    public String login(@PathVariable @NotNull String email, @PathVariable @NotNull String password){
        return "Success"; // qui ritornerà una sessione
    }


    @PostMapping(value="/addpp")
    @ResponseBody
    public ProponenteProgetto addPropProgetto(@RequestParam String name, @RequestParam String surname){
        return proponenteProgettoService.createProponenteProgetto(name,surname);

    }
    // qui metterei le diverse creazioni tipo progettisti sponsor eccetera


}
