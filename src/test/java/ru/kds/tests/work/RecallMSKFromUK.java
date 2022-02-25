package ru.kds.tests.work;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RecallMSKFromUK {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "http://10.0.2.38:9080";
//        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        open("/uspn");
        $("body > div > form > input.login.login-submit").click();
    }

    @AfterEach
    public void afterEach() {

        Selenide.closeWebDriver();
    }

    @Test
    void setPeriod(){
        open("/uspn/forms/calculation/recallFundsMskFromUk");
        $("#collapseOneSelector").hover().click();
        $("#period").hover().click();
// $("#dropdownlistArrowperiod > div:nth-child(1)").click();
//         sleep(2000);
//         $("#listBoxContentinnerListBoxperiod").$(Selectors.byText("ноябрь 2016")).scrollIntoView(false).click();
//         $("#listBoxContentinnerListBoxperiod").$x("//*[@id=\"listitem73innerListBoxperiod\"]").scrollIntoView(false).click();
//
//         $("#listBoxContentinnerListBoxperiod")
//                .scrollIntoView("{block: \"end\"}").click();
//                 .scrollIntoView("{behavior: \"instant\"}").click();
//                 .scrollIntoView(false).click();
//
//     $("#listBoxContentinnerListBoxperiod").$(byText("ноябрь 2016")).scrollIntoView(false).click();
         SelenideElement periodCheck = $("#listBoxContentinnerListBoxperiod").$(byText("ноябрь 2016"));
         while (periodCheck.isDisplayed() == false)
         {
             for (int i=1; i<=5; i++) {
             $("#jqxScrollBtnDownverticalScrollBarinnerListBoxperiod").click();
             sleep(2);}
         }
         sleep(5000);

//        for (int i=1; i<=177; i++)
//        {
///*
//            if ($("#period").shouldBe(Condition.visible).exists() == false)
//            {$("#collapseOneSelector").click();}
//*/
//            $("#jqxScrollBtnDownverticalScrollBarinnerListBoxperiod").click();
//        }


//        $("#listBoxContentinnerListBoxperiod").getSize()
//        $("#listBoxContentinnerListBoxperiod").$(byText("ноябрь 2016")).scrollTo().click();
//         $("#listBoxContentinnerListBoxperiod").$(byText("ноябрь 2016")).click();
         $("#listBoxContentinnerListBoxperiod").$(Selectors.byText("ноябрь 2016")).click();
         $("#searchButton").click();
        //selectOption("ноябрь 2016");
        sleep(1000);
//                $(byText("ноябрь 2016")).click();



    }
}
