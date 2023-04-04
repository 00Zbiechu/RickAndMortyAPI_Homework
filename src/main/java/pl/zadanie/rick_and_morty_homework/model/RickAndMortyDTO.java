package pl.zadanie.rick_and_morty_homework.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RickAndMortyDTO
{
    Long id;

    String name;

    String status;

    String type;

    String species;

    String gender;

    String image;

}
