package com.example.stream.api;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(itemRelation = "demo", collectionRelation = "demos")
public class DemoModel extends RepresentationModel<DemoModel> {

    private final String name;

    public DemoModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
