package pl.rick_and_morty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rick_and_morty.model.RickAndMortyDTO;
import pl.rick_and_morty.service.RickAndMortyService;

@RestController
@RequestMapping(value = "/api/rickandmorty")
@RequiredArgsConstructor
public class RickAndMortyController {

    private final RickAndMortyService rickAndMortyService;


    @GetMapping(value = "{characterId}")
    public ResponseEntity<RickAndMortyDTO> getCharacter(@PathVariable Long characterId) {
        return new ResponseEntity<>(rickAndMortyService.getCharacter(characterId), HttpStatus.OK);
    }
}
