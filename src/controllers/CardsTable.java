package controllers;

import enums.CardType;
import enums.Color;
import models.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsTable {

    private ArrayList<Card> cards;

    public CardsTable() {
        cards = new ArrayList<>();
        initUnoCards();
        shuffleCards();
    }


    private void initUnoCards() {
        for (Color color : Color.values()) {
            cards.add(new Card(color, 0, CardType.NORMAL_CARD_ZERO));

            for (int i = 1; i <= 9; i++) {
                CardType normalType = getCardType(i);
                cards.add(new Card(color, i, normalType));
                cards.add(new Card(color, i, normalType));
            }
            cards.add(new Card(color, -1, CardType.ACTION_CARD_SKIP));
            cards.add(new Card(color, -1, CardType.ACTION_CARD_SKIP));

            cards.add(new Card(color, -1, CardType.ACTION_CARD_REVERSE));
            cards.add(new Card(color, -1, CardType.ACTION_CARD_REVERSE));

            cards.add(new Card(color, -1, CardType.ACTION_CARD_DRAW_TWO));
            cards.add(new Card(color, -1, CardType.ACTION_CARD_DRAW_TWO));

            cards.add(new Card(null, -1, CardType.WILD_CARD_CHANGE_CURRENT_COLOR));
            cards.add(new Card(null, -1, CardType.WILD_CARD_DRAW_FOUR));

        }
        System.out.println("Total uno cards: " + cards.size());
    }

    private CardType getCardType(int index) {
        return switch (index) {
            case 0 -> CardType.NORMAL_CARD_ZERO;
            case 1 -> CardType.NORMAL_CARD_ONE;
            case 2 -> CardType.NORMAL_CARD_TWO;
            case 3 -> CardType.NORMAL_CARD_THREE;
            case 4 -> CardType.NORMAL_CARD_FOUR;
            case 5 -> CardType.NORMAL_CARD_FIVE;
            case 6 -> CardType.NORMAL_CARD_SIX;
            case 7 -> CardType.NORMAL_CARD_SEVEN;
            case 8 -> CardType.NORMAL_CARD_EIGHT;
            case 9 -> CardType.NORMAL_CARD_NINE;
            default -> CardType.NORMAL_CARD_ZERO;
        };
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.removeLast();
        }
        return null;
    }

    public int getTotalUnoCardsSize() {
        return cards.size();
    }

    public List<Card> getRandomSevenCards() {
        List<Card> randomCards = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            randomCards.add(cards.get(i));
        }
        return randomCards;
    }


}
