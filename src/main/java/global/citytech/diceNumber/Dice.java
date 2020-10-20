package global.citytech.diceNumber;

import java.util.Random;

public class Dice {
    private int dice1;
    private int dice2;
    private int[] result = new int[13];

    public Dice() {
    }

    public void rollTheDice() {
        int sum;
        Random rand = new Random();
        dice1 = rand.nextInt(6) + 1;
        dice2 = rand.nextInt(6) + 1;
        sum = dice1 + dice2;
        result[sum] = result[sum] + 1;
    }

    public void printResult() {
        for (int k = 2; k <= result.length - 1; k++) {
            System.out.println(k + "=>" + result[k]);
        }
    }
}
