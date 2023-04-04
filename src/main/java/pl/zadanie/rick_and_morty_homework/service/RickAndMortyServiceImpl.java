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

        Optional<RickAndMortyEntity> optionalRickAndMortyEntity = rickAndMortyRepository.findById(id);

        if(optionalRickAndMortyEntity.isPresent()){

            return RickAndMortyMapper.INSTANCE.toDTO(optionalRickAndMortyEntity.get());

        }else{

            RickAndMortyDTO dto = askRickAndMortyApi(id);
            return saveNewCharacter(dto);

        }

    }

    @Override
    public RickAndMortyDTO saveNewCharacter(RickAndMortyDTO rickAndMortyDTO) {
        RickAndMortyEntity entityToSave = RickAndMortyMapper.INSTANCE.toEntity(rickAndMortyDTO);
        rickAndMortyRepository.save(entityToSave);
        return rickAndMortyDTO;
    }


    @Override
    public RickAndMortyDTO askRickAndMortyApi(Long idCharacter){

        RestTemplate restTemplate = new RestTemplate();

        RickAndMortyDTO rickAndMortyDTO = restTemplate
                .getForObject("https://rickandmortyapi.com/api/character/"+idCharacter, RickAndMortyDTO.class);

        return rickAndMortyDTO;

    }




}
