package ru.kds.tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void afterEach() {

        Selenide.closeWebDriver();
    }
}
