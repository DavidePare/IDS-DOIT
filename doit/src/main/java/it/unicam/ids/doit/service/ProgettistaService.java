package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Curriculum;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Team;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public interface ProgettistaService {

    Progettista getProgettista(Long id);

    List<Progettista> getAllProgettisti();


    List<Curriculum> getCurriculum();


    void addProgetto(Long idProgetto, Long idProgettista);

    void removeProgetto(Long idProgetto, Long idProgettista);

    void addInvito(Long idProgetto, Long idProgettista);

    void acceptInvito(Long idProgetto, Long idProgettista);


    void refuseInvito(Long idProgetto, Long idProgettista);

    void addprogettoCandidato(Long idProgetto, Long idProgettista);

    void removeprogettoCandidato(Long idProgetto, Long idProgettista);

    void sendCandidatura(Long idProgetto, Long idProgettista);
}
