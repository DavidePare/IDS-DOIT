package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
