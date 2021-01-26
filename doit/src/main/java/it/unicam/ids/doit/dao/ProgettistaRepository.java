package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.service.ProgettistaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgettistaRepository extends JpaRepository<ProgettistaService,Long> { // decidere se Long o Integer
}
