package com.example.restservice.jpasample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Grade {

    GOLD("GOLD", "골드"),
    BRONZE("BRONZE", "브론즈");

    private final String key;
    private final String title;
}
