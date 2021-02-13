package it.unicam.ids.doit.entity;

import java.util.List;

public interface Subscribe {
    void notify(String message,String name, Long id);
    List<NotificationMessage> getMessaggeBacheca();
}
