package models;
import controllers.CardsTable;
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

    public Card playCard(int handIndex) {
       if (handIndex >= 0 && handIndex < cardsInHand.size()) {
           return cardsInHand.remove(handIndex);
       }
       return null;
    }

    public void drawCard(CardsTable deck, int numOfCardsToDraw) {
        for (int i = 0; i < numOfCardsToDraw; i++) {
            Card drawn = deck.drawCard();
            if (drawn != null) {
                cardsInHand.add(drawn);
            } else {
                System.out.println("No more cards in deck (I can throw error here or annonucement or smthing");
                break;
            }
        }
    }

    public void sayUNO() {
        System.out.println(name + " is saying: UNO!");
    }



}
