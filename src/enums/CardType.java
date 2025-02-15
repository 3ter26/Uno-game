package enums;

import java.util.ArrayList;
import java.util.List;

public enum CardType {

    NORMAL_CARD_ZERO("0"),
    NORMAL_CARD_ONE("1"),
    NORMAL_CARD_TWO("2"),
    NORMAL_CARD_THREE("3"),
    NORMAL_CARD_FOUR("4"),
    NORMAL_CARD_FIVE("5"),
    NORMAL_CARD_SIX("6"),
    NORMAL_CARD_SEVEN("7"),
    NORMAL_CARD_EIGHT("8"),
    NORMAL_CARD_NINE("9"),

    ACTION_CARD_REVERSE("ACTION_CARD_REVERSE"),
    ACTION_CARD_SKIP("ACTION_CARD_SKIP"),
    ACTION_CARD_DRAW_TWO("2"),

    WILD_CARD_DRAW_FOUR("4"),
    WILD_CARD_CHANGE_CURRENT_COLOR("WILD_CARD_CHANGE_CURRENT_COLOR");
    private final String value;

    CardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public List<CardType> getDefaultActionCards() {
        List<CardType> actionCards = new ArrayList<>();
        actionCards.add(ACTION_CARD_SKIP);
        actionCards.add(ACTION_CARD_REVERSE);
        actionCards.add(ACTION_CARD_DRAW_TWO);

        return actionCards;
    }
}
