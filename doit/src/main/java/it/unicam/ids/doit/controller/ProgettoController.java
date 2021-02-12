package it.unicam.ids.doit.controller;


import com.sun.istack.NotNull;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgettoController {
    @Autowired
    ProgettoServiceImpl progettoService;



    // http://localhost:8080/addprogetto?idProponenteProgetto=1&name=gino&nMaxProgettisti5
    // http://localhost:8080/addprogetto?idProponenteProgetto=1&name=gino Verifica


    // http://localhost:8080/getprogetto/1
    @GetMapping(value="/getprogetto/{id}")
    @ResponseBody
    public Progetto getProgettista(@PathVariable Long id){
        return progettoService.getProgetto(id);
    }

    //http://localhost:8080/getprogetto/
    @GetMapping(value="/getprogetto/")
    @ResponseBody
    public List<Progetto> getProgettisti(){
        return progettoService.getAllProgetti();
    }
    /*
    //http://localhost:8080/
    /*@PostMapping(value="/")
    public void (){

    }*/

    /*
    @DeleteMapping(value = "/removeprogetto")
    @ResponseBody
    public String removeProgetto(@RequestParam Long iduser,@RequestParam Long idprogetto){
        try{
            //Controllare se è l'id del cretore del progetto

        }catch(Exception e){
            return e.getMessage();
        }

    }*/

}
