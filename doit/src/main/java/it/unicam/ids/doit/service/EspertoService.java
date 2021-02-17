package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.entity.Progetto;

import java.util.List;

public interface EspertoService {

    void addProgetto(Long idEsperto, Long idProgetto);

    void removeProgetto(Long idEsperto, Long idProgetto);

    Esperto createEsperto(String name, String surname,String email , String password);

    void deleteEsperto(Long idEsperto);

    void confirmProgetto(Long idProgetto, Long idEsperto);

    void declineProgetto(Long idProgetto, Long idEsperto);

    Esperto getEsperto(Long id);

    List<Esperto> getAllEsperti();

    List<Progetto> getAllProgettiValutare();

    Progetto getProgetto(Long id);
}
