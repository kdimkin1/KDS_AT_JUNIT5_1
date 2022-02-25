package ru.kds.docs;

import org.junit.jupiter.api.Test;
import ru.kds.utils.RandomUtils;

public class RandomUtilsExamples {

    @Test
    void randomUtilsExamples() {
        System.out.println("Random string of 10 letters: " + RandomUtils.getRandomString(10));

        int randomInt = RandomUtils.getRandomInt(223333, 100000000);
        System.out.println("Random int between 223333, 100000000: " + randomInt + "");

        String randomPhone = RandomUtils.getRandomPhone();
        System.out.println(randomPhone);

        String randomPhoneWithPrefix = RandomUtils.getRandomPhone("+7");
        System.out.println(randomPhoneWithPrefix);

        String difficultRandomPhoneWithPrefix = RandomUtils.getDifficultRandomPhone("+8");
        System.out.println(difficultRandomPhoneWithPrefix);

        String randomEmail = RandomUtils.getRandomEmail();
        System.out.println(randomEmail);
    }
}
