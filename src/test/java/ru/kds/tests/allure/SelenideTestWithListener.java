package ru.kds.tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestWithListener {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("/kdimkin1/KDS_AT_PO_demoqa_form");
        $(".header-search-input").submit();

        $(By.linkText("kdimkin1/KDS_AT_PO_demoqa_form")).click();
        $(By.partialLinkText("Issues")).click();
        //disclaimer: можно было бы проверить наличие "Issue" на основной странице репозирория, но для разнообразия,
        //            решил выполнить проверку названия конкретного Issue:
        //проверяем, что Issue c номером 2 имеет название "For Allure One More test"
        $("#issue_2_link").shouldHave(Condition.text("For Allure One More test"));
    }

}
