package it.unicam.ids.doit.entity.login;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserHandler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSessione;
    private Long id;
    private Long token;

    public UserHandler(){

    }

    public UserHandler(Long id, Long token) {
        this.id = id;
        this.token = token;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Long idSessione) {
        this.idSessione = idSessione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getToken() {
        return token;
    }

    public void setToken(Long token) {
        this.token = token;
    }
}
