package it.unicam.ids.doit.dao;

import it.unicam.ids.doit.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum,Long> {
}
