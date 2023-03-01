package com.atmmachine;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
	private double savingBalance = 0;

    Scanner in = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");

    public Account(int no, int pinnumber, int customerNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinnumber;
    }

    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    public void getSavingWithdrawInput() {
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public DecimalFormat getMoney() {
        return money;
    }

    public void setMoney(DecimalFormat money) {
        this.money = money;
    }

    public void Withdraw() {
    }

    public void CheckingInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n Checking your current account balance: " + money.format(checkingBalance));
                System.out.println("\n Amount to widthdraw from the Checkings Account");
                double amount = in.nextDouble();
                if((checkingBalance - amount) >= 0  && amount >= 0) {
                    calcCheckingWithdraw(amount);
                    System.out.println("\n Here is your Current Checkings Account Balance: " + money.format(checkingBalance));
                    end = true;
                } else {
                    System.out.println("\n Balance is negative!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                in.next();
            }
        }
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public void Transfer(String accString) {
        boolean end = false;
        while (!end) {
            try {
                if(accString.equals("Checkings")) {
                    System.out.println("\nPlease select the account you wish to transfer funds to: ");
                    System.out.println("1. Savings");
                    System.out.println("2. Exit");
                    System.out.println("\nYour Choice: ");
                    int choice = in.nextInt();
                    switch(choice) {
                        case 1:
                            System.out.println("\n Current Checkings Account Balance: " + money.format(accString));
                            System.out.print("Amount you want to deposit into your savings account");
                            double amount = in.nextDouble();
                            if((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                                calcSaveTransfer(amount);
                                System.out.println("\n Current Savings Account: " + money.format(savingBalance));
                                System.out.println("\n Current Checkings Account:  " + money.format(checkingBalance));
                                end = true;
                                
                            } else {
                                System.out.println("\n Error! Balance Cannot Be Negative");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Input.");
                            break;
                    }
                } else if (accString.equals("Savings")) {
                    System.out.println("\n Select a account that you wish to transfer funds to: ");
                    System.out.println("1. Checking");
                    System.out.println("2. Exit");
                    System.out.println("\nChoice: ");
                    int choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("\n Checkings Account: " + money.format(savingBalance));
                            System.out.println("\n Amount you wish to deposit into the savings account: ");
                            double amount = in.nextDouble();
                            if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                                calcSaveTransfer(amount);
                                System.out.println("\n Current checkings account: " + money.format(checkingBalance));
                                System.out.println("\n Current savings account: " + money.format(savingBalance));
                                end = true;

                            } else {
                                System.out.println("\n Invalid input, Balance is negative.");
                            }
                            break;
                    }
                }
            } catch (InputMismatchException e) {

            }
        }
    }

    private void calcSaveTransfer(double amount) {
    }

    public void getSavingDepositInput() {
    }

    public void getTransferWithdrawInput(String string) {
    }
    
}
