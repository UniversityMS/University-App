package lv.unversityManagementSystem.login;

import java.util.Random;

public class PasswordGeneration {

    int number;

    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    @Override
    public String toString() {
        return "PasswordGeneration{" +
                "number=" + number +
                '}';
    }
}
