package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.EspertoRepository;
import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
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
        if(esperto.getProgettiEsperto().stream().noneMatch(t-> t.getId().equals(idProgetto))) {
            esperto.getProgettiEsperto().add(progettoService.getProgetto(idProgetto));
            espertoRepository.save(esperto);
        }
    }

    /**
     * Rimozione di un progetto dall'esperto , questo metodo viene richiamato se un progetto viene eliminato
     * @param idEsperto che aveva valutato il progetto
     * @param idProgetto progetto eliminato
     */
    @Override
    public void removeProgetto(Long idEsperto, Long idProgetto){
        Esperto esperto = getEsperto(idEsperto);
        esperto.getProgettiEsperto().removeIf(p -> p.getId().equals(idProgetto));//remove(progettoService.getProgetto(idProgetto));
        espertoRepository.save(esperto);
    }

    /**
     * Creazione di un esperto e viene salvato sul db
     * @param name nome dell'esperto
     * @param surname cognome dell'esperto
     * @return esperto creato
     */
    @Override
    public Esperto createEsperto(String name, String surname, String email , String password){
        Esperto esperto = new Esperto(name,surname,email,password);
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
        if(!esperto.getProgettiEsperto().isEmpty())
            esperto.getProgettiEsperto().forEach(t->progettoService.removeEsperto(t.getId()));
        esperto.setProgettiEsperto(null);
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

    /**
     * Metodo per confermare un progetto
     * @param idProgetto progetto confermato
     * @param idEsperto esperto che conferma il progetto
     */
    @Override
    public void confirmProgetto(Long idProgetto, Long idEsperto){
        progettoService.confirmProgetto(idProgetto, idEsperto);
        addProgetto(idEsperto,idProgetto);
        espertoRepository.save(getEsperto(idEsperto));
    }

    /**
     * Metodo per rifiutare un progetto quindi per metterlo in stato di blocked
     * @param idProgetto progetto valutato
     * @param idEsperto esperto che valuta
     */
    @Override
    public void declineProgetto(Long idProgetto, Long idEsperto){
        progettoService.declineProgetto(idProgetto, idEsperto);
        addProgetto(idEsperto,idProgetto);
        espertoRepository.save(getEsperto(idEsperto));
    }

    /**
     * Metodo per ottenere tutti i progetti da valutare
     * @return tutti i progetti in stato di waiting
     */
    @Override
    public List<Progetto> getAllProgettiValutare(){
        return progettoService.getAllProgettiValutare();
    }

    /**
     * Metodo con il quale un esperto ottiene un singolo progetto
     * @param id progetto
     * @return progetto
     */
    @Override
    public Progetto getProgetto(Long id){
        return progettoService.getProgetto(id);
    }
}
