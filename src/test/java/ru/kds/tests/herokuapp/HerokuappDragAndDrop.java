package ru.kds.tests.herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HerokuappDragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    public void afterEach() {

        Selenide.closeWebDriver();
    }
    @Test
    void herokuappDragAndDrop () {
    //Откройте https://the-internet.herokuapp.com/drag_and_drop
    open("/drag_and_drop");
    //Перенесите прямоугольник А на место В
        // варианты с actions (не отрабатывают на данном сайте)
        // 1) moveToElement($("#column-a"))
//        actions().moveToElement($("#column-b")).clickAndHold().moveToElement($("#column-b")).release().perform();
        // 2) moveByOffset(300, 200)
//        actions().moveToElement($("#column-b")).clickAndHold().moveByOffset(300, 0).release().perform();
        // 3) clickAndHold($("#column-a"))
//        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
//sleep(2000);
        // вариант dragAndDrop
        $("#column-a").dragAndDropTo("#column-b");
    //Проверьте, что прямоугольники действительно поменялись
        $("#column-a > header").shouldHave(text("B"));
        //добавим скриншот
        // build/reports/tests/checkHerokuappDragAndDrop.png
        String herokuappDragAndDropExample = screenshot("checkHerokuappDragAndDrop");

    }
}
