package pl.zadanie.rick_and_morty_homework.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.zadanie.rick_and_morty_homework.common.BaseApiTest;
import pl.zadanie.rick_and_morty_homework.common.RickAndMortyMockData;
import pl.zadanie.rick_and_morty_homework.repository.RickAndMortyRepository;

import static org.junit.jupiter.api.Assertions.*;


class RickAndMortyControllerTest extends BaseApiTest {

    private final String RICK_AND_MORTY_CONTROLLER_PATH = "/api/rickandmorty";

    @Autowired
    private RickAndMortyRepository rickAndMortyRepository;


    @DisplayName("Should return Morty from Api who already is in DB")
    @Test
    void getCharacter() throws Exception {

        //given
        rickAndMortyRepository.save(RickAndMortyMockData.prepareMockData());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(RICK_AND_MORTY_CONTROLLER_PATH+"/2"));


        //then
        resultActions
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Morty Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("TEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.species").value("Human"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Alive"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value(""))
                .andExpect(MockMvcResultMatchers.jsonPath("$.image").value("https://rickandmortyapi.com/api/character/avatar/2.jpeg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("2"));


    }


    @DisplayName("Should return Morty from Api who isn't in DB")
    @Test
    void getCharacter2() throws Exception {


        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(RICK_AND_MORTY_CONTROLLER_PATH+"/2"));


        //then
        resultActions
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Morty Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.species").value("Human"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Alive"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value(""))
                .andExpect(MockMvcResultMatchers.jsonPath("$.image").value("https://rickandmortyapi.com/api/character/avatar/2.jpeg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("2"));


    }

}