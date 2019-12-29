package com.springboot.sso.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RestReactiveClient {
    @Autowired
    private WebClient client;

    @GetMapping(value = "/singlecolourv1")
    Mono<String> singlecolourv1()
    {
        return  client.get()
                .uri("http://localhost:9090/singlecolour/blue")
                .retrieve().bodyToMono(String.class);
    }
    @GetMapping(value = "/singlecolourv2")
    Mono<Void> singlecolourv2()
    {
        client.get()
                .uri("http://localhost:9090/singlecolour/green")
                .retrieve().bodyToMono(String.class).subscribe(System.out::println);
        return Mono.empty();
    }

    @GetMapping(value = "/coloursv1")
    Mono<List> coloursv1()
    {
        return client.get()
                .uri("http://localhost:9090/colours")
                .retrieve().bodyToMono(List.class).log();
    }

    @GetMapping(value = "/coloursv2")
    Mono<Void> coloursv2()
    {
        client.get()
                .uri("http://localhost:9090/colours")
                .retrieve().bodyToMono(List.class).subscribe(System.out::println);


        return Mono.empty();
    }
    @GetMapping(value = "/coloursv3")
    Mono<Void> coloursv3()
    {
        client.get()
                .uri("http://localhost:9090/colours")
                .retrieve().bodyToMono(List.class).subscribe(
                        item -> item.toString(),
                Throwable::printStackTrace,
                () -> System.out.println("done")

        );


        return Mono.empty();
    }

    @GetMapping(value = "/coloursv4")
    Mono<Void> coloursv4()
    {
        client.get()
                .uri("http://localhost:9090/colours")
                .retrieve().bodyToMono(List.class).subscribe(
                (item) -> item.toString(),
                Throwable::printStackTrace,
                () -> System.out.println("done")

        );


        return Mono.empty();
    }


}
