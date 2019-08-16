package com.ABC;

import java.util.ArrayList;
import java.util.Scanner;


public class ABC {

    public static ArrayList<String[]> buildBlocks(){
        String[] block1={"B","O"};
        String[] block2={"X","K"};
        String[] block3={"D","Q"};
        String[] block4={"C","P"};
        String[] block5={"N","A"};
        String[] block6={"G","T"};
        String[] block7={"R","E"};
        String[] block8={"T","G"};
        String[] block9={"Q","D"};
        String[] block10={"F","S"};
        String[] block11={"J","W"};
        String[] block12={"H","U"};
        String[] block13={"V","I"};
        String[] block14={"A","N"};
        String[] block15={"O","B"};
        String[] block16={"E","R"};
        String[] block17={"F","S"};
        String[] block18={"L","Y"};
        String[] block19={"P","C"};
        String[] block20={"Z","M"};
        ArrayList<String[]> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);
        blocks.add(block6);
        blocks.add(block7);
        blocks.add(block8);
        blocks.add(block9);
        blocks.add(block10);
        blocks.add(block11);
        blocks.add(block12);
        blocks.add(block13);
        blocks.add(block14);
        blocks.add(block15);
        blocks.add(block16);
        blocks.add(block17);
        blocks.add(block18);
        blocks.add(block19);
        blocks.add(block20);

        return blocks;
    }

    public static Boolean validateInput(String userWord){
        boolean valid = userWord.chars().allMatch(Character::isLetter);
        if(!valid){
            System.out.println("Sorry, invalid input");
            return false;
        }else {
            return true;
        }
    }


    public static String getInput() {
        Boolean valid = false;
        System.out.println("Enter your word: ");
        Scanner userInput = new Scanner(System.in);
        String inputResult = userInput.nextLine();
        valid = validateInput(inputResult);
        while(!valid){
            System.out.println("Please re-enter your word:");
            inputResult = userInput.nextLine();
            valid = validateInput(inputResult);
        }
        return inputResult;
//        someString.chars().allMatch(Character::isLetter);
//        do {
//            System.out.println("Enter your word: ");
//            Scanner input = new Scanner(System.in);
//            valid = validateInput(input.toString());
//            if (valid) {
//                return input.toString();
//            } else {
//                System.out.println("Sorry, not a valId word. Try again");
//                valid = false;
//            }
//        } while (!valid);

    }
public static void letterChecker(ArrayList<String[]> blocks, String word){
        String[] charArrayFromBlocks = new String[word.length()];
        String wordToCheck;
    //init string array to place each matched Char
        for (int i = 0; i < word.length(); i++) {
            Character charOfString = word.charAt(i);
            //breakdown the word into indexed chars
            ArrayList<String[]> copyOfBlocks = blocks;
//            Copy of blocks to mutate
            //loop for checking each block
            for (int j = 0; j < blocks.size(); j++) {
//              for (String[] block : blocks) {
                String block1 = copyOfBlocks.get(j)[0];
                String block2 = copyOfBlocks.get(j)[1];
                //if to check each block with the char from the loop
                if (charOfString.toString().equalsIgnoreCase(block1)) {
                    copyOfBlocks.remove(i);
                    //add matchced letter to string array to match later
                    charArrayFromBlocks[i] = charOfString.toString();
                    break;
                } else if (charOfString.toString().equalsIgnoreCase(block2)) {
                    copyOfBlocks.remove(i);
                    charArrayFromBlocks[i] = charOfString.toString();
                    break;
                }
            }
        }
    wordToCheck = arrStringConvert(charArrayFromBlocks);
    if(word.equalsIgnoreCase(wordToCheck)){
        System.out.println("Can build the word: "+ word.toUpperCase());
    }else{
        System.out.println("Sorry, Can't build the word: "+ word.toUpperCase());
    }
        }

public static String arrStringConvert(String[] arr){
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
        strBuilder.append(arr[i]);
    }
    return strBuilder.toString();
}

    public static void main(String[] args) {
        ArrayList<String[]> blockCollection = buildBlocks();
        String word = getInput();
        letterChecker(blockCollection, word);
    }
}
