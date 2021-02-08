package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.SponsorRepository;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Sponsor;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SponsorServiceImpl implements SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Autowired
    private ProgettoService progettoService;

    @Override
    public Sponsor createSponsor(String name){
        Sponsor sponsor = new Sponsor(name);
        sponsorRepository.save(sponsor);
        return sponsor;
    }

    @Override
    public void deleteSponsor(Long idSponsor){
        Sponsor sponsor = getSponsor(idSponsor);
        if(!sponsor.getProgettiInv().isEmpty()) sponsor.getProgettiInv().
                forEach((s,a) -> progettoService.removeSponsor(s,idSponsor));
        sponsorRepository.delete(sponsor);
    }

    @Override
    public Sponsor getSponsor(Long id){
        return sponsorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }


    @Override
    public void removeProgetto(Long idProgetto, Long idSponsor){
        Sponsor sponsor = getSponsor(idSponsor);
        sponsor.getProgettiInv().remove(idProgetto);
        sponsorRepository.save(sponsor);
    }

    @Override
    public void addAmountProgetto(Long idProgetto, Long idSponsor, double amount){
        Sponsor sponsor = getSponsor(idSponsor);
        if(sponsor.getProgettiInv().containsKey(idProgetto)){
            sponsor.getProgettiInv().replace(idProgetto,sponsor.getProgettiInv().get(idProgetto)+amount);
        } else{
            progettoService.addSponsor(idProgetto,idSponsor);
            sponsor.getProgettiInv().put(idProgetto,amount);
        }
        progettoService.incrementAmount(idProgetto,amount);
        sponsorRepository.save(sponsor);
    }

    @Override
    public void decrementAmountProgetto(Long idProgetto, Long idSponsor, double amount){
        Sponsor sponsor = getSponsor(idSponsor);
        Progetto progetto = progettoService.getProgetto(idProgetto);
        if(sponsor.getProgettiInv().containsKey(idProgetto) &&
                (sponsor.getProgettiInv().get(idProgetto) >= amount) ){
            sponsor.getProgettiInv().replace(idProgetto,sponsor.getProgettiInv().get(progetto)-amount);
            progettoService.decrementAmount(idProgetto,amount);
            sponsorRepository.save(sponsor);
        }
    }

    @Override
    public List<Progetto> getProgetti(Long idSponsor){
        List<Progetto> lProgetti =new ArrayList<>();
        for(Long idProgetto : getSponsor(idSponsor).getProgettiInv().keySet()){
            lProgetti.add(progettoService.getProgetto(idProgetto));
        }
        return lProgetti;
    }
}
