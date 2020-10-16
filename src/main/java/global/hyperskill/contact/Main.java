package global.hyperskill.contact;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    Contact() {}

    Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (getPhoneNumberMatcher(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = null;
            System.out.println("Wrong number format!");
        }
    }

    private Boolean getPhoneNumberMatcher(String phoneNumber) {
        Pattern pattern = Pattern.compile("(^(\\+([a-zA-Z0-9]{1}(( |-)(([a-zA-Z0-9]{2,}|\\([0-9A-Za-z]{2,}\\)))){0,1}|\\([0-9A-Za-z]{1,}\\)(( |-)(([a-zA-Z0-9]{2,}))){0,1}))|^([a-zA-Z0-9]{1,}(( |-)(([a-zA-Z0-9]{2,}|\\([0-9A-Za-z]{2,}\\)))){0,1}|\\([0-9A-Za-z]{1,}\\)(( |-)(([a-zA-Z0-9]{2,}))){0,1}))(( |-)([a-zA-Z0-9]{2,})){0,}");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + (phoneNumber == null ? "[no number]" : phoneNumber);
    }
}

class ContactBook {
    ArrayList<Contact> records = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void start() {
        loop:
        while (true) {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            String firstChoice = readLine();
            switch (firstChoice) {
                case "add":
                    addContact();
                    break;
                case "remove":
                    removeContact();
                    break;
                case "edit":
                    editContact();
                    break;
                case "count":
                    countContact();
                    break;
                case "list":
                    ListContact();
                    break;
                case "exit":
                    break loop;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    private void editContact() {
        if (records.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            for (int i = 0; i <= records.size() - 1; i++) {
                System.out.println((i + 1) + ". " + records.get(i).toString());
            }

            System.out.println("Select a record:");
            int recordForEdit = readIntLine();
            readLine();

            if (recordForEdit > records.size() | recordForEdit <= 0) {
                System.out.println("Invalid Input!");
            } else {
                Contact contactSelected = records.get(recordForEdit - 1);
                System.out.println("Select a field (name, surname, number):");
                String fieldName = readLine();
                editProcess(contactSelected, fieldName);
            }
        }
    }

    private void editProcess(Contact contactSelected, String fieldName) {
        switch (fieldName) {
            case "name":
                System.out.println("Enter the name:");
                String updateName = readLine();
                contactSelected.setName(updateName);
                System.out.println("The record updated!");
                break;
            case "surname":
                System.out.println("Enter the surname:");
                String updateSurname = readLine();
                contactSelected.setSurname(updateSurname);
                System.out.println("The record updated!");
                break;
            case "number":
                System.out.println("Enter the number:");
                String updateNumber = readLine();
                contactSelected.setPhoneNumber(updateNumber);
                System.out.println("The record updated!");
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }

    private void removeContact() {
        if (records.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            for (int i = 0; i <= records.size() - 1; i++) {
                System.out.println((i + 1) + ". " + records.get(i).toString());
            }

            System.out.println("Select a record:");
            int recordForRemove = readIntLine();
            readLine();

            if (recordForRemove > records.size() | recordForRemove <= 0) {
                System.out.println("Invalid Input!");
            } else {
                records.remove(recordForRemove - 1);
                System.out.println("The record removed!");
            }
        }
    }

    private void countContact() {
        System.out.println("The Phone Book has " + records.size() + " records.");
    }

    private void ListContact() {
        if (records.size() == 0) {
            System.out.println("No records to show!");
        } else {
            for (int i = 0; i <= records.size() - 1; i++) {
                System.out.println((i + 1) + ". " + records.get(i).toString());
            }
        }
    }

    private void addContact() {
        System.out.println("Enter the name of the person:");
        String name = readLine();
        System.out.println("Enter the surname of the person:");
        String surname = readLine();
        System.out.println("Enter the number:");
        String phoneNumber = readLine();
        Contact c = new Contact();
        c.setName(name);
        c.setSurname(surname);
        c.setPhoneNumber(phoneNumber);
        records.add(c);
        System.out.println("The record added.");
    }

    private String readLine() {
        return sc.nextLine();
    }

    private int readIntLine() {
        return sc.nextInt();
    }
}

public class Main {
    public static void main(String[] args) {
        ContactBook cb = new ContactBook();
        cb.start();
    }
}