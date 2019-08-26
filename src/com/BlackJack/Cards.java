package com.BlackJack;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Cards {
    //HEARTS
//    HEARTACE("ACE", "Heart", 1, "\u2661"),
//    HEART2("2", "Heart", 2, "\u2661"),
//    HEART3("3", "Heart", 3, "\u2661"),
//    HEART4("4", "Heart", 4,"\u2661"),
//    HEART5("5", "Heart", 5,"\u2661"),
//    HEART6("6", "Heart", 6,"\u2661"),
//    HEART7("7", "Heart", 7,"\u2661"),
//    HEART8("8", "Heart", 8,"\u2661"),
//    HEART9("9", "Heart", 9,"\u2661"),
//    HEART10("10", "Heart", 10,"\u2661"),
//    HEARTJACK("JACK", "Heart", 10,"\u2661"),
//    HEARTQUEEN("QUEEN", "Heart", 10,"\u2661"),
//    HEARTKING("KING", "Heart", 10,"\u2661"),
//    //DIAMONDS
//    DIAMONDACE("ACE", "Diamond", 1, "\u2662"),
//    DIAMOND2("2", "Diamond", 2, "\u2662"),
//    DIAMOND3("3", "Diamond", 3, "\u2662"),
//    DIAMOND4("4", "Diamond", 4, "\u2662"),
//    DIAMOND5("5", "Diamond", 5, "\u2662"),
//    DIAMOND6("6", "Diamond", 6, "\u2662"),
//    DIAMOND7("7", "Diamond", 7, "\u2662"),
//    DIAMOND8("8", "Diamond", 8, "\u2662"),
//    DIAMOND9("9", "Diamond", 9, "\u2662"),
//    DIAMOND10("10", "Diamond", 10, "\u2662"),
//    DIAMONDJACK("JACK", "Diamond", 10, "\u2662"),
//    DIAMONDQUEEN("QUEEN", "Diamond", 10, "\u2662"),
//    DIAMONDKING("KING", "Diamond", 10, "\u2662"),
//    //SPADE
//    SPADEACE("ACE", "Spade", 1, "\u2660"),
//    SPADE2("2", "Spade", 2, "\u2660"),
//    SPADE3("3", "Spade", 3, "\u2660"),
//    SPADE4("4", "Spade", 4, "\u2660"),
//    SPADE5("5", "Spade", 5, "\u2660"),
//    SPADE6("6", "Spade", 6, "\u2660"),
//    SPADE7("7", "Spade", 7, "\u2660"),
//    SPADE8("8", "Spade", 8, "\u2660"),
//    SPADE9("9", "Spade", 9, "\u2660"),
//    SPADE10("10", "Spade", 10, "\u2660"),
//    SPADEJACK("JACK", "Spade", 10, "\u2660"),
//    SPADEQUEEN("QUEEN", "Spade", 10, "\u2660"),
//    SPADEKING("KING", "Spade", 10, "\u2660"),
//    //CLUBS
//    CLUBACE("ACE", "Club", 1, "\u2663"),
//    CLUB2("2", "Club", 2, "\u2663"),
//    CLUB3("3", "Club", 3, "\u2663"),
//    CLUB4("4", "Club", 4, "\u2663"),
//    CLUB5("5", "Club", 5, "\u2663"),
//    CLUB6("6", "Club", 6, "\u2663"),
//    CLUB7("7", "Club", 7, "\u2663"),
//    CLUB8("8", "Club", 8, "\u2663"),
//    CLUB9("9", "Club", 9, "\u2663"),
//    CLUB10("10", "Club", 10, "\u2663"),
//    CLUBJACK("JACK", "Club", 10, "\u2663"),
//    CLUBQUEEN("QUEEN", "Club", 10, "\u2663"),
//    CLUBKING("KING", "Club", 10, "\u2663"),
    //
    ;

    String card;
    String suit;
    int value;
    String symbol;
    String image;

    public String getCard() {
        return card;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static List<Cards> buildDeck() {
        //DECK IS 52
        List<Cards> deck = new ArrayList<>(52);

        String[][] suites = {{"HEARTS", "\u2661"}, {"SPADES", "\u2660"}, {"CLUBS", "\u2663"}, {"DIAMONDS", "\u2662"}};
        String[] pictures = {"KING", "JACK", "QUEEN"};

        //EACH SUITE IS 13
        for (int i = 0; i <= 3; i++) {
            String suit = suites[i][0];
            String symbol = suites[i][1];

            //10 NUMBERS
            for (int j = 1; j <= 10; j++) {
                String name = Integer.toString(j);
                //ACE VALUE
                    if(j!=1){
                        Cards card = new Cards(name, suit, j, symbol);
                        deck.add(card);
                    }else {
                        Cards card = new Cards("ACE", suit, j, symbol);
                        deck.add(card);
                    }
                    //4 PICTURES
            } for(String c:pictures){
                Cards card = new Cards(c, suit, 10, symbol);
                deck.add(card);
            };
        }
        return deck;
    }

Cards(String card, String suit, int value, String symbol) {
        this.card = card;
        this.suit = suit;
        this.value = value;
        this.symbol = symbol;
    }
}
