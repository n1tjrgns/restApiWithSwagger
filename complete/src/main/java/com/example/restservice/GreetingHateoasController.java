package com.example.restservice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GreetingHateoasController {

    private static final String template = "Hello Hateoas, %s!";

    @GetMapping("/greetoas")
    public HttpEntity<GreetingHateoas> greetingHateoasHttpEntity(@RequestParam(value = "name", defaultValue = "World") String name){

        GreetingHateoas greetingHateoas = new GreetingHateoas(String.format(template, name));
        greetingHateoas.add(linkTo(methodOn(GreetingHateoasController.class).greetingHateoasHttpEntity(name)).withSelfRel());

        return new ResponseEntity<>(greetingHateoas, HttpStatus.OK);
    }
}
