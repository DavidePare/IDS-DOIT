package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;

import java.util.List;

public interface UserHandlerService {

    List<Long> login(int type, String email, String password);
    String logout(Long token);
    void signin(int type, String name, String surname, String email, String password);
    List<Progettista> getAllProgettisti();
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    Progettista getProgettista(Long idProgettista);
    boolean check(Long id, Long token);
    List<Progetto> getAllProgetti();
    Progetto getProgetto(Long id);

=======
    boolean check(Long id, Long token);
>>>>>>> Stashed changes
=======
    boolean check(Long id, Long token);
>>>>>>> Stashed changes
}
