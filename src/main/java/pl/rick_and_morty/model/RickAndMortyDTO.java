package pl.rick_and_morty.model;

import lombok.Builder;

@Builder
public record RickAndMortyDTO(Long id, String name, String status, String type, String species, String gender,
                              String image) {
}
