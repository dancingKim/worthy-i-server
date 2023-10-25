package com.back.worthyi.tests;

import jdk.jfr.Description;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
public class JUnitTests {
//JUnit5 활용법을 익히기 위한 클래스

    @BeforeAll
    public static void beforeAll(){
        log.info("beforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        log.info("beforeEach");
    }

    @AfterEach
    public void afterEach(){
        log.info("afterEach");
    }

    @AfterAll
    public static void afterAll(){
        log.info("afterAll");
    }

    @Test
    public void noArgsTest(){
        log.info("noArgsTest");
    }

    @ParameterizedTest
    @DisplayName("파라미터를 넣어 테스트")
    @ValueSource(strings = {
            "a", "b", "c", "d"
    })
    public void argsTest(final String s){
        log.info("argsTest : {}",s);
    }

    @ParameterizedTest
    @DisplayName("파라미터를 넣은 Assertion 테스트")
    @ValueSource(ints = {
            1, 2, 3, 4, 5
    })
    public void assertTrueArgsTest(final Integer i){
        Assertions.assertTrue(convert(i));
    }
    private boolean convert(Integer i){
        return i < 5;
    }

    @Test
    public void exceptionTest(){
        Assertions.assertThrows(NumberFormatException.class, this::exceptionGenerator);
    }

    private void exceptionGenerator(){
        throw new NumberFormatException();
    }

}
