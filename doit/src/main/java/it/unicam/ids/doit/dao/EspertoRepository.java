package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.Esperto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspertoRepository extends JpaRepository<Esperto,Long>{
}
