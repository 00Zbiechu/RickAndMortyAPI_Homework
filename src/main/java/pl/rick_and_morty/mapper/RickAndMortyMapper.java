package pl.rick_and_morty.mapper;

import org.mapstruct.Mapper;
import pl.rick_and_morty.entity.RickAndMortyEntity;
import pl.rick_and_morty.model.RickAndMortyDTO;

@Mapper(componentModel = "spring")
public interface RickAndMortyMapper {

    RickAndMortyEntity toEntity(RickAndMortyDTO rickAndMortyDTO);

    RickAndMortyDTO toDTO(RickAndMortyEntity rickAndMortyEntity);
}
