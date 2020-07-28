package com.example.restservice.jpasample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class MemberHateoas extends RepresentationModel<MemberHateoas>{

    private final String name;

    private final Integer age;

    //JSON 타입을 받을 JsonCreator 생성자 생성
    @JsonCreator
    public MemberHateoas(@JsonProperty("name") String name, @JsonProperty("age") Integer age) {
        this.name = name;
        this.age = age;
    }
}
