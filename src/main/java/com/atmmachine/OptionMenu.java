package com.atmmachine;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

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
                data.entrySet().iterator();


            } catch (Exception e) {
                
            }
        }

    }
}
