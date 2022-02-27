package ru.kds.tests.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Класс с простыми тестами")
public class SimpleTest {

    @BeforeAll
    void simpleBeforeAll() {
        System.out.println("Annotation @BeforeAll executed.");
    }
    @AfterAll
    void simpleAfterAll() {
        System.out.println("Annotation @AfterAll executed.");
    }
    @BeforeEach
    void simpleBeforeEach() {
        System.out.println("Annotation @BeforeEach executed.");
    }
    @AfterEach
    void simpleAfterEach() {
        System.out.println("Annotation @AfterEach executed.");
    }


    @Test
    @DisplayName("Ожидаемо зеленый тест")
    void simpleGreenTest() {
        assertTrue(3 > 2);
    }

    @Test
    @DisplayName("Ожидаемо красный тест")
    void simpleRedTest() {
        assertTrue(3 < 2);
    }

    @Test
    @Disabled("bug: JIRA-12232")
    void simpleBrokenTest() {
        throw new IllegalStateException("Broken :(");
    }
}
