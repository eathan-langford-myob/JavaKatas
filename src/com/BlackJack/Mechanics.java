package com.BlackJack;

import java.util.*;

public class Mechanics {
    static Scanner userInput = new Scanner(System.in);
static int BLACKJACK = 21;
static int ACETHRESHOLD = 10;

//CHECK WINNER METHOD
    public static boolean checkWinner(Player player, Player dealer) {
        //IF BOTH PLAYERS STAY CONDITIONS:
        if (player.isStaying && dealer.isStaying) {
            if (player.valueOfHand > dealer.valueOfHand) {
                System.out.println("Congratulations! You beat the Dealer!");
                return true;
            } else if (player.valueOfHand == dealer.valueOfHand) {
                System.out.println("Oof! Its a draw!");
                return true;
            } else if (dealer.valueOfHand <= BLACKJACK) {
                System.out.println("Dealer wins.");
                return true;
            }
        } //CONDITIONS FOR WINNING IF PLAYERS ARENT STAYING:
        else {
            if ((player.valueOfHand > BLACKJACK) || (dealer.valueOfHand > BLACKJACK)) {
                System.out.println("Bust!");
                System.exit(0);
                return true;}
 else if ((player.valueOfHand == BLACKJACK || player.cardsHolding.size() == 5) || ((dealer.valueOfHand == BLACKJACK || dealer.cardsHolding.size() == 5))) {
                System.out.println("BlackJack!");
                System.exit(0);
                return true;
            } else if (player.valueOfHand <= 20 || dealer.valueOfHand <= 20) {
                //KEEP LOOPING
                return false;
            }
            }
        return false;
    }

    //PLAYERS TURN:
    public static void playerTurn(Player player, List<Cards> deck){
     switch(player.name.toLowerCase()){
         //DEALERS TURN:
         case ("dealer"):{
                while(player.valueOfHand<17) {
                    hitMe(player, deck);
                    System.out.printf("\n%ss total is %d\n", player.name, player.valueOfHand);
                }
                //DEALER STAYS:
                if (player.valueOfHand<BLACKJACK){
                    player.isStaying = true;
                    System.out.println("The Dealer stayed.");
                    break;
                }
                break;
            }
            //PLAYERS TURN:
            default: {
                    System.out.printf("\n%ss total is %d\nWhat would you like to do?\n", player.name, player.valueOfHand);
                    System.out.println("1.Hit?\n2.Stay?");
                    String response = userInput.nextLine();
                    switch (response) {
                        case ("1"): {
                            hitMe(player, deck);
                            break;
                        }
                        case ("2"): {
                            System.out.printf("%s chose to stay.\n", player.name);
                            player.isStaying = true;
                            break;
                        }
                        default: {
                            System.out.println("Sorry, invalid input! Try again:");
                            break;
                        }
                    }
                }
            }}

            //SWAPS CURRENT PLAYER
    public static Player swapTurns(Player current, Player player, Player dealer){
        Player swapPlayer = current.name.equalsIgnoreCase("dealer") ? player : dealer;
        return swapPlayer;
    }

    public static void firstTurn(Player currentPlayer, Player player, Player dealer, List<Cards> deck){
        hitMe(currentPlayer, deck);
        currentPlayer = swapTurns(currentPlayer, player, dealer);
        hitMe(currentPlayer, deck);
        dealer.isStaying = false;
    }

    public static int countOfAcesInHand(Player user){
        int amountOfAces = 0;
        for (Cards singleCard:user.cardsHolding){
            if(singleCard.card.equalsIgnoreCase("ace")){
                amountOfAces += 1;
            }
        }
        return amountOfAces;
    }

    public static void calculateSingleCard(Player user, Cards card){
        //IF TOTAL WILL PUT OVER BLACKJACK, MAKE ACE A 1
        int handWithNewCard = user.valueOfHand+card.value;
        int acesInhand = countOfAcesInHand(user);

        if (user.valueOfHand<=ACETHRESHOLD) {
            user.valueOfHand += (card.card.equalsIgnoreCase("ace") ? (card.value + ACETHRESHOLD) : (card.value));
        }else if (acesInhand>0 && handWithNewCard>BLACKJACK){
            user.valueOfHand += card.value;
            user.valueOfHand =- ACETHRESHOLD;
        }else{
            user.valueOfHand += card.value;
        }
    }
    public static void hitMe(Player user, List<Cards> deck){
        //TAKE TWO CARDS OFF THE TOP OF DECK AND GIVE TO PLAYER
        //IF PLAYER HAS LESS THAN 2 CARDS, DEAL 2, ELSE DEAL 1.

        Cards cardFromDeck1 = deck.get(0);
        Cards cardFromDeck2 = deck.get(1);

        if(user.cardsHolding.size()<2){
            user.cardsHolding.add(cardFromDeck1);
            calculateSingleCard(user, cardFromDeck1);
            user.cardsHolding.add(cardFromDeck2);
            calculateSingleCard(user, cardFromDeck2);

            System.out.printf("\n%s is dealt 2 cards.", user.name);
            System.out.printf("\n %s got %s%s and %s%s\n", user.name, cardFromDeck1.card,cardFromDeck1.symbol, cardFromDeck2.card,cardFromDeck2.symbol);
            deck.remove(0);
            deck.remove(0);

        }else{
            System.out.printf("%s is dealt 1 card.\n", user.name);
            System.out.printf("\n %s got %s%s\n", user.name, cardFromDeck1.card, cardFromDeck1.symbol);
            calculateSingleCard(user, cardFromDeck1);
            user.cardsHolding.add(cardFromDeck1);
            deck.remove(0);
        }
    }

    public static List<Cards> getDeck() {
        //GET THE CARDS AND CONVERT THEM TO A LIST
        List<Cards> deck = Cards.buildDeck();
        //SHUFFLE THE CARDS
        Collections.shuffle(deck);
        return deck;
    }

    public static String getName(String question) {
        //START LOOP
        boolean valid = false;
        String name = "";
        while (!valid) {
            //ASK
            System.out.println(question);
            //GET NAME
            name = userInput.nextLine();
            //CHECK IF ALL LETTERS
            if (name.chars().allMatch(Character::isLetter)) {
                valid = true;
                return name;
            } else {
                System.out.println("Sorry, invalid input");
            }
        }
        return name;
    }
}
