package dev.simonrowe.java21demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "catfacts")
public record CatFact(@Id Integer id, String fact, Integer length) {

}
