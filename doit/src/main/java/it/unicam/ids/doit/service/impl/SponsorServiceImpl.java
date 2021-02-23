package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.SponsorRepository;
import it.unicam.ids.doit.entity.Sponsor.Investimenti;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Sponsor.Sponsor;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    public Sponsor createSponsor(String name,String email, String password){
        Sponsor sponsor = new Sponsor(name,email,password);
        sponsorRepository.save(sponsor);
        return sponsor;
    }

    /**
     * Rimozione dello sponsor
     * @param idSponsor sponsor da rimuovere
     */
    @Override
    public void deleteSponsor(Long idSponsor){
       Sponsor sponsor = getSponsor(idSponsor);
        if(!sponsor.getProgettiInv().isEmpty())
            sponsor.getProgettiInv().forEach(t-> progettoService.removeSponsor(t.getIdProgetto() ,idSponsor));
        sponsorRepository.delete(sponsor);
    }

    /**
     * Metodo per ottenere la visualizzazione di un singolo sponsor
     * @param id dello sponsor che si vuole stampare
     * @return sponsor richiesto
     */
    @Override
    public Sponsor getSponsor(Long id){
        return sponsorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Metodo per ottenere tutti gli sponsor
     * @return lista di tutti gli sponsor
     */
    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }


    /**
     * Rimozione di un progetto dalla lista dello sponsor
     * @param idProgetto progetto che deve essere rimosso dalla lista dello sponsor
     * @param idSponsor sponsor che riceve la rimozione del progetto
     */
    @Override
    public void removeProgetto(Long idProgetto, Long idSponsor){
        Sponsor sponsor = getSponsor(idSponsor);
        if(sponsor.getProgettiInv().stream().anyMatch(t-> t.getIdProgetto().equals(idProgetto))){
            sponsor.getProgettiInv().stream().filter(t-> t.getIdProgetto().equals(idProgetto)).
                    forEach(t-> progettoService.decrementAmount(idProgetto,t.getAmount()));
            sponsor.getProgettiInv().removeIf(p-> p.getIdProgetto().equals(idProgetto));
            sponsorRepository.save(sponsor);
        }
    }

    /**
     * Quando uno sponsor investe una cifra su un progetto
     * @param idProgetto al quale vuole investire
     * @param idSponsor sponsor che investisce
     * @param amount valore che immette
     */
    @Override
    public void addAmountProgetto(Long idProgetto, Long idSponsor, double amount){
        Sponsor sponsor = getSponsor(idSponsor);
        if(sponsor.getProgettiInv().stream().noneMatch(t-> t.getIdProgetto().equals(idProgetto)))
            sponsor.getProgettiInv().add(new Investimenti(amount,idProgetto));
        else{
            sponsor.getProgettiInv().stream().filter(t-> t.getIdProgetto().equals(idProgetto)).collect(Collectors.toList()).get(0).addAmount(amount);
        }
        progettoService.incrementAmount(idProgetto,amount);
        progettoService.addSponsor(idProgetto, idSponsor);
        sponsorRepository.save(sponsor);
    }

    /**
     * Quando uno sponsor vuole rimuovere fondi da un progetto
     * @param idProgetto al quale vuole rimuovere i fondi
     * @param idSponsor sponosr che effettua operazione
     * @param amount valore da rimuovere
     */
    @Override
    public void decrementAmountProgetto(Long idProgetto, Long idSponsor, double amount){
        Sponsor sponsor = getSponsor(idSponsor);
        if(sponsor.getProgettiInv().stream().anyMatch(t-> t.getIdProgetto().equals(idProgetto))){
            if(sponsor.getProgettiInv().stream().filter(t-> t.getIdProgetto().equals(idProgetto)).collect(Collectors.toList()).get(0).getAmount()>=amount){
                sponsor.getProgettiInv().stream().filter(t-> t.getIdProgetto().equals(idProgetto)).collect(Collectors.toList()).get(0).decrementAmount(amount);
                progettoService.decrementAmount(idProgetto,amount);
                sponsorRepository.save(sponsor);
            }
        }
    }

    /**
     * Metodo per ottenere tutti i progetti a cui uno sponsor ha aggiunto denaro
     * @param idSponsor sponsor che partecipa
     * @return lista di progetti a cui lo sponsor partecipa
     */
    @Override
    public List<Progetto> getProgetti(Long idSponsor){
        List<Progetto> lProgetti =new ArrayList<>();
        getSponsor(idSponsor).getProgettiInv().forEach(t-> lProgetti.add(progettoService.getProgetto(t.getIdProgetto())));
        return lProgetti;
    }
}
