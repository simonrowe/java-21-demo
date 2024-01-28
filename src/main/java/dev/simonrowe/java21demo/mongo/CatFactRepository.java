package dev.simonrowe.java21demo.mongo;

import dev.simonrowe.java21demo.domain.CatFact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatFactRepository extends CrudRepository<CatFact, Integer> {
}
