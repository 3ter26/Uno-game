import enums.CardType;
import enums.Color;
import models.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CardsDeck {

    private ArrayList<Card> cards;

    public CardsDeck() {
        cards = new ArrayList<>();
        initBasicUnoDeck();
        shuffleCards();
    }


    private void initBasicUnoDeck() {
        for (Color c : Color.values()) {
            cards.add(new Card(c, 0, CardType.NORMAL_CARD_ZERO));

            for (int i = 1; i <= 9; i++) {
                CardType normalType = getCardType(i);
                cards.add(new Card(c, i, normalType));
                cards.add(new Card(c, i, normalType));
            }
            cards.add(new Card(c, -1, CardType.ACTION_CARD_SKIP));
            cards.add(new Card(c, -1, CardType.ACTION_CARD_SKIP));

            cards.add(new Card(c, -1, CardType.ACTION_CARD_REVERSE));
            cards.add(new Card(c, -1, CardType.ACTION_CARD_REVERSE));

            cards.add(new Card(c, -1, CardType.ACTION_CARD_DRAW_TWO));
            cards.add(new Card(c, -1, CardType.ACTION_CARD_DRAW_TWO));

            for (int i = 0; i< 4; i++) {
                cards.add(new Card(c, -1, CardType.WILD_CARD_CHANGE_CURRENT_COLOR));
                cards.add(new Card(c, -1, CardType.WILD_CARD_DRAW_FOUR));
            }
        }
    }

    private CardType getCardType(int index) {
        switch (index) {
            case 0: return CardType.NORMAL_CARD_ZERO;
            case 1: return CardType.NORMAL_CARD_ONE;
            case 2: return CardType.NORMAL_CARD_TWO;
            case 3: return CardType.NORMAL_CARD_THREE;
            case 4: return CardType.NORMAL_CARD_FOUR;
            case 5: return CardType.NORMAL_CARD_FIVE;
            case 6: return CardType.NORMAL_CARD_SIX;
            case 7: return CardType.NORMAL_CARD_SEVEN;
            case 8: return CardType.NORMAL_CARD_EIGHT;
            case 9: return CardType.NORMAL_CARD_NINE;
        }
        return CardType.NORMAL_CARD_ZERO;
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public int getTotalUnoCardsSize() {
        return cards.size();
    }


}
