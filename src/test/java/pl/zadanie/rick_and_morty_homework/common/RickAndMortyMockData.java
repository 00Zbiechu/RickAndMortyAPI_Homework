package pl.zadanie.rick_and_morty_homework.common;

import pl.zadanie.rick_and_morty_homework.entity.RickAndMortyEntity;

public class RickAndMortyMockData {

    public static RickAndMortyEntity prepareMockData(){
        return  RickAndMortyEntity.builder()
                .id(2L)
                .gender("TEST")
                .species("Human")
                .status("Alive")
                .type("")
                .name("Morty Smith")
                .image("https://rickandmortyapi.com/api/character/avatar/2.jpeg")
                .build();
    }

}
