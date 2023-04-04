package pl.zadanie.rick_and_morty_homework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zadanie.rick_and_morty_homework.model.RickAndMortyDTO;
import pl.zadanie.rick_and_morty_homework.service.RickAndMortyService;

@RestController
@RequestMapping(value = "/api/rickandmorty")
@RequiredArgsConstructor
public class RickAndMortyController {

    private final RickAndMortyService rickAndMortyService;


    @GetMapping(value = "{idCharacter}")
    public ResponseEntity<RickAndMortyDTO> getCharacter(@PathVariable Long idCharacter){

        return new ResponseEntity<>(rickAndMortyService.checkIfCharacterIsInDatabase(idCharacter), HttpStatus.OK);

    }


}
