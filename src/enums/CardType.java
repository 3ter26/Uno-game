package enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CardType {

    NORMAL_CARD,

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
