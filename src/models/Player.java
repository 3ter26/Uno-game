package models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int totalPoints;
    private List<Card> cardsInHand;


    public Player(String name) {
        this.name = name;
        this.cardsInHand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void addCardToHand(Card card) {
        cardsInHand.add(card);
    }

    public void removeCardFromHand(Card card) {
        cardsInHand.remove(card);
    }

    void playCard(int handIndex) {

    }

    void drawCard() {

    }

}
