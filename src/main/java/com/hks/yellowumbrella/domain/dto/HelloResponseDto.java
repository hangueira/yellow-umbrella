package com.hks.yellowumbrella.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final 선언된 변수만 생성자로 만들어준다.
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
