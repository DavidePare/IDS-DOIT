package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.*;
import it.unicam.ids.doit.entity.*;
import it.unicam.ids.doit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
@Service

public class UserHandlerServiceImpl implements UserHandlerService {

    @Autowired
    LoggedUserRepository loggedUserRepository;
    @Autowired
    ProgettistaService progettistaService;
    @Autowired
    SponsorService sponsorService;
    @Autowired
    EspertoService espertoService;
    @Autowired
    ProponenteProgettoService proponenteProgettoService;
    @Autowired
    ProgettoService progettoService;

    /**
     * Login con restituzione del token dell'utente loggato
     * @param type di log-in se da progettista sponsor o esperto
     * @param email dato di verifica
     * @param password per verifica l utente
     * @return token di sessione
     */
    @Override
    public List<Long> login(int type, String email, String password){
        List<Long> token= new ArrayList<>();
        if(type==0 && progettistaService.getAllProgettisti().stream().anyMatch(t-> t.getEmail().compareTo(email)==0
                && t.getPassword().compareTo(password)==0)){
            Progettista progettista=progettistaService.getAllProgettisti().stream().filter(t-> t.getEmail().compareTo(email)==0
                    && t.getPassword().compareTo(password)==0).collect(Collectors.toList()).get(0);
            token.add(generateToken(progettista.getId()));
            token.add(progettista.getId());
        }
        if(type==1 && sponsorService.getAllSponsors().stream().anyMatch(t-> t.getEmail().compareTo(email)==0
                && t.getPassword().compareTo(password)==0)){
            Sponsor sponsor=sponsorService.getAllSponsors().stream().filter(t-> t.getEmail().compareTo(email)==0
                    && t.getPassword().compareTo(password)==0).collect(Collectors.toList()).get(0);
            token.add(generateToken(sponsor.getId()));
            token.add(sponsor.getId());
        }
        if(type==2 && espertoService.getAllEsperti().stream().anyMatch(t-> t.getEmail().compareTo(email)==0
                && t.getPassword().compareTo(password)==0)){
            Esperto esperto=espertoService.getAllEsperti().stream().filter(t-> t.getEmail().compareTo(email)==0
                    && t.getPassword().compareTo(password)==0).collect(Collectors.toList()).get(0);
            token.add(generateToken(esperto.getId()));
            token.add(esperto.getId());
        }
        token.add((long) type);
        return token;
    }

    /**
     * Logout utente
     * @param token codice univoco che stabilisce chi si è connesso
     * @return successo o insuccesso
     */
    @Override
    public String logout(Long token){
        try {
            UserHandler u = loggedUserRepository.findAll().stream().filter(t -> t.getToken().equals(token)).collect(Collectors.toList()).get(0);
            loggedUserRepository.delete(u);
            return "success";
        }catch(Exception ignored){
            return "don't found";
        }
    }

    /**
     * Generatore token
     * @param id account da loggare
     * @return token
     */
    private Long generateToken(Long id){
        Long token= ThreadLocalRandom.current().nextLong(10000000, 100000000);
        if(loggedUserRepository.findAll().stream().anyMatch(t-> t.getId().equals(id))) destroyOldSession(id);
        loggedUserRepository.save(new UserHandler(id,token));
        return token;
    }

    /**
     * metodo che distrugge la vecchia sessione dell'utente
     * @param id account
     */
    private void destroyOldSession(Long id){
        try{
            UserHandler u = loggedUserRepository.findAll().stream().filter(t -> t.getId().equals(id)).collect(Collectors.toList()).get(0);
            loggedUserRepository.delete(u);
        }catch(Exception ignored){
        }
    }

    @Override
    public void signin(int type,String name,String surname,String email,String password){
        if (type == 0) proponenteProgettoService.createProponenteProgetto(name, surname, email, password);
        if (type == 1) progettistaService.createProgettista(name, surname, email, password);
        if (type == 2) sponsorService.createSponsor(name, email, password);
    }


    @Override
    public List<Progettista> getAllProgettisti() {
        return progettistaService.getAllProgettisti();
    }

    @Override
    public boolean check(Long id, Long token){
        return loggedUserRepository.findAll().stream().anyMatch(t-> t.getId().equals(id) && t.getToken().equals(token));
    }


    @Override
    public Progettista getProgettista(Long idProgettista){
        return progettistaService.getProgettista(idProgettista);
    }

    @Override
    public List<Progetto> getAllProgetti(){
        return progettoService.getAllProgetti();
    }

    @Override
    public Progetto getProgetto(Long id){
        return progettoService.getProgetto(id);
    }
}
