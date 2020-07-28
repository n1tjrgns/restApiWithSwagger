package com.example.restservice.jpasample;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private Member(String name, Integer age, Grade grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
