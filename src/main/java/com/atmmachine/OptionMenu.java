package com.atmmachine;

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
    //TODO:Make the functions below next.
    private void getSavingsAccountType(Account account) {
    }
    private void getCheckingAccountType(Account account) {
    }
}
