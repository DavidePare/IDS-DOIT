package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.Sponsor.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
}
