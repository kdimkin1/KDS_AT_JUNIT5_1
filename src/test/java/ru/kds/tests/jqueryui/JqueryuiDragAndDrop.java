package ru.kds.tests.jqueryui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JqueryuiDragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://jqueryui.com/";
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    public void afterEach() {

        Selenide.closeWebDriver();
    }
    @Test
    void jqueryuiDragAndDrop () {
        //Откройте https://jqueryui.com/resources/demos/droppable/default.html
        open("/resources/demos/droppable/default.html");
        //Перенесите элемент "Drag me" на "Drop here"
        // варианты с actions (все рабочие)
        // 1) moveToElement($("#draggable"))
        actions().moveToElement($("#draggable")).clickAndHold().moveToElement($("#droppable")).release().perform();
        // 2) moveByOffset(300, 200)
//        actions().moveToElement($("#draggable")).clickAndHold().moveByOffset(150, 30).release().perform();
        // 3) clickAndHold($("#column-a"))
//        actions().clickAndHold($("#draggable")).moveToElement($("#droppable")).release().perform();
//sleep(2000);
        // вариант dragAndDrop
//        $("#draggable").dragAndDropTo("#droppable");
        //добавим скриншот
        // build/reports/tests/jqueryuicheckDragAndDrop.png
        String jqueryuiDragAndDropExample = screenshot("jqueryuiDragAndDrop");

    }


}
