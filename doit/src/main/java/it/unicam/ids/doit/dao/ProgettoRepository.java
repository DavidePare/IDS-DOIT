package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgettoRepository extends JpaRepository<Progetto,Long> {
}
