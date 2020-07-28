package com.example.restservice;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

//HATEOAS 추가하기
public class GreetingHateoas extends RepresentationModel<GreetingHateoas> {

    private final String content;

    //JSON 타입을 받을 JsonCreator 생성자 생성
    @JsonCreator
    public GreetingHateoas(@JsonProperty("content") String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
