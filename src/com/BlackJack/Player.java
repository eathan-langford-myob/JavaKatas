package com.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    List<Cards> cardsHolding;
    int valueOfHand;
    boolean isStaying;


    public Player(String name) {
        this.name = name;
        this.valueOfHand = 0;
        this.cardsHolding = new ArrayList<>();
        this.isStaying = false;
    }

    public List<Cards> getCardsHolding() {
        return cardsHolding;
    }

    public void setCardsHolding(List<Cards> cardsHolding) {
        this.cardsHolding = cardsHolding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValueTotal() {
        return valueOfHand;
    }

    public void setValueTotal(int valueOfHand) {
        this.valueOfHand = valueOfHand;
    }
}


