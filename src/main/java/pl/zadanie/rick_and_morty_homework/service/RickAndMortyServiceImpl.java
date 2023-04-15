package pl.zadanie.rick_and_morty_homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.zadanie.rick_and_morty_homework.entity.RickAndMortyEntity;
import pl.zadanie.rick_and_morty_homework.mapper.RickAndMortyMapper;
import pl.zadanie.rick_and_morty_homework.model.RickAndMortyDTO;
import pl.zadanie.rick_and_morty_homework.repository.RickAndMortyRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RickAndMortyServiceImpl implements RickAndMortyService {

    private final RickAndMortyRepository rickAndMortyRepository;

    @Override
    public RickAndMortyDTO checkIfCharacterIsInDatabase(Long id){

       RickAndMortyEntity rickAndMortyEntity = rickAndMortyRepository.findById(id)
               .orElseGet(()->saveNewCharacter(askRickAndMortyApi(id)));

       return RickAndMortyMapper.INSTANCE.toDTO(rickAndMortyEntity);

    }

    private RickAndMortyEntity saveNewCharacter(RickAndMortyDTO rickAndMortyDTO) {
        RickAndMortyEntity entityToSave = RickAndMortyMapper.INSTANCE.toEntity(rickAndMortyDTO);
        rickAndMortyRepository.save(entityToSave);
        return entityToSave;
    }


    private RickAndMortyDTO askRickAndMortyApi(Long idCharacter){

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate
                .getForObject("https://rickandmortyapi.com/api/character/"+idCharacter, RickAndMortyDTO.class);


    }




}
