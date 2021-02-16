package it.unicam.ids.doit.controller;

import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.User;
import it.unicam.ids.doit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserHandlerService userHandlerService;
    @Autowired
    private ProgettoService progettoService;
    /**
     * Visualizzazione di tutti i progetti
     * @return tutti i progetti
     */
    @GetMapping(value="/getprogetti/")
    @ResponseBody
    public List<Progetto> getProgetto(){
        return progettoService.getAllProgetti();
    }

    /**
     * Visualizzazione tutti i progettisti
     * @return tutti i progettisti
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/getprogettisti/")
    @ResponseBody
    public List<Progettista> getProgettisti(){
        return userHandlerService.getAllProgettisti();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/signin")
    @ResponseBody
    public String signin(@RequestParam @NotNull String email , @RequestParam @NotNull String password, @RequestParam @NotNull String name,@RequestParam String surname,@RequestParam @NotNull String type){
        try {
            int type2= Integer.parseInt(type);
            if(type2 <0 || type2 >2) return "Not correct type";
            userHandlerService.signin(type2,name,surname,email,password);
            return "success";
        }catch(Exception e){
            return "Dati non validi, l'email potrebbe essere già registrata!";
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/signin2")
    @ResponseBody
    public String signin(@RequestBody @NotNull User user) {
        try {
            if(user.getType() <0 || user.getType() >2) return "Not correct type";
            userHandlerService.signin(user.getType(),user.getName(),user.getSurname(),user.getEmail(),user.getPassword());
            return "success";
        }catch(Exception e){
            return "Dati invalidi forse è già stata usata questa email !";
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/login")
    @ResponseBody
    public List<Long> login(@RequestParam @NotNull int type,@RequestParam @NotNull String email , @RequestParam @NotNull String password){
        try {
            return userHandlerService.login(type,email,password);
        }catch(Exception e){
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/logout")
    @ResponseBody
    public void logout(@RequestParam @NotNull Long token){
        userHandlerService.logout(token);
    }
/*
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/signin")
    @ResponseBody
    public String signin(@RequestBody @NotNull int type,@RequestBody @NotNull String email , @RequestBody @NotNull String password, @RequestBody @NotNull String name,@RequestBody String surname){
        try {
            if(type <0 || type >2) return "Not correct type";
            userHandlerService.signin(type,name,surname,email,password);
            return "success";
        }catch(Exception e){
            return "Dati non validi, l'email potrebbe essere già registrata!";
        }
    }*/

}
