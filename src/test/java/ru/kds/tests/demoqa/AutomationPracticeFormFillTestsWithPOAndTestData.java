package ru.kds.tests.demoqa;

import ru.kds.pages.demoqa.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class AutomationPracticeFormFillTestsWithPOAndTestData extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Description("AutomationPracticeFormFillTests")
    @DisplayName("AutomationPracticeFormFillTests(demoqa.com).")
    void apfSuccessFillTest() {
        step("Открыть https://demoqa.com/automation-practice-form", () -> {
            registrationPage.openPage();
        });

        step("Заполнить поле First Name(Anton)", () -> {
            registrationPage.setFirstName(TestData.firstName);
        });

        step("Заполнить поле Last Name (Gorodetskiy)", () -> {
            registrationPage.setLastName(TestData.lastName);
        });

        step("Заполнить поле Email (Anton.Gorodetskiy@mail.com)", () -> {
            registrationPage.setUserEmail(TestData.userEmail);
        });

        step("Заполнить поле Gender (Male)", () -> {
            registrationPage.setFieldWText(TestData.gender);
        });

        step("Заполнить поле Mobile (9296112233)", () -> {
            registrationPage.setUserNumber(TestData.userNumber);
        });

        step("Заполнить поле Date of Birth (19 Aug 1982)", () -> {
            registrationPage.setDateofBirth(TestData.dateOfBirthYear, TestData.dateOfBirthMonth, TestData.dateOfBirthDay);
        });

        step("Заполнить поле Subject (Social Studies, Accounting)", () -> {
            registrationPage.setSubjects(TestData.subjectsInputFirst, TestData.subjectsInputSecond);
        });

        step("Заполнить чекбокс Hobbies (Sports, Music)", () -> {
            registrationPage.setFieldWText(TestData.hobbiesFirst);
            registrationPage.setFieldWText(TestData.hobbiesSecond);
        });

        step("Добавить картинку Picture (AntonG.jpg)", () -> {
            registrationPage.setUploadPicture(TestData.fileWithPicture);
        });

        step("Заполнить поле Current Address (Karnal Bus Stand)", () -> {
            registrationPage.setCurrentAddress(TestData.currentAddress);
        });

        step("Заполнить поле State(Haryana)", () -> {
            // скрыть блок рекламы, если есть
            registrationPage.adClose();
            registrationPage.setState(TestData.state);
        });

        step("Заполнить поле City (Karnal)", () -> {
            registrationPage.setCity(TestData.city);
        });

        step("Отправить форму (Submit)", () -> {
            registrationPage.setSubmit();
        });

        step("Проверить успешную отправку (содержание формы ответа).", () -> {
            registrationPage.checkForm(TestData.firstName, TestData.lastName, TestData.userEmail, TestData.gender, TestData.userNumber, TestData.dateOfBirthDay,
                    TestData.dateOfBirthMonth, TestData.dateOfBirthYear, TestData.subjectsInputFirst, TestData.subjectsInputSecond, TestData.hobbiesFirst,
                    TestData.hobbiesSecond, TestData.fileWithPictureName, TestData.currentAddress, TestData.state, TestData.city);
        });
        step("Закрыть форму (Close)", () -> {
            registrationPage.setClose();
        });


    }

}