package models;

import enums.CardType;

public class Card {
    String color;
    int number;
    CardType cardType;

    boolean ifWildCard = false;
    boolean ifActionCard = false;

    public Card(String color, int number, CardType cardType) {
        this.color = color;
        this.number = number;
        this.cardType = cardType;
    }
}
