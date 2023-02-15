package com.atmmachine;

import java.text.DecimalFormat;
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

    public void Withdraw() {
    }

    public void CheckingInput() {
    }

    public void Transfer(String string) {
    }

    public void getSavingDepositInput() {
    }

    public void getTransferWithdrawInput(String string) {
    }
    
}
