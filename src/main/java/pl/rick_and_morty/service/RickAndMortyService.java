package pl.rick_and_morty.service;

import pl.rick_and_morty.model.RickAndMortyDTO;

public interface RickAndMortyService {
    RickAndMortyDTO getCharacter(Long id);
}
