package com.MagicCalculator;

public class User {
    String firstName;
    String lastName;
    int salary;
    int startDate;
    int monthlySalary;
    int magicYear;

    public User(String firstName, String lastName, int salary, int startDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.startDate = startDate;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getMagicYear() {
        return magicYear;
    }

    public void setMagicYear(int magicYear) {
        this.magicYear = magicYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public static int calculateMonthlySalary(int salary){
       return Math.round(salary/12);
    }

    public static int magicYearCalculate(int startYear){
        return startYear+65;
    }

    @Override
    public String toString() {
        return "\n" +
                "Name: " + firstName + " " + lastName +
                "\nMonthly Salary: " + monthlySalary +
                "\nMagic Year: " + magicYear;
    }
}
