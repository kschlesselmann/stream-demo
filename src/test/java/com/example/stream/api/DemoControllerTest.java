package com.example.stream.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class DemoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldRetrieveResponseAsStream() {
        var expectedResponseBody = """
                {"name":"a"}
                {"name":"b"}
                """;

        webTestClient.get()
                .uri("/demos")
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectBody(String.class)
                .isEqualTo(expectedResponseBody);
    }
}
