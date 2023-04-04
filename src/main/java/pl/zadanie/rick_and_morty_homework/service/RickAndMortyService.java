package pl.zadanie.rick_and_morty_homework.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import pl.zadanie.rick_and_morty_homework.model.RickAndMortyDTO;

public interface RickAndMortyService {

//    RickAndMortyDTO saveNewCharacter(RickAndMortyDTO rickAndMortyDTO);
//    RickAndMortyDTO askRickAndMortyApi(Long idCharacter);
    RickAndMortyDTO checkIfCharacterIsInDatabase(Long id);


}
