package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.SponsorRepository;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Sponsor;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SponsorServiceImpl implements SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Autowired
    private ProgettoService progettoService;

    @Override
    public Sponsor getSponsor(Long id){
        return sponsorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public void addAmountProgetto(Long idProgetto, Long idSponsor, double amount){
        Sponsor sponsor = getSponsor(idSponsor);
        Progetto progetto = progettoService.getProgetto(idProgetto);
        if(sponsor.getProgettiInv().containsKey(progetto)){
            sponsor.getProgettiInv().replace(progetto,sponsor.getProgettiInv().get(progetto)+amount);
        } else{
            sponsor.getProgettiInv().put(progetto,amount);
        }
        progettoService.incrementAmount(idProgetto,amount);
        sponsorRepository.save(sponsor);
    }

    @Override // QUI SI DEVE GESTIRE IL CONTROLLO DELL'INVESTITO VS QUANTO SI DECREMENTA !!!!!!!!!!!!!!!!!!!!!!
    public void decrementAmountProgetto(Long idProgetto, Long idSponsor, double amount){
        Sponsor sponsor = getSponsor(idSponsor);
        Progetto progetto = progettoService.getProgetto(idProgetto);
        if(sponsor.getProgettiInv().containsKey(progetto)){
            sponsor.getProgettiInv().replace(progetto,sponsor.getProgettiInv().get(progetto)-amount);
            progettoService.decrementAmount(idProgetto,amount);
            sponsorRepository.save(sponsor);
        }
    }
}
