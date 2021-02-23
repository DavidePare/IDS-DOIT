package it.unicam.ids.doit.entity.Notifiche;

import java.util.List;
import java.util.Set;

public interface Subscribe {
    void notify(String message,String name, Long id);
    Set<NotificationMessage> getMessaggeBacheca();
}
