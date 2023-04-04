package pl.zadanie.rick_and_morty_homework.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RickAndMortyEntity {


    @Id
    Long id;

    String name;

    String status;

    String type;

    String species;

    String gender;

    String image;

}
