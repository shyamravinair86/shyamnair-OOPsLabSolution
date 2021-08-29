package com.company.services;

import java.util.Random;

public class CredentialService {
    private final int passwordLength = 8;
    private final String domainName = "abc.com";
    private String firstName;
    private String lastName;
    private String department;
    private String userEmail;
    private String userPassword;


    public CredentialService(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public void generatePassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedCharacters = numbers + upperCaseLetters + lowerCaseLetters + specialCharacters;
        Random random = new Random();
        char[] password = new char[passwordLength];

        password[0] = numbers.charAt(random.nextInt(numbers.length()));
        password[1] = upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length()));
        password[2] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[3] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));

        for(int i = 4; i < passwordLength; i++) {
            password[i] = combinedCharacters.charAt(random.nextInt(combinedCharacters.length()));
        }

        userPassword = new String(password);
    }

    public void generateEmailAddress() {
        userEmail = firstName.toLowerCase() + lastName.toLowerCase() + "." + department + "@" + domainName;
    }

    public void showCredential() {
        System.out.println("Dear " + firstName + " your generated credentials are as follows");
        System.out.println("Email --> " + userEmail);
        System.out.println("Password --> " + userPassword);
    }
}
