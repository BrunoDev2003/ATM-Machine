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
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n Checking your current account balance: " + money.format(savingBalance));
                System.out.println("\n Amount to widthdraw from the savings Account");
                double amount = in.nextDouble();
                if((savingBalance - amount) >= 0  && amount >= 0) {
                    calcSavingWithdraw(amount);
                    System.out.println("\n Here is your Current Savings Account Balance: " + money.format(savingBalance));
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

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
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
                    System.out.println("\n Select an account you wish to transfer funds to: ");
                    System.out.println("1. Checkings");
                    System.out.println("2. Exit");
                    System.out.println("\n Choice: ");
                    int option = in.nextInt();
                    switch (option) {
                        case 1: 
                            System.out.println("\n This is your Current Savings Account balance: " + money.format(savingBalance));
                            System.out.println("\n Amount you want to deposit into your savings account: ");
                            double amount = in.nextDouble();
                            if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >=0 && amount >=0) {
                                calcSaveTransfer(amount);
                                end = true;
                            } else {
                                System.out.println("\n Balance can't be negative!");
                            }
                            break;
                        case 2: 
                            return;
                        default:
                            System.out.println("\n Error! Invalid choice.");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Invalid choice");
                in.next();
            }
        }
    }

    private void calcSaveTransfer(double amount) {
        savingBalance = savingBalance - amount;
        checkingBalance = checkingBalance + amount;
    }

    public void getSavingDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n Here are your current Savings Account Balance: " + money.format(savingBalance));
                System.out.println("\n here is the amount you want to deposit into your savings account:");
                double amountSavings = in.nextDouble();

                if ((savingBalance + amountSavings) >= 0 && amountSavings >= 0) {
                    calcSavingWithdraw(amountSavings);
                    System.out.println("\n Current savings account balance: " + money.format(savingBalance));
                    end = true;
                } else {
                    System.out.println("\n Error! Balance cannot be negative!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Error! Input cannot be negative!");
                in.next();
            }
        }
    }

    
    
}
