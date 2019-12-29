package com.springboot.sso.service;


import com.sun.net.httpserver.BasicAuthenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@RestController
@Log4j2
public class SSOServiceApplication {



	public static void main(String[] args)
	{
		SpringApplication.run(SSOServiceApplication.class, args);
	}




	@Bean
    public WebClient webClient() {
	return WebClient.create();
	}





}