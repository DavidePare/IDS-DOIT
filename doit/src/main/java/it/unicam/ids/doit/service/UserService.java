package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;

import java.util.List;

public interface UserService {
    List<Progetto> getProgetti();
    List<Progettista> getProgettisti();
}
