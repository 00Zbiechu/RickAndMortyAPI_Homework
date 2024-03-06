package pl.rick_and_morty.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.rick_and_morty.entity.RickAndMortyEntity;
import pl.rick_and_morty.common.BaseTest;
import pl.rick_and_morty.model.RickAndMortyDTO;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RickAndMortyMapperTest extends BaseTest {

    @Autowired
    private RickAndMortyMapper rickAndMortyMapper;

    @DisplayName("Should return RickAndMortyEntity from RickAndMortyDTO with same values")
    @Test
    void shouldReturnRickAndMortyEntityFromRickAndMortyDTOWithSameValues() {

        //given
        RickAndMortyDTO rickAndMortyDTO = RickAndMortyDTO.builder()
                .gender("TEST")
                .species("TEST")
                .status("DEAD")
                .name("Test name")
                .image(null)
                .build();

        //when
        RickAndMortyEntity rickAndMortyEntityResult = rickAndMortyMapper.toEntity(rickAndMortyDTO);

        //then
        assertAll(
                () -> assertEquals(rickAndMortyEntityResult.getGender(), "TEST"),
                () -> assertEquals(rickAndMortyEntityResult.getSpecies(), "TEST"),
                () -> assertEquals(rickAndMortyEntityResult.getStatus(), "DEAD"),
                () -> assertEquals(rickAndMortyEntityResult.getName(), "Test name"),
                () -> assertNull(rickAndMortyEntityResult.getImage())
        );
    }

    @DisplayName("Should return RickAndMortyDTO from RickAndMortyEntity with same values")
    @Test
    void shouldReturnRickAndMortyDTOFromRickAndMortyEntityWithSameValues() {

        //given
        RickAndMortyEntity rickAndMortyEntity = RickAndMortyEntity.builder()
                .gender("TEST")
                .species("TEST")
                .status("DEAD")
                .name("Test name")
                .image(null)
                .build();

        //when
        RickAndMortyDTO rickAndMortyDTOResult = rickAndMortyMapper.toDTO(rickAndMortyEntity);

        //then
        assertAll(
                () -> assertEquals(rickAndMortyDTOResult.gender(), "TEST"),
                () -> assertEquals(rickAndMortyDTOResult.species(), "TEST"),
                () -> assertEquals(rickAndMortyDTOResult.status(), "DEAD"),
                () -> assertEquals(rickAndMortyDTOResult.name(), "Test name"),
                () -> assertNull(rickAndMortyDTOResult.image())
        );
    }
}