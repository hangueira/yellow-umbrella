package com.hks.yellowumbrella.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // 테스트 전 설정이 필요한 경우, @BeforeEach  활용하여 설정을 준비합니다.
    }

    @Test
    @DisplayName("/hello 컨트롤러 테스트")
    public void testHello() throws Exception {
        // MockMvc 사용하여 "/hello" 경로로 GET 요청을 보내고, 기대하는 응답 상태코드와 응답 본문을 확인합니다.
        mockMvc.perform(get("/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                // .andDo(print()) // 눈으로 확인이 필요할때 사용
                .andExpect(status().isOk())
                .andExpect(content().string("hks hello"));
    }


    @Test
    @DisplayName("/hello/dto 컨트롤러 테스트")
    public void testHelloDto() throws Exception {
        String name = "John";
        int amount = 100;

        // MockMvc를 사용하여 "/helloDto" 경로로 GET 요청을 보내고, 파라미터를 전달합니다.
        // 응답으로 기대하는 JSON 형태의 응답 본문을 확인합니다.
        mockMvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
    }
}