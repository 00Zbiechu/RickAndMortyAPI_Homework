package pl.zadanie.rick_and_morty_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zadanie.rick_and_morty_homework.entity.RickAndMortyEntity;

@Repository
public interface RickAndMortyRepository extends JpaRepository<RickAndMortyEntity, Long> {



}
