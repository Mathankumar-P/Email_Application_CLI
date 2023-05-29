package com.emailapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Greetings Welcome to Email Application Enter Your Details to Create An Email ID");
        System.out.println("Enter The First Name ");
        String firstName= scan.next();
        System.out.println("Enter The Last Name ");
        String lastName= scan.next();
        Email email = new Email(firstName,lastName);
        int choice = -1;
        do{
            System.out.println(("--------------------------------------------------"));
            System.out.println("Enter Your Choice: \n1 - Get Info \n2 - Set Password \n3 - Change Mail Capacity \n4 - Set Alternate Email \n5 - Store Data " +
                    "\n6 - Read Data \n7 - Exit");
            choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println(email.getInfo());
                    break;
                case 2:
                    email.setPassword();
                    break;
                case 3:
                    email.setMailCapacity();
                    break;
                case 4:
                    email.setAlternateEmail();
                    break;
                case 5:
                    email.storeData();
                    break;
                case 6:
                    email.readFile();
                    break;
                case 7:
                    System.out.println("Thank you for Using Mail Application");
                    break;
                default:
                    System.out.println("Invalid Choice !! \n Enter Valid Choice Again");
            }

        }while(choice != 7);


    }
}
