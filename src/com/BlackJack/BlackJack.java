package com.BlackJack;
/*
It will be entirely text based.
It will have just a single player and the dealer.
It will have no gambling system.

DEAL
get random cards, or shuffle
2 dealt cards from a single deck

ASK
stay or hit, keep asking until they stay

CHECK ACE
if under 21, treat as 11, else treat as 1.

DEALER
needs to get to 17, if they get above 17 without busting then stay

RULES
If the player has blackjack, they win, unless the dealer also has blackjack, in which case the game is a tie.
If the dealer busts and the player doesn't, the player wins.
If the player busts, the dealer wins.
If the player and the dealer both don't bust, whoever is closest to 21 wins.

EXAMPLE
You are at currently at 15
with the hand [['ACE', 'HEART '], [4, 'HEART '], ['QUEEN', 'SPADE']]
*/

import java.util.*;

import static com.BlackJack.Mechanics.*;

public class BlackJack {

    public static void main(String[] args) {
        System.out.println("WELCOME TO BLACKJACK!");
        String name = getName("Please enter your name: ");
        Player player = new Player(name);
        Player dealer = new Player("Dealer");

        System.out.printf("Thank you %s!\n", player.name);
        System.out.println("Dealer shuffles the deck.");

        List<Cards> deck = getDeck();
//        for (Cards c:deck
//             ) {
//            System.out.printf("name: %s, value: %d, suit: %s, \n", c.card, c.value, c.symbol);
//        }
        Player currentPlayer = player;
        boolean hit = true;
//
//        hitMe(player, deck);
//        currentPlayer = swapTurns(currentPlayer, player, dealer);
//        hitMe(player, deck);

        firstTurn(currentPlayer, player, dealer, deck);
        boolean winner = checkWinner(player, dealer);
        gameloop: while(!winner){
            turnloop: while(!currentPlayer.isStaying) {
                hit = checkWinner(player, dealer);
                if(!hit){playerTurn(currentPlayer, deck);}
            }
            currentPlayer=swapTurns(currentPlayer, player, dealer);
            winner = checkWinner(player, dealer);
        }

    }
}
