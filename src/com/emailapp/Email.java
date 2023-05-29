package com.emailapp;
import java.util.*;
import java.io.*;
public class Email {
    public Scanner scan = new Scanner (System.in);
    //Member Variables private encapsulation
    private String firstName ;
    private String lastName ;
    private Department  department ;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alternateEmail;
    private Company companyName;
    {
        companyName = Company.companyGroups;
    }

    //Constructor to Receive firstName, lastName
    public Email(String firstName, String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        System.out.println("New Employee Created Employee:" +this.firstName+" "+this.lastName);
        this.department=setDepartment();
        this.password=generatePassword(8);
        generateEmail();
    }
    //Email Generation
    private void generateEmail ()
    {
        this.email=(this.firstName+"."+this.department+ "@"+companyName+".com").toLowerCase();
    }
    //Asking for Department
    private Department setDepartment()
    {
        boolean flag = false;
        do {
            System.out.println(("--------------------------------------------------"));
            System.out.println("Department codes \n1-Accounts \n2-Development \n3-Devops \n4-HumanResources \n5-Support \n6-Sales");
            System.out.println("Enter Department Code");
            int Choice = scan.nextInt();
            switch (Choice) {
                case 1:
                    return Department.Accounts;
                case 2:
                   return Department.Development;
                case 3:
                    return Department.Devops;
                case 4:
                    return Department.HR;
                case 5:
                   return Department.Sales;
                   case 6:
                       return Department.Support;
                default:
                    System.out.println("Invalid Choice !!! \n Enter The Valid Choice");
            }
        }while(!flag);
        System.out.println("Department :" +this.department +" is selected" );
        return null;
    }
    public String  generatePassword(int length)
    {
        Random r = new Random();
        String Capital_Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_Chars = "abcdefghijklmnopqrstuvwxyz";
        String Numbers ="0123456789";
        String Symbols ="!@#$%&*?";
        String combo = Capital_Chars+Small_Chars+Numbers+Symbols;
        for(int i=0;i<length ;i++)
        {
            password += combo.charAt((r.nextInt(combo.length()-1)));
        }
        return password;
    }
    public void setPassword ()
    {
        boolean flag = false;
        do{
            System.out.println("Do You Want to Change Your Password \nY - yes to Change \nN - No to Cancel");
            char choice  = scan.next().charAt(0);
            if(choice == 'Y'|| choice == 'y')
            {
                flag =true;
                System.out.println("Enter The New Password");
                String temp = scan.next();
                if(temp.equals(this.password)) {
                    System.out.println("Oh No!!! it's a Old Password \nEnter the New Password");
                    temp = scan.next();
                    this.password = temp;
                    System.out.println("Password Changed Successfully");
                }
            }
            else if (choice=='n' || choice =='N')
            {
                flag = true;
                System.out.println("Thank you Password Change Cancelled");
            }
            else{
                System.out.println("Enter Valid Choice");
            }
        }while(!flag);
    }

    public void setMailCapacity() {
        System.out.println("Current MailBox Capacity is " + mailCapacity);
        System.out.println("Enter New MailBox capacity");
        this.mailCapacity = scan.nextInt();
        System.out.println("MailBox capacity Changed");
    }
    public void setAlternateEmail()
    {
        System.out.println("Enter Alternate Email ID");
        this.alternateEmail = scan.next();
        System.out.println("Alternate Mail ID Updated");
    }
    public String getInfo() {
        System.out.println("-------------------INFO-----------------------");
        return
                "First Name=" + firstName + "\nLast Name=" + lastName+
                "\nDepartment=" + department +
                "\nEmail=" + email + "\nPassword =" +this.password +
                "\nMail Capacity=" + mailCapacity +
                "\nalternateEmail=" + alternateEmail;
    }
    public void storeData(){
        try{
            FileWriter in = new FileWriter("E:\\javaCodingPractice\\coreJavaProject\\EmailApplication\\info.txt");
            in.write("\nFirst Name : " + this.firstName);
            in.append("\nLast Name : "+this.lastName);
            in.append("\nDepartment : "+ this.department);
            in.append("\nEmail Id : " + this.email);
            in.append("\nPassword : "+this.password);
            in.append("\nMail Box Capacity : " + this.mailCapacity);
            in.append("\nAlternate Email ID : " + this.alternateEmail);
            in.close();
            System.out.println("Data Stored Successfully");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void readFile()
    {
        try{
            FileReader f = new FileReader("E:\\javaCodingPractice\\coreJavaProject\\EmailApplication\\info.txt");
            int i;
            while((i=f.read() )!= -1)
            {
                System.out.print((char)i);
            }
            f.close();
            System.out.println();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}