package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String altEmail;
    private String password;
    private String department;
    private String companySuffix = "capco.com";
    private int defaultPasswordLength = 18;
    private int mailboxCapacity = 500;

    //constructor to receive first and last name

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix.toLowerCase();
    }
    private String setDepartment(){
        System.out.print("New Employee: " + firstName + " " + lastName + "\nDEPARTMENT CODES\n1 For sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1){
            return "sales";
        }else if(departmentChoice == 2){
            return "dev";
        }else if(departmentChoice == 3){
            return "accounting";
        }else{
            return"";
        }
    }
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyz";
        char[] password = new char[length];
        for (int i=0;i<length;i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAltEmail(String altEmail){
        this.altEmail = altEmail;
    }
    public void changePassword(String password) {
        this.password = password;
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public String getAltEmail() {
        return altEmail;
    }
    public String getPassword() {
        return password;
    }
    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nPassword: " + password +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }

}
