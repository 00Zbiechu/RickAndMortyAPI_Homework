package pl.rick_and_morty.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RickAndMortyEntity {


    @Id
    private Long id;

    private String name;

    private String status;

    private String type;

    private String species;

    private String gender;

    private String image;
}
