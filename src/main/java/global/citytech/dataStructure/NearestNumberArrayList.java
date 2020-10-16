package global.citytech.dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NearestNumberArrayList {
    public static void main(String[] args) {
        // write your code here
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        String arrayLine = sc.nextLine();

        String[] parts = arrayLine.split(" ");

        for (String part : parts) {
            try {
                int n = Integer.parseInt(part);
                // Add to your list
                indexes.add(n);
            } catch (Exception ex) {
                // log
            }
        }

        int target = sc.nextInt();

        int leastDistance = Integer.MAX_VALUE;

        for (int index : indexes) {
            if (Math.abs(index - target) < leastDistance) {
                leastDistance = Math.abs(index - target);
            }
        }

        for (int index : indexes) {
            if (Math.abs(index - target) == leastDistance) {
                answers.add(index);
            }
        }

        Collections.sort(answers);

        answers.forEach(item->{
            System.out.print(item+" ");
        });
    }
}
