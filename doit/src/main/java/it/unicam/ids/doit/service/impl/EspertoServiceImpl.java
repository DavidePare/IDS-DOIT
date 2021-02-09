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

    /**
     * Metodo che viene richiamato se l'esperto valida un progetto e questo progetto viene aggiunto alla lista dell'esperto
     * @param idEsperto che valuta un progetto
     * @param idProgetto progetto valutatato
     */
    @Override
    public void addProgetto(Long idEsperto, Long idProgetto){
        Esperto esperto = getEsperto(idEsperto);
        esperto.getProgettiEsperto().add(idProgetto);
        espertoRepository.save(esperto);
    }

    /**
     * Rimozione di un progetto dall'esperto , questo metodo viene richiamato se un progetto viene eliminato
     * @param idEsperto che aveva valutato il progetto
     * @param idProgetto progetto eliminato
     */
    @Override
    public void removeProgetto(Long idEsperto, Long idProgetto){
        Esperto esperto = getEsperto(idEsperto);
        esperto.getProgettiEsperto().remove(idProgetto);
        espertoRepository.save(esperto);
    }

    /**
     * Creazione di un esperto e viene salvato sul db
     * @param name nome dell'esperto
     * @param surname cognome dell'esperto
     * @return esperto creato
     */
    @Override
    public Esperto createEsperto(String name, String surname){
        Esperto esperto = new Esperto(name,surname);
        espertoRepository.save(esperto);
        return esperto;
    }

    /**
     * Rimozione di un esperto e rimozione da tutti i progetti a cui lui ha dato una valutazione
     * @param idEsperto da rimuovere
     */
    @Override
    public void deleteEsperto(Long idEsperto){
        Esperto esperto = getEsperto(idEsperto);
        if(!esperto.getProgettiEsperto().isEmpty()) esperto.getProgettiEsperto().
                forEach(p -> progettoService.removeEsperto(idEsperto));
        espertoRepository.delete(esperto);
    }

    /**
     * Ottenere un esperto per id
     * @param id esperto da ricercare
     * @return esperto
     */
    @Override
    public Esperto getEsperto(Long id){
        return espertoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Visualizzazione di tutti gli esperti
     * @return tutti gli esperti
     */
    @Override
    public List<Esperto> getAllEsperti(){
        return espertoRepository.findAll();
    }

}