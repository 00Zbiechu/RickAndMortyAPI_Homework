package pl.zadanie.rick_and_morty_homework.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zadanie.rick_and_morty_homework.entity.RickAndMortyEntity;
import pl.zadanie.rick_and_morty_homework.model.RickAndMortyDTO;

import static org.junit.jupiter.api.Assertions.*;

class RickAndMortyMapperTest {

    @DisplayName("Should return RickAndMortyEntity from RickAndMortyDTO with same values")
    @Test
    void toEntity() {

        //given
        RickAndMortyDTO rickAndMortyDTO = RickAndMortyDTO.builder()
                .gender("TEST")
                .species("TEST")
                .status("DEAD")
                .name("Test name")
                .image(null)
                .build();


        //when
        RickAndMortyEntity rickAndMortyEntityResult = RickAndMortyMapper.INSTANCE.toEntity(rickAndMortyDTO);


        //then
        assertAll(
                ()->assertEquals(rickAndMortyEntityResult.getGender(),"TEST"),
                ()->assertEquals(rickAndMortyEntityResult.getSpecies(),"TEST"),
                ()->assertEquals(rickAndMortyEntityResult.getStatus(),"DEAD"),
                ()->assertEquals(rickAndMortyEntityResult.getName(),"Test name"),
                ()->assertEquals(rickAndMortyEntityResult.getImage(),null)
        );


    }

    @DisplayName("Should return RickAndMortyDTO from RickAndMortyEntity with same values")
    @Test
    void toDTO() {

        //given
        RickAndMortyEntity rickAndMortyEntity = RickAndMortyEntity.builder()
                .gender("TEST")
                .species("TEST")
                .status("DEAD")
                .name("Test name")
                .image(null)
                .build();

        //when
        RickAndMortyDTO rickAndMortyDTOResult = RickAndMortyMapper.INSTANCE.toDTO(rickAndMortyEntity);


        //then
        assertAll(
                ()->assertEquals(rickAndMortyDTOResult.getGender(),"TEST"),
                ()->assertEquals(rickAndMortyDTOResult.getSpecies(),"TEST"),
                ()->assertEquals(rickAndMortyDTOResult.getStatus(),"DEAD"),
                ()->assertEquals(rickAndMortyDTOResult.getName(),"Test name"),
                ()->assertEquals(rickAndMortyDTOResult.getImage(),null)
        );


    }
}