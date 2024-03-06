package pl.rick_and_morty.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.rick_and_morty.common.BaseTest;
import pl.rick_and_morty.common.RickAndMortyMockData;
import pl.rick_and_morty.model.RickAndMortyDTO;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class RickAndMortyControllerTest extends BaseTest {

    private final String RICK_AND_MORTY_CONTROLLER_PATH = "/api/rickandmorty";

    @DisplayName("Should return Morty from Api who already is in database")
    @Test
    void shouldReturnMortyFromApiWhoAlreadyIsInDB() throws Exception {

        //given
        entityManager.merge(RickAndMortyMockData.prepareMockData());

        //when
        var result = mockMvc.perform(MockMvcRequestBuilders.get(RICK_AND_MORTY_CONTROLLER_PATH + "/2"));

        //then
        var response = asObject(result, RickAndMortyDTO.class);
        result.andExpect(status().isOk());
        assertAll(
                () -> assertEquals("Morty Smith", response.name()),
                () -> assertEquals("TEST", response.gender()),
                () -> assertEquals("Human", response.species()),
                () -> assertEquals("Alive", response.status()),
                () -> assertEquals("", response.type()),
                () -> assertEquals("https://rickandmortyapi.com/api/character/avatar/2.jpeg", response.image()),
                () -> assertEquals(2L, response.id())
        );
    }

    @DisplayName("Should return Morty from Api who is not in database")
    @Test
    void shouldReturnMortyFromApiWhoIsNotInDB() throws Exception {

        //when
        var result = mockMvc.perform(MockMvcRequestBuilders.get(RICK_AND_MORTY_CONTROLLER_PATH + "/2"));
        var response = asObject(result, RickAndMortyDTO.class);

        //then
        result.andExpect(status().isOk());
        assertAll(
                () -> assertEquals("Morty Smith", response.name()),
                () -> assertEquals("Male", response.gender()),
                () -> assertEquals("Human", response.species()),
                () -> assertEquals("Alive", response.status()),
                () -> assertEquals("", response.type()),
                () -> assertEquals("https://rickandmortyapi.com/api/character/avatar/2.jpeg", response.image()),
                () -> assertEquals(2L, response.id())
        );
    }
}