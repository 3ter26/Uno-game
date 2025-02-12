package enums;

import java.util.ArrayList;
import java.util.List;

public enum CardType {

    NORMAL_CARD_ZERO,
    NORMAL_CARD_ONE,
    NORMAL_CARD_TWO,
    NORMAL_CARD_THREE,
    NORMAL_CARD_FOUR,
    NORMAL_CARD_FIVE,
    NORMAL_CARD_SIX,
    NORMAL_CARD_SEVEN,
    NORMAL_CARD_EIGHT,
    NORMAL_CARD_NINE,

    ACTION_CARD_REVERSE,
    ACTION_CARD_SKIP,
    ACTION_CARD_DRAW_TWO,

    WILD_CARD_DRAW_FOUR,
    WILD_CARD_CHANGE_CURRENT_COLOR;

    public List<CardType> getDefaultActionCards() {
        List<CardType> actionCards = new ArrayList<>();
        actionCards.add(ACTION_CARD_SKIP);
        actionCards.add(ACTION_CARD_REVERSE);
        actionCards.add(ACTION_CARD_DRAW_TWO);

        return actionCards;
    }
}
