package com.company;

import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Main {

    static Boolean isPig = false, isRed = false, isCaps = false, playGame = false;

    public static void main(String[] args) throws Exception {

        String clientFName, userInput, elizaAnswer = "";
        HashMap<String, String> hashMapReplacements = new HashMap<>();
        ArrayList<String> response = new ArrayList<String>();
        ArrayList<String> responseHistory = new ArrayList<String>();
        ArrayList<String> questionHistory = new ArrayList<String>();
        String[] hedges = {"Please, tell me more.\n", "Many of my patients tell me the same thing.\n", "This is a more common problem than you might think.\n",
                "This is an issue I have helped many patients with.\n", "You are not alone in this, I'm here to help.\n"};
        String[] qualifiers = {"Why do you say that ", "I'm curious why you seem to think that ", "So, why are you concerned that ",
                "Explain more about how ", "I'd like to hear more about how ", "Please elaborate on why "};
        String[] inputProcessing;
        hashMapReplacements.put("i", "you");
        hashMapReplacements.put("i'm", "you're");
        hashMapReplacements.put("you're", "i'm");
        hashMapReplacements.put("me", "you");
        hashMapReplacements.put("you", "I");
        hashMapReplacements.put("my", "your");
        hashMapReplacements.put("your", "my");
        hashMapReplacements.put("am", "are");
        hashMapReplacements.put("are", "am");
        Scanner keyboard = new Scanner(System.in);
        Random rnd = new Random();
        int randomChoiceHedge = rnd.nextInt(hedges.length);
        int randomChoiceQual = rnd.nextInt(qualifiers.length);
        int randomDirection = rnd.nextInt(1);

        System.out.println("Hello, my name is Eliza.\n\nI am an AI therapist program, created to help you feel better.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\nWhat is your name?");
        clientFName = keyboard.nextLine();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Alright " + clientFName + ", so how can I help you today?" +
                "\nPlease answer with a 'Q' to quit at anytime.");
        userInput = keyboard.nextLine().toLowerCase().replaceAll("[^a-zA-Z ]", "");

        //while they haven't quit
        while (!userInput.equals("q")) {
            checkForEggs(userInput);
            questionHistory.add(userInput);
            inputProcessing = userInput.split(" ");
            TimeUnit.SECONDS.sleep(1);

            //check for replacement strings
            for (String character : inputProcessing) {
                if (hashMapReplacements.containsKey(character)) {
                    character = (String) hashMapReplacements.get(character);
                    response.add(character);
                } else
                    response.add(character);
            }

            if (randomDirection == 0) {
                elizaAnswer = qualifiers[randomChoiceQual];
                System.out.print(elizaAnswer);
                printResponse(response, responseHistory);
            } else if (randomDirection == 1) {
                    elizaAnswer = hedges[randomChoiceHedge] + "\n" + qualifiers[randomChoiceQual];
                    System.out.print(elizaAnswer);
                printResponse(response, responseHistory);
            }
                responseHistory.add("\n");
                questionHistory.add("\n");
                System.out.print("...\n");
                TimeUnit.SECONDS.sleep(2);
                randomChoiceHedge = rnd.nextInt(hedges.length);
                randomChoiceQual = rnd.nextInt(qualifiers.length);
                randomDirection = rnd.nextInt(2);
                response.clear();
                userInput = keyboard.nextLine().toLowerCase();
            }

        System.out.print("\nHere is your response history: \n");
        for (String output : questionHistory) {
            System.out.print(output + " ");
        }
        System.out.print("\nHere is Eliza's response history:");
        for (String output : responseHistory) {
            System.out.print(output + " ");
        }
    }

    private static void printResponse(ArrayList<String> response, ArrayList<String> responseHistory) {
        if (isPig) {
            for (String word : response) {
                responseHistory.add(pigLatin(word));
                System.out.print(pigLatin(word) + " ");
                }
            }

        if (isCaps){
            for (String word : response){
                responseHistory.add(allCaps(word));
                System.out.print(allCaps(word) + " ");
                }
            }

        if (isRed){
            for (String word : response){
                responseHistory.add(redText(word));
                System.out.print(redText(word) + " ");
            }
        }

        if(!isRed && !isCaps && !isPig){
            for (String word : response) {
                System.out.print(word + " ");
            }
        }
    }

    public static String pigLatin(String userInput) {
        return userInput.substring(1) + userInput.substring(0, 1) + "ay";
    }

    public static String allCaps(String userInput){
        return userInput.toUpperCase();
    }

    public static String redText(String userInput) {
        String beforeColor= userInput;
        String startColor = "\033[31;1m";
        String endColor = "\033[0m";
        return startColor.concat(beforeColor.toString()).concat(endColor);
    }

    public static void checkForEggs(String userInput){
        if (userInput.equals("pig")) {
            isPig = !isPig;
        } else if (userInput.equals("caps")) {
            isCaps = !isCaps;
        } else if (userInput.equals("red")) {
            isRed = !isRed;
        }
    }
}
