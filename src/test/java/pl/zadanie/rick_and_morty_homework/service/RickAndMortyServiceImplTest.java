package pl.zadanie.rick_and_morty_homework.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zadanie.rick_and_morty_homework.entity.RickAndMortyEntity;
import pl.zadanie.rick_and_morty_homework.mapper.RickAndMortyMapper;
import pl.zadanie.rick_and_morty_homework.model.RickAndMortyDTO;
import pl.zadanie.rick_and_morty_homework.repository.RickAndMortyRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class RickAndMortyServiceImplTest {

    @Mock
    RickAndMortyRepository rickAndMortyRepository;

    @InjectMocks
    RickAndMortyServiceImpl rickAndMortyService;

    @DisplayName("If character is in database shouldn't save it once more")
    @Test
    void checkIfCharacterIsInDatabase() {

        //given
        RickAndMortyEntity rickAndMortyEntity = RickAndMortyEntity.builder()
                .gender("TEST")
                .species("TEST")
                .status("DEAD")
                .name("Test name")
                .image(null)
                .build();

        Mockito.when(rickAndMortyRepository.findById(1L)).thenReturn(Optional.ofNullable(rickAndMortyEntity));



        //when
        RickAndMortyDTO rickAndMortyDTOResult = rickAndMortyService.checkIfCharacterIsInDatabase(1L);



        //then
        Mockito.verify(rickAndMortyRepository, Mockito.times(0)).save(any());

        assertAll(
                ()->assertEquals(rickAndMortyEntity.getName(),rickAndMortyDTOResult.getName()),
                ()->assertEquals(rickAndMortyEntity.getStatus(),rickAndMortyDTOResult.getStatus()),
                ()->assertEquals(rickAndMortyEntity.getGender(),rickAndMortyDTOResult.getGender()),
                ()->assertEquals(rickAndMortyEntity.getSpecies(),rickAndMortyDTOResult.getSpecies()),
                ()->assertEquals(rickAndMortyEntity.getImage(),rickAndMortyDTOResult.getImage())
        );



    }


    @DisplayName("If character isn't in database should save it")
    @Test
    void checkIfCharacterIsInDatabase2() {

        //given
        Mockito.when(rickAndMortyRepository.findById(1L)).thenReturn(Optional.empty());



        //when
        RickAndMortyDTO rickAndMortyDTOResult = rickAndMortyService.checkIfCharacterIsInDatabase(1L);



        //then
        Mockito.verify(rickAndMortyRepository, Mockito.times(1)).save(any());

        assertAll(
                ()->assertEquals("Rick Sanchez",rickAndMortyDTOResult.getName()),
                ()->assertEquals("Alive",rickAndMortyDTOResult.getStatus()),
                ()->assertEquals("Male",rickAndMortyDTOResult.getGender()),
                ()->assertEquals("Human",rickAndMortyDTOResult.getSpecies()),
                ()->assertEquals("https://rickandmortyapi.com/api/character/avatar/1.jpeg",rickAndMortyDTOResult.getImage())
        );



    }
}