package it.unicam.ids.doit;

import it.unicam.ids.doit.controller.ProponenteProgettoController;
import it.unicam.ids.doit.dao.EspertoRepository;
import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.dao.ProponenteProgettoRepository;
import it.unicam.ids.doit.dao.SponsorRepository;
import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.ProponenteProgetto;
import it.unicam.ids.doit.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DOITCommandLineRunner implements CommandLineRunner {
    @Autowired
    private EspertoRepository espertoRepository;
    @Autowired
    private ProgettistaRepository progettistaRepository;
    @Autowired
    private ProponenteProgettoRepository proponenteProgettoRepository;
    @Autowired
    private SponsorRepository sponsorRepository;

    @Override
    public void run(String... args) throws Exception {
       espertoRepository.save(new Esperto("Paolo","Marchetti","aa@a.aa","a"));
       espertoRepository.save(new Esperto("Fabrizio","Maurizi","bb@b.bb","u"));
       progettistaRepository.save(new Progettista("Mario","Decimo","QQ@q.qq","q"));
       proponenteProgettoRepository.save(new ProponenteProgetto("Luca","Franco","cc@c.cc"," "));
       sponsorRepository.save(new Sponsor("DOIT","ss@ss.ss","s"));
    }
}
