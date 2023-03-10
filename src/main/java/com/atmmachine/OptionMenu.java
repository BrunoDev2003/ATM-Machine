package com.atmmachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

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

                
                do {
                    Map.Entry key = (Map.Entry) iterator.next();
                    Account account = (Account) key.getValue();
                    if (data.containsKey(cardnumber) && pinnumber == account.getPinNumber());
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
                        System.out.println("\nView your Balance: " + moneyFormat.format(account.getCheckingBalance()));
                        break;
                    case 2:
                        account.CheckingInput();
                        break;
                    case 3:
                        account.getSavingDepositInput();
                        break;
                    case 4:
                        account.Transfer("Your Savings");
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
                        account.Withdraw();
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

    public void createAcc() throws IOException {
        boolean end = false;
        int no = 0;
        while (end) {
            try {
                System.out.println("\nPlease enter your customer number");
                no = menuInput.nextInt();
                Iterator it = (Iterator) data.entrySet().iterator();
                while(it.hasNext()) {
                    Map.Entry key = (Map.Entry) it.next();
                    if (!data.containsKey(no)) {
                        end = true;

                    }
                }
                if (!end) {
                    System.out.println("\nError! This number is already registered!");
                    System.out.println(end);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError! Invalid Choice.");
                menuInput.next();
            }
        }
        System.out.println("\nPlease enter you PIN number account: ");
        int pinnumber = menuInput.nextInt();
        data.put(no, new Account(no,pinnumber, pinnumber));
        System.out.println("\nYour new account has been registered to the system successfuly!");
        System.out.println("\nPlease wait...");
        getLogin();
    }

    public void mainMenu() throws IOException {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n ATM");
                System.out.println("\n Please type 1 for - Login");
                System.out.println(" Please type 2 for - Create Account");
                System.out.println("\nChoice:");
                int choice = menuInput.nextInt();
                switch (choice) {
                    case 1:
                        getLogin();
                        end = true;
                        break;
                    case 2:
                        createAcc();
                        end = true;
                        break;
                    default:
                        System.out.println("\n Please input a valid choice!");
                }

            } catch (InputMismatchException err) {
                System.out.println("\n Please input a valid choice!");
                menuInput.next();
            }
        }
        System.out.println("\n Operation complete, thank you for using our ATM!");
        menuInput.close();
        System.exit(0);
        
    }

    


}
