package pl.rick_and_morty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rick_and_morty.entity.RickAndMortyEntity;

@Repository
public interface RickAndMortyRepository extends JpaRepository<RickAndMortyEntity, Long> {
}
