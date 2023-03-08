package com.atmmachine;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class ATM 
{
    public static void main( String[] args ) throws IOException
    {
        OptionMenu optionMenu = new OptionMenu();
        greet();
        optionMenu.mainMenu();
    }

    public static void greet() {
        System.out.println( "Welcome to the ATM Machine developed by Bruno Gumsão | BrunoDev2003");
    }
}
