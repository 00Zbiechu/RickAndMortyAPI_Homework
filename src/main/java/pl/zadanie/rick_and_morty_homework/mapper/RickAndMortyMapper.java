package pl.zadanie.rick_and_morty_homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.zadanie.rick_and_morty_homework.entity.RickAndMortyEntity;
import pl.zadanie.rick_and_morty_homework.model.RickAndMortyDTO;

@Mapper
public interface RickAndMortyMapper
{

    RickAndMortyMapper INSTANCE = Mappers.getMapper(RickAndMortyMapper.class);


    RickAndMortyEntity toEntity(RickAndMortyDTO rickAndMortyDTO);

    RickAndMortyDTO toDTO(RickAndMortyEntity rickAndMortyEntity);

}
