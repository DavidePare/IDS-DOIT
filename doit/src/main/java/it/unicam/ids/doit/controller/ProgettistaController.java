package it.unicam.ids.doit.controller;

import it.unicam.ids.doit.service.ProgettistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgettistaController {

    @Autowired
    ProgettistaService progettistaService;

}
