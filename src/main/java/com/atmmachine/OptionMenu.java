package com.atmmachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class OptionMenu {
    Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Account> data = new HashMap<Integer, Account>();

    public void getLogin() {
        int cardnumber = 0;
        int pinnumber = 0;
        boolean auth = false;

        while(!auth) {
            try {
                System.out.println("\n Enter your card number: ");
                cardnumber = menuInput.nextInt();
                System.out.println("\n Enter your PIN: ");
                pinnumber = menuInput.nextInt();
                java.util.Iterator<Entry<Integer, Account>> iterator = data.entrySet().iterator();

                //TODO:Fix this bug.
                do {
                    Map.Entry key = (Map.Entry) iterator.next();
                    Account account = (Account) key.getValue();
                    if (data.containsKey(cardnumber) && pinnumber == getAccountType(account));
                    break;

                } while (iterator.hasNext());

            }
            catch (Exception e) {
                System.out.println("\n Invalid Character(s). Please only add numbers.");
            } finally {
                auth = false;
            }
        }

    }
    
    public void getAccountType(Account account) {
        boolean option = false;
        while(!option) {
            try {
                System.out.println("\nPlease choose your account type.");
                System.out.println(" - Checkings Account");
                System.out.println(" - Savings Account");
                System.out.println(" - Exit");
                System.out.println("\nSelect: ");

                int selection = menuInput.nextInt();

                    switch (selection) {
                        case 1:
                            getCheckingAccountType(account);
                            break;
                        case 2:
                            getSavingsAccountType(account);
                            break;
                        case 3:
                            option = true;
                            break;

                        default:
                            System.out.println("Invalid Input.");

                    }
                
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input.");
                    menuInput.next();
                }

            }
        }
        
    private void getSavingsAccountType(Account account) {
        boolean option = false;
        while (!option) {
            try {
                System.out.println("Savings Account");
                System.out.println("Type 1 - View Balance");
                System.out.println("Type 2 - Widthdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Exit");
				System.out.print("Choice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nView your Balance: " + moneyFormat.format(account.getBalance()));
                        break;
                    case 2:
                        account.getSavingWithdrawInput();
                        break;
                    case 3:
                        account.getSavingDepositInput();
                        break;
                    case 4:
                        account.getTransferWithdrawInput("Your Savings");
                        break;
                    case 5:
                        option = true;
                        break;
                    default:
                        System.out.println("\nPlease input a apropriate choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease input a apropriate choice.");
                menuInput.next();
            }
        }

    }
    private void getCheckingAccountType(Account account) {
        boolean option = false;
        while (!option) {
            try {
                System.out.println("\n View your Checkings Account: ");
                System.out.println(" Type 1 - View Balance");
				System.out.println(" Type 2 - Withdraw Funds");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Exit");
				System.out.print("\nChoice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nAccount Balance: " + moneyFormat.getDecimalFormatSymbols());
                        break;
                    case 2:
                        account.Withdraw();
                        break;
                    case 3:
                        account.CheckingInput();
                        break;
                    case 4:
                        account.Transfer(null);
                        break;
                    case 5:
                        option = true;
                        break;
                    default:
                        System.out.println("\nInvalid input" + selection);
                        
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input"); 
                menuInput.next();
            }
        }

    }
    //TODO: Implement this method;
    public void getSaving(Account account) {
        boolean option = false;
        while(!option) {
            try {

                System.out.println("\n View your Savings Account: ");
                System.out.println(" Type 1 - View Balance");
				System.out.println(" Type 2 - Withdraw Funds");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Exit");
				System.out.print("\nChoice: ");

                int selection = menuInput.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("\n Here is your Savings Account Balance: " + moneyFormat.getDecimalFormatSymbols());
                        break;
                    case 2:
                        account.getSavingWithdrawInput();
                        break;
                    case 3:
                        account.getSavingDepositInput();
                        break;
                    case 4:
                        account.Transfer("Savings");
                        break;
                    case 5:
                        option = true;
                        break;
                    default:
                        System.out.println("\n Incorrect Input data.");
                }

            } catch (NumberFormatException e) {
                System.out.println("\n Incorrect Input data.");
                menuInput.nextInt();
            }
        }
    }

    //TODO: Implement method.
    public void createAcc() throws IOException {
        
    }


}
