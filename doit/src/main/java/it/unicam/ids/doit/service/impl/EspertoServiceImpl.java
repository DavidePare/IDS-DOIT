package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.EspertoRepository;
import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.ProponenteProgetto;
import it.unicam.ids.doit.service.EspertoService;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EspertoServiceImpl implements EspertoService {

    @Autowired
    private EspertoRepository espertoRepository;

    @Autowired
    private ProgettoService progettoService;

    @Override
    public void addProgetto(Long idEsperto, Long idProgetto){
        Esperto esperto = getEsperto(idEsperto);
        esperto.getProgettiEsperto().add(idProgetto);
        espertoRepository.save(esperto);
    }

    @Override
    public void removeProgetto(Long idEsperto, Long idProgetto){
        Esperto esperto = getEsperto(idEsperto);
        esperto.getProgettiEsperto().remove(idProgetto);
        espertoRepository.save(esperto);
    }

    @Override
    public Esperto createEsperto(String name, String surname){
        Esperto esperto = new Esperto(name,surname);
        espertoRepository.save(esperto);
        return esperto;
    }

    @Override
    public void deleteEsperto(Long idEsperto){
        Esperto esperto = getEsperto(idEsperto);
        if(!esperto.getProgettiEsperto().isEmpty()) esperto.getProgettiEsperto().
                forEach(p -> progettoService.removeEsperto(idEsperto));
        espertoRepository.delete(esperto);
    }

    @Override
    public Esperto getEsperto(Long id){
        return espertoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Esperto> getAllEsperti(){
        return espertoRepository.findAll();
    }

}
