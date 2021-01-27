package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.service.SponsorService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<SponsorService,Long> {
}
