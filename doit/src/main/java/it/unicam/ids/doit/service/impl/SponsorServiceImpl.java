package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.SponsorService;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SponsorServiceImpl implements SponsorService {

    private int id;

    private String name;

    private Map<ProgettoService,Double> progettiInv;

    public SponsorServiceImpl(String name){
        this.name=name;
        progettiInv= new HashMap<>();
    }

    @Override
    public int getID(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Map<ProgettoService,Double> getProgettiInv(){
        return progettiInv;
    }

    @Override
    public void addAmountProgetto(ProgettoService p, double amount){
        if(progettiInv.containsKey(p)){
            progettiInv.replace(p,progettiInv.get(p)+amount);
            p.incrementAmount(amount);
        } else{
            p.incrementAmount(amount);
            progettiInv.put(p,amount);
        }
    }

    @Override
    public void decrementAmountProgetto(ProgettoService p, double amount){
        if(progettiInv.containsKey(p)){
            progettiInv.replace(p,progettiInv.get(p)-amount);
            p.decrementAmount(amount);
        }
    }
}
