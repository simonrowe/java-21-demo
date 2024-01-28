package dev.simonrowe.java21demo.service;

import dev.simonrowe.java21demo.domain.CatFact;
import dev.simonrowe.java21demo.mongo.CatFactRepository;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Observed
@Slf4j
@RequiredArgsConstructor
public class CatFactServiceImpl implements CatFactService {

    private final CatFactRepository catFactRepository;

    private final ObservationRegistry observationRegistry;

    @Override
    public CatFact getCatFact() {
        var numberOfCatFacts = catFactRepository.count();
        int randomCatFactId = (int) (Math.random() * numberOfCatFacts);
        if (randomCatFactId == 0) {
            randomCatFactId = 1;
        }
        final CatFact catFact = catFactRepository.findById(randomCatFactId).get();
        log.info("Returning catfact {}", catFact);
        return catFact;
    }


}
