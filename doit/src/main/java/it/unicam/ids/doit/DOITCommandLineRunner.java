package it.unicam.ids.doit;

import it.unicam.ids.doit.dao.EspertoRepository;
import it.unicam.ids.doit.entity.Esperto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DOITCommandLineRunner implements CommandLineRunner {
    @Autowired
    private EspertoRepository espertoRepository;
    @Override
    public void run(String... args) throws Exception {
       espertoRepository.save(new Esperto("Paolo","Marchetti","a","a"));
       espertoRepository.save(new Esperto("Fabrizio","Maurizi","p","u"));

    }
}
