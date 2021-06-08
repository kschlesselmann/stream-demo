package com.example.stream.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/demos")
public class DemoController {

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<DemoModel> findAll() {
        return Flux.just("a", "b")
                .map(DemoModel::new);
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public Mono<CollectionModel<DemoModel>> findAllAsHal() {
        return findAll()
                .collectList()
                .map(CollectionModel::of);
    }

}
