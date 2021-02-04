package it.unicam.ids.doit.controller;

import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.impl.EspertoServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class EspertoController {
    ProgettoServiceImpl progettoService;
    EspertoServiceImpl espertoService;

    @GetMapping(value="/getprogettidavalutare/")
    @ResponseBody
    public List<Progetto> getprogettidavalutare(){
        return null;// progettoService.getAllProgettiValutare();
    }

    @GetMapping(value="/getprogettidavalutare/{id}")
    @ResponseBody
    public Progetto getprogetto(@PathVariable Long id){
        return progettoService.getProgetto(id);
    }

    @PostMapping(value="/getprogettidavalutare/{id}/confirm")
    @ResponseBody
    public void confirmProgetto(@PathVariable Long id){
        //progettoService.confirmProgetto(id);
    }


    @PostMapping(value="/getprogettidavalutare/{id}/decline")
    @ResponseBody
    public void declineProgetto(@PathVariable Long id){
        //progettoService.declineProgetto(id);
    }



}
