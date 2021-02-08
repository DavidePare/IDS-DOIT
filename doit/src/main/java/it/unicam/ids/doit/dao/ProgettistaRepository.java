package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.Progettista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgettistaRepository extends JpaRepository<Progettista,Long> {
}