package global.citytech.pattern.builder;

import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {

//        AlertDialog twoButtonsDialog = new AlertDialog.Builder()
//                .setTitle("hahahah")
//                .setApplyButton("sadfasfd")
//                .build();
//
//        System.out.println(twoButtonsDialog.toString());

        final Scanner scanner = new Scanner(System.in);
        final String geekName = scanner.nextLine();
        final String geekType = scanner.nextLine();
        scanner.close();
        GeekDirector director = new GeekDirector();
        GeekBuilder builder = new GeekBuilder();
        Geek geek = null;
        if ("Rockstar".equals(geekType)) {
            director.buildRockstar(builder);
            geek = builder.getResult();
        } else if ("Backend".equals(geekType)) {
            director.buildBackend(builder);
            geek = builder.getResult();
        } else if ("Admin".equals(geekType)) {
            director.buildAdmin(builder);
            geek = builder.getResult();
        } else {
            System.out.println("Error");
            return;
        }
        System.out.println("Geek " + geekName + " created.");
        System.out.println(geek);
    }
}