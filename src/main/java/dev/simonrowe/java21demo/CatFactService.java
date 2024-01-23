package dev.simonrowe.java21demo;

import io.micrometer.tracing.annotation.NewSpan;

public interface CatFactService {

    @NewSpan(value = "service-call")
    CatFact getCatFact();
}
