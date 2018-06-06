import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception
    {

        String clientFName, usersInput = "";
        HashMap<String, String> hashMapReplacements = new HashMap<>();
        ArrayList<String> response = new ArrayList<String>();
        ArrayList<String> responseHistory = new ArrayList<String>();
        ArrayList<String> questionHistory = new ArrayList<String>();
        String[] hedges = {"Please, tell me more.\n", "Many of my patients tell me the same thing.\n","This is a more common problem than you might think.\n",
                "This is an issue I have helped many patients with.\n","You are not alone in this, I'm here to help.\n"};
        String[] qualifiers = {"Why do you say that ", "I'm curious why you seem to think that ", "So, why are you concerned that ",
                "Explain more about how ", "I'd like to hear more about how ", "Please elaborate on why "};
        String[] inputProcessing;
        hashMapReplacements.put("i" , "you");
        hashMapReplacements.put("i'm" , "you're");
        hashMapReplacements.put("you're", "i'm");
        hashMapReplacements.put("me" , "you");
        hashMapReplacements.put("you" , "I");
        hashMapReplacements.put("my" , "your");
        hashMapReplacements.put("your" , "my");
        hashMapReplacements.put("am" , "are");
        hashMapReplacements.put("are" , "am");
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
                "\nPlease answer with a 'Q' to quit at anytime." );
        usersInput = keyboard.nextLine().toLowerCase();

        while (!usersInput.equals("q")){
            questionHistory.add(usersInput);
            inputProcessing = usersInput.split(" ");
            TimeUnit.SECONDS.sleep(1);

            for (String character : inputProcessing ){
                if (hashMapReplacements.containsKey(character)){
                    character = (String)hashMapReplacements.get(character);
                    response.add(character);
                } else
                    response.add(character);
            }

            if (randomDirection == 0){
                System.out.print(qualifiers[randomChoiceQual]);
                for (String output : response){
                    System.out.print(output + " ");
                    responseHistory.add(output);
                }
            } else if (randomDirection == 1){
                System.out.print(hedges[randomChoiceHedge]);
                System.out.print(qualifiers[randomChoiceQual]);
                for (String output : response){
                    System.out.print(output + " ");
                    responseHistory.add(output);
                }
            }
            responseHistory.add("\n");
            questionHistory.add("\n");
            System.out.print("...\n");
            TimeUnit.SECONDS.sleep(2);
            randomChoiceHedge = rnd.nextInt(hedges.length);
            randomChoiceQual = rnd.nextInt(qualifiers.length);
            randomDirection = rnd.nextInt(2);
            response.clear();
            usersInput = keyboard.nextLine().toLowerCase();
        }

        System.out.print("\nHere is your response history: \n");
        for (String output : questionHistory){
            System.out.print(output + " ");
        }
        System.out.print("\nHere is Eliza's response history: \n");
        for (String output : responseHistory){
            System.out.print(output + " ");
        }
    }
}
