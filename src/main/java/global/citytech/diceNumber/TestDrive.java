package global.citytech.diceNumber;

import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        Dice dc = new Dice();

        for (int k = 0; k < times - 1; k++) {
            dc.rollTheDice();
        }

        dc.printResult();
    }
}