package ru.kds.tests.github;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckSelenideRepoWiki {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    public void afterEach() {

        Selenide.closeWebDriver();
    }
    @Test
    void checkSelenideRepoWiki()

    {
        //Откройте страницу Selenide в Github
        open("/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions

            //если в изначальном списке страниц нет SoftAssertions
            if ($("#wiki-pages-box").find(byText("SoftAssertions")).exists() == false)
            {
            // , то раскрываем полный список страниц
                System.out.println("Не нашли SoftAssertions в изначальном списке страниц, пробуем раскрыть полный список");
                $(".js-wiki-more-pages-link").click();
                // проверяем, что страница SoftAssertions есть в полном списке
                $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
                System.out.println("SoftAssertions найдена в расширенном списке страниц");
            } else {
                System.out.println("SoftAssertions найдена в изначальном списке страниц");
            }

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        $("#wiki-body")
                .$(byText("Using JUnit5 extend test class:"))
                .parent() // поднялись наверх по DOM (элемент <ol>..</ol>)
                .sibling(0)// выбрали первого "соседа" вниз (div)
                .shouldHave(text("@Test"));
        //добавим скриншот
        $("#wiki-body")
                .$(byText("Using JUnit5 extend test class:"))
                .parent() // поднялись наверх по DOM (элемент <ol>..</ol>)
                .scrollTo();
        // build/reports/tests/checkJunit5Example.png
        String checkJunit5Example = screenshot("checkJunit5Example");
    }
}
