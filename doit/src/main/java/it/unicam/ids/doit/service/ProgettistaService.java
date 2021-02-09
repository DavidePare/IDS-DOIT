package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Curriculum;
import it.unicam.ids.doit.entity.Progettista;

import it.unicam.ids.doit.entity.Progetto;

import java.util.List;

public interface ProgettistaService {

    Progettista createProgettista(String name, String surname);

    void deleteProgettista(Long idProgettista);

    Progettista getProgettista(Long id);

    List<Progettista> getAllProgettisti();

    void addWorkingExperience(Long id,String experience);

    void removeWorkingExperience(Long id,String experience);

    void addLanguages(Long id,String language);

    void removeLanguages(Long id,String language);

    void addProgetto(Long idProgetto, Long idProgettista);

    void removeProgetto(Long idProgetto, Long idProgettista);

    void addInvito(Long idProgetto, Long idProgettista);

    void acceptInvito(Long idProgetto, Long idProgettista);

    void refuseInvito(Long idProgetto, Long idProgettista);

    void addTeam(Long idProgettista, Long idTeam);

    void removeTeam(Long idProgettista, Long idTeam);

    void addprogettoCandidato(Long idProgetto, Long idProgettista);

    void removeprogettoCandidato(Long idProgetto, Long idProgettista);

    void sendCandidatura(Long idProgetto, Long idProgettista);

    Curriculum getCurriculum(Long id);

    List<Progetto> getInviti(Long idProgettista);

    List<Progetto> getProgettiAttivi(Long idProgettista);
}
