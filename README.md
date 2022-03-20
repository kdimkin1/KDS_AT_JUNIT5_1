# Automation Tests (JUnit5, Allure examples)

## Technology Stack
| <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"  alt="Java"/></a> |<a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"  alt="Gradle"/></a> |<a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"  alt="Selenide"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="40" height="40"  alt="Allure"/></a> |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------:| :---------: | :---------: | :---------: | :---------: |:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                                           IDEA                                                                            | Java | Junit5 | Gradle | Selenide |                                                                         Allure                                                                          |

See details:  
```bash
JUnit5:

1) "Test examples with DataProviders"
src/test/java/ru/kds/tests/junit5/ParametreziedTestAPFormFillTestsWithPOAndVars.java
 csvSourceapfSuccessFillTest
 mixedArgumentsapfSuccessFillTest

2) "JUnitCore.java class modified for support @BeforeEach / @AfterEach, @BeforeAll/AfterAll"
src/test/java/ru/kds/tests/junit5/SimpleTest.java
src/test/java/ru/kds/tests/junit5/JunitCore.java

Allure: 
1) "Чистый Selenide (с Listener)"
src/test/java/ru/kds/tests/allure/SelenideTestWithListener.java
2) "Лямбда шаги через step (name, () -> {})" 
src/test/java/ru/kds/tests/allure/StepsTest.java
 testLambdaSteps
3) "Шаги с аннотацией @Step"
src/test/java/ru/kds/tests/allure/StepsTest.java
 testLambdaSteps

Work with Files:
1) "один zip архив несколько разных файлов - pdf, xlsx, csv."
src/test/java/ru/kds/tests/files/FilesParsingZipHWTest.java
2) "разбор json  файла библиотекой Jackson"
src/test/java/ru/kds/tests/files/JacksonJsonHWTest.java



