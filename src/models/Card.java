package models;

import enums.CardType;
import enums.Color;

public class Card {
    private Color color;
    private int number;
    private CardType cardType;

    boolean ifWildCard;
    boolean ifActionCard;

    public Card(Color color, int number, CardType cardType) {
        this.color = color;
        this.number = number;
        this.cardType = cardType;

        if (cardType == CardType.WILD_CARD_DRAW_FOUR ||
            cardType == CardType.WILD_CARD_CHANGE_CURRENT_COLOR){
            this.ifWildCard = true;
            this.ifActionCard = false;
        } else if (cardType == CardType.ACTION_CARD_REVERSE ||
                   cardType == CardType.ACTION_CARD_SKIP ||
                   cardType == CardType.ACTION_CARD_DRAW_TWO) {
            this.ifWildCard = false;
            this.ifActionCard = true;
        } else {
            this.ifWildCard = false;
            this.ifActionCard = false;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public boolean isIfWildCard() {
        return ifWildCard;
    }

    public void setIfWildCard(boolean ifWildCard) {
        this.ifWildCard = ifWildCard;
    }

    public boolean isIfActionCard() {
        return ifActionCard;
    }

    public void setIfActionCard(boolean ifActionCard) {
        this.ifActionCard = ifActionCard;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color='" + color + '\'' +
                ", number=" + number +
                ", cardType=" + cardType +
                ", ifWildCard=" + ifWildCard +
                ", ifActionCard=" + ifActionCard +
                '}';
    }
}
