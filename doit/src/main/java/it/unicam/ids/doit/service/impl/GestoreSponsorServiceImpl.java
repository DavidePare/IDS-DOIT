package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.SponsorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreSponsorServiceImpl {

    private static GestoreSponsorServiceImpl instance = null;

    private List<SponsorService> sponsors;

    private GestoreSponsorServiceImpl(){
        sponsors = new ArrayList<>();
    }

    public SponsorService getSingleSponsor(int ID){
        return sponsors.stream()
                .filter(s -> s.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<SponsorService> getSponsors(){
        return sponsors;
    }

    public void addSponsor(SponsorService s){
        sponsors.add(s);
    }

    public void removeSponsor(SponsorService s){
        sponsors.remove(s);
    }

    public static GestoreSponsorServiceImpl getInstance(){
        if(instance == null){
            instance = new GestoreSponsorServiceImpl();
        }
        return instance;
    }
}
