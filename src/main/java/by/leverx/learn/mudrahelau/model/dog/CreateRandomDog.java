package by.leverx.learn.mudrahelau.model.dog;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author Viktar on 15.05.2020
 */
public class CreateRandomDog {

    private static final char[] VOWEL_LETTERS = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};
    private static final char[] CONSONANT_LETTERS = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};
    private static final double MIN_AGE = 0;
    private static final double MAX_AGE = 20;

    public static Dog createRandomGod() {
        Dog dog = new Dog();
        dog.setName(getName());
        dog.setAge(getAge());
        dog.setFed(getRandomBoolean());
        dog.setTrained(getRandomBoolean());
        dog.setTrained(getRandomBoolean());
        return dog;
    }

    private static String getName() {
        char[] name = new char[5];

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < name.length; j++) {
                if (j % 2 != 0) {
                    int randomConsonantLetter = new Random().nextInt(CONSONANT_LETTERS.length);
                    name[j] = CONSONANT_LETTERS[randomConsonantLetter];
                } else {
                    int randomVowelLetter = new Random().nextInt(VOWEL_LETTERS.length);
                    name[j] = VOWEL_LETTERS[randomVowelLetter];
                }
            }
        }
        name[0] = Character.toUpperCase(name[0]);
        return new String(name);
    }

    private static double getAge() {
        double random = new Random().nextDouble();
        return Math.round((MIN_AGE + (random * (MAX_AGE - MIN_AGE))) * 10) / 10.0;
    }

    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
