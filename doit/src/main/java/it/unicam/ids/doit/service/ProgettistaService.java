package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Curriculum.Curriculum;
import it.unicam.ids.doit.entity.Notifiche.NotificationMessage;
import it.unicam.ids.doit.entity.Progettista;

import it.unicam.ids.doit.entity.Progetto;

import java.util.List;
import java.util.Set;

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

    boolean sendCandidatura(Long idProgetto, Long idProgettista);

    Curriculum getCurriculum(Long id);

    List<Progetto> getInviti(Long idProgettista);

    List<Progetto> getProgettiAttivi(Long idProgettista);

    List<Progetto> getCandidature(Long idProgettista);

    void createCurriculum(Long idProgettista , String instruction, String formation, Long phone,String email);

    Progettista createProgettista(String name, String surname,String email, String password);

    Set<NotificationMessage> getMessage(Long idProgettista);
}
