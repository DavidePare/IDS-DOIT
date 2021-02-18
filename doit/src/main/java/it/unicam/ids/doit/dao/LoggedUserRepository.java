package it.unicam.ids.doit.dao;


import it.unicam.ids.doit.entity.UserHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggedUserRepository extends JpaRepository<UserHandler,Long> {
}

