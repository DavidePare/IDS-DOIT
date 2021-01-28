package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.ProponenteProgetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProponenteProgettoRepository extends JpaRepository<ProponenteProgetto,Long> {
}
