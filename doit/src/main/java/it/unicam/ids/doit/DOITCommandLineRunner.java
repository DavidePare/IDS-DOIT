package it.unicam.ids.doit;

import it.unicam.ids.doit.dao.EspertoRepository;
import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.dao.ProponenteProgettoRepository;
import it.unicam.ids.doit.dao.SponsorRepository;
import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.ProponenteProgetto;
import it.unicam.ids.doit.entity.Sponsor.Sponsor;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProponenteProgettoService;
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
    @Autowired
    private ProponenteProgettoService ppService;
    @Autowired
    private ProgettistaService progettistaService;

    @Override
    public void run(String... args) throws Exception {
       espertoRepository.save(new Esperto("Paolo","Marchetti","aa@a.aa","a"));
       espertoRepository.save(new Esperto("Fabrizio","Maurizi","bb@b.bb","u"));
       progettistaRepository.save(new Progettista("Mario","Decimo","qq@q.qq","q"));
       proponenteProgettoRepository.save(new ProponenteProgetto("Luca","Franco","cc@c.cc","a"));
       sponsorRepository.save(new Sponsor("DOIT","ss@ss.ss","s"));
       ProponenteProgetto p=ppService.createProponenteProgetto("Nome","aa","dd@dd.dd","cc");
       ppService.createProgetto(p.getId(),"prog",5);
       ppService.createProgetto(p.getId(),"DOIT",5);
       ppService.createProgetto(p.getId(),"C3",5);
       ppService.createProgetto(p.getId(),"Altro",5);
       progettistaService.createProgettista("a","b","ccc@ccccc.cc","a");

    }
}
