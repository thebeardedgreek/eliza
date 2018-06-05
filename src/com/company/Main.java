package com.company;

import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception
    {

        String response = "q";

        String clientFName = "";
        String usersInput1 = "";
        String usersInput2 = "";
        String answers = "";

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello, my name is Eliza.");
        System.out.println(" Can I have your firstname, please ? ");
        clientFName = keyboard.nextLine();


        System.out.println(" How can I help you today  " + clientFName + " ?");
        usersInput1 = keyboard.nextLine();
        System.out.println(" Please tell me more..");
        usersInput2 = keyboard.nextLine();

        System.out.println("Please press 'Q' to quit " );

    }
}


