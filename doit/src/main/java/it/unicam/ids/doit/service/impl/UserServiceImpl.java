package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.dao.ProgettoRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ProgettoRepository progettoRepository;
    @Autowired
    ProgettistaRepository progettistaRepository;
    @Override
    public List<Progetto> getProgetti() {
        return progettoRepository.findAll();
    }

    @Override
    public List<Progettista> getProgettisti() {
        return progettistaRepository.findAll();
    }
}
