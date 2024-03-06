package pl.rick_and_morty.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.rick_and_morty.entity.RickAndMortyEntity;
import pl.rick_and_morty.mapper.RickAndMortyMapper;
import pl.rick_and_morty.model.RickAndMortyDTO;
import pl.rick_and_morty.repository.RickAndMortyRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RickAndMortyServiceImpl implements RickAndMortyService {

    private final WebClient webClient;

    private final RickAndMortyRepository rickAndMortyRepository;

    private final RickAndMortyMapper rickAndMortyMapper;

    @Value("${api.url}")
    private String rickAndMortyApiUrl;

    @Override
    public RickAndMortyDTO getCharacter(Long id) {
        RickAndMortyEntity rickAndMortyEntity = rickAndMortyRepository.findById(id)
                .orElseGet(() -> saveNewCharacter(getRickAndMortyDataFromApi(id).block()));

        return rickAndMortyMapper.toDTO(rickAndMortyEntity);
    }

    private RickAndMortyEntity saveNewCharacter(RickAndMortyDTO rickAndMortyDTO) {
        RickAndMortyEntity entityToSave = rickAndMortyMapper.toEntity(rickAndMortyDTO);
        return rickAndMortyRepository.save(entityToSave);
    }

    private Mono<RickAndMortyDTO> getRickAndMortyDataFromApi(Long characterId) {
        return webClient.get()
                .uri(rickAndMortyApiUrl + characterId)
                .retrieve()
                .bodyToMono(RickAndMortyDTO.class);
    }
}
