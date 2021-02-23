package it.unicam.ids.doit.entity.Notifiche;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class NotificationMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp data;
    private String message;
    private String sender;
    private Long idSender;

    public NotificationMessage(){

    }
    public NotificationMessage( String message, String sender, Long idSender) {
        this.data = Timestamp.valueOf(LocalDateTime.now());
        this.message = message;
        this.sender = sender;
        this.idSender = idSender;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data.toLocalDateTime();
    }

    public void setData(LocalDateTime data) {
        this.data = Timestamp.valueOf(data);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
