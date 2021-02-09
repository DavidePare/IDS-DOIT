package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Esperto;

import java.util.List;

public interface EspertoService {

    void addProgetto(Long idEsperto, Long idProgetto);

    void removeProgetto(Long idEsperto, Long idProgetto);

    Esperto createEsperto(String name, String surname);

    void deleteEsperto(Long idEsperto);

    Esperto getEsperto(Long id);

    List<Esperto> getAllEsperti();

}
