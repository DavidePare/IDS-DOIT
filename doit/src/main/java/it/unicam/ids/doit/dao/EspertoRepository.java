package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.service.EspertoService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspertoRepository extends JpaRepository<Esperto,Long> {
}
