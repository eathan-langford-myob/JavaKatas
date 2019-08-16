package com.MagicCalculator;
import java.util.Scanner;

public class MagicCalculator {
    static Scanner userInput = new Scanner(System.in);

    public static Boolean validateInput(String userWord){
        boolean valid = userWord.chars().allMatch(Character::isLetter) || userWord.chars().allMatch(Character::isDigit);
        if(!valid){
            System.out.println("Sorry, invalid input");
            return false;
        }else {
            return true;
        }
    }

    public static String getInput(String question){
        boolean valid = false;
        String response = "";
        while(!valid){
            System.out.println(question);
            response = userInput.nextLine();
            valid = validateInput(response);
        }
        return response;
    }

    public static User buildUser(String firstName, String lastName, String salary, String startDate){
        User newUser = null;
        if(firstName!=null && lastName!=null && salary!=null && startDate!=null){
            newUser = new User(firstName, lastName, Integer.parseInt(salary), Integer.parseInt(startDate));
            return newUser;
        }else {
            System.out.println("Something went wrong.");
        }
        return newUser;
    }

    public static void calculations(User user){
        int magicYear = User.magicYearCalculate(user.startDate);
        int monthlySalary = User.calculateMonthlySalary(user.salary);
        user.setMonthlySalary(monthlySalary);
        user.setMagicYear(magicYear);
    }

    public static void main(String[] args) {
        String firstName = getInput("Please input your First Name:");
        String lastName = getInput("Please input your Last Name:");
        String salary = getInput("Please input your yearly salary:");
        String startDate = getInput("Please input your work start year:");
        User user = buildUser(firstName, lastName, salary, startDate);
        calculations(user);
        System.out.println("\nRESULTS ARE IN:");
        System.out.println(user.toString());



    }
}
