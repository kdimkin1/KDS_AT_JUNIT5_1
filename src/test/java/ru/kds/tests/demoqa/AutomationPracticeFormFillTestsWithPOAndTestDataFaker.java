package ru.kds.tests.demoqa;

import ru.kds.pages.demoqa.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class AutomationPracticeFormFillTestsWithPOAndTestDataFaker extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Description("AutomationPracticeFormFillTests")
    @DisplayName("AutomationPracticeFormFillTests(demoqa.com).")
    void apfSuccessFillTest() {
        step("Открыть https://demoqa.com/automation-practice-form", () -> {
            registrationPage.openPage();
        });

        step("Заполнить поле First Name(Anton)", () -> {
            registrationPage.setFirstName(TestDataFaker.firstName);
            System.out.println("Имя ="+ TestDataFaker.firstName);
        });

        step("Заполнить поле Last Name (Gorodetskiy)", () -> {
            registrationPage.setLastName(TestDataFaker.lastName);
        });

        step("Заполнить поле Email (Anton.Gorodetskiy@mail.com)", () -> {
            registrationPage.setUserEmail(TestDataFaker.userEmail);
        });

        step("Заполнить поле Gender (Male)", () -> {
            registrationPage.setFieldWText(TestDataFaker.gender);
        });

        step("Заполнить поле Mobile (9296112233)", () -> {
            registrationPage.setUserNumber(TestDataFaker.userNumber);
        });

        step("Заполнить поле Date of Birth (19 Aug 1982)", () -> {
            registrationPage.setDateofBirth(TestDataFaker.dateOfBirthYear, TestDataFaker.dateOfBirthMonth, TestDataFaker.dateOfBirthDay);
        });

        step("Заполнить поле Subject (Social Studies, Accounting)", () -> {
            registrationPage.setSubjects(TestDataFaker.subjectsInputFirst, TestDataFaker.subjectsInputSecond);
        });

        step("Заполнить чекбокс Hobbies (Sports, Music)", () -> {
            registrationPage.setFieldWText(TestDataFaker.hobbiesFirst);
            registrationPage.setFieldWText(TestDataFaker.hobbiesSecond);
        });

        step("Добавить картинку Picture (AntonG.jpg)", () -> {
            registrationPage.setUploadPicture(TestDataFaker.fileWithPicture);
        });

        step("Заполнить поле Current Address (Karnal Bus Stand)", () -> {
            registrationPage.setCurrentAddress(TestDataFaker.currentAddress);
        });

        step("Заполнить поле State(Haryana)", () -> {
            // скрыть блок рекламы, если есть
            registrationPage.adClose();
            registrationPage.setState(TestDataFaker.state);
        });

        step("Заполнить поле City (Karnal)", () -> {
            registrationPage.setCity(TestDataFaker.city);
        });

        step("Отправить форму (Submit)", () -> {
            registrationPage.setSubmit();
        });

        step("Проверить успешную отправку (содержание формы ответа).", () -> {
            registrationPage.checkForm(TestDataFaker.firstName, TestDataFaker.lastName, TestDataFaker.userEmail, TestDataFaker.gender, TestDataFaker.userNumber, TestDataFaker.dateOfBirthDay,
                    TestDataFaker.dateOfBirthMonth, TestDataFaker.dateOfBirthYear, TestDataFaker.subjectsInputFirst, TestDataFaker.subjectsInputSecond, TestDataFaker.hobbiesFirst,
                    TestDataFaker.hobbiesSecond, TestDataFaker.fileWithPictureName, TestDataFaker.currentAddress, TestDataFaker.state, TestDataFaker.city);
        });
        step("Закрыть форму (Close)", () -> {
            registrationPage.setClose();
        });


    }

}