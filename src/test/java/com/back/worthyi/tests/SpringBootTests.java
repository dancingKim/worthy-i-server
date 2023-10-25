//package com.back.worthyi.tests;
//
//import com.back.worthyi.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestConstructor;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//import java.nio.charset.StandardCharsets;
//
//@AutoConfigureMockMvc
//@SpringBootTest
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//@RequiredArgsConstructor
//public class SpringBootTests {
//    private final UserService userService;
//    private final MockMvc mockMvc;
//    private final ObjectMapper objectMapper;
//
//    @Test
//    public void getTest() throws Exception{
//        RequestBuilder requestBuilder = MockMvcBuilder.get("/user/get/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
//                .characterEncoding(StandardCharsets.UTF_8.displayName());
//    }
//}
