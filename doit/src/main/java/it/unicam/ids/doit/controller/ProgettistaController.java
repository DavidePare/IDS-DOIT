package it.unicam.ids.doit.controller;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgettistaController {
    @Autowired
    ProgettistaServiceImpl progettistaService;

    @GetMapping(value="/progettista")
    public String Hi(){
        return "hello";
    }

    @PostMapping(value="/addprogettista")
    public Progettista addProgettista(@RequestParam String name, @RequestParam String surname){

        return progettistaService.createProgettista(name,surname);
    }

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




}
