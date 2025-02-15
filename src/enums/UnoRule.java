package enums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum UnoRule {
    TWO_PLAYERS("2"),
    THREE_PLAYERS("3"),
    FOUR_PLAYERS("4"),
    FIVE_PLAYERS("5"),
    SIX_PLAYERS("6"),
    SEVEN_PLAYERS("7"),
    EIGHT_PLAYERS("8"),
    NINE_PLAYERS("9"),
    TEN_PLAYERS("10"),

    ONE_ZERO_EIGHT_CARDS("108"),
    TWO_ONE_SIX_CARDS("216"),

    SEVEN_CARDS_DEALT("7"),
    FOURTEEN_CARDS_DEALT("14"),
    TWENTY_CARDS_DEALT("20"),

    LTR_PLAYING_FLOW("LTR"),
    RTL_PLAYING_FLOW("LTR"),
    FROM_MIDDLE_TR_FLOW("MTR"),
    FROM_MIDDLE_TL_FLOW("MTL"),

    SAY_UNO_ON_LAST_TWO_CARDS("SAY_UNO_ON_LAST_TWO_CARDS"),
    SAY_UNO_ON_LAST_CARD("SAY_UNO_ON_LAST_CARD"),

    CONTINUE_IF_YOU_HAVE("CONTINUE_IF_YOU_HAVE"),
    CONTINUE_IF_YOU_HAVE_COUNT_2("CONTINUE_IF_YOU_HAVE_COUNT_2"),

    DRAW_ONE_CARD_IF_YOU_DONT_HAVE("1"),
    DRAW_TWO_CARDS_IF_YOU_DONT_HAVE("2"),

    DUPLICATED_DRAW_CARDS_ARE_GATHERED("DUPLICATED_DRAW_CARDS_ARE_GATHERED"),
    NO_GATHERING_FOR_DRAW_CARDS("NO_GATHERING_FOR_DRAW_CARDS"),

    PLAY_AFTER_DRAWING("PLAY_AFTER_DRAWING"),
    IF_DRAW_THAN_DONT_PLAY("IF_DRAW_THAN_DONT_PLAY"),

    SAME_NUMBER_DIFFERENT_COLOR_ALLOWED("SAME_NUMBER_DIFFERENT_COLOR_ALLOWED"),
    ONLY_SAME_COLOR_IS_ALLOWED("ONLY_SAME_COLOR_IS_ALLOWED"),

    LOSER_MUST_BE_PUNISHED("LOSER_MUST_BE_PUNISHED"),
    NO_PUNISHMENTS("NO_PUNISHMENTS"),

    WITH_POINTS("WITH_POINTS"),
    LAST_ONE_IS_WINNER("LAST_ONE_IS_WINNER");

    private final String value;

    UnoRule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



    public static Set<UnoRule> getBasicUnoRules() {
        Set<UnoRule> basicUnoRules = new HashSet<>();
         basicUnoRules.add(ONE_ZERO_EIGHT_CARDS);
         basicUnoRules.add(SEVEN_CARDS_DEALT);
         basicUnoRules.add(LTR_PLAYING_FLOW);
         basicUnoRules.add(SAY_UNO_ON_LAST_TWO_CARDS);
         basicUnoRules.add(CONTINUE_IF_YOU_HAVE);
         basicUnoRules.add(DRAW_ONE_CARD_IF_YOU_DONT_HAVE);
         basicUnoRules.add(DUPLICATED_DRAW_CARDS_ARE_GATHERED);
         basicUnoRules.add(PLAY_AFTER_DRAWING);
         basicUnoRules.add(SAME_NUMBER_DIFFERENT_COLOR_ALLOWED);
         basicUnoRules.add(LOSER_MUST_BE_PUNISHED);
         basicUnoRules.add(WITH_POINTS);
        return basicUnoRules;
    }

    public static int getCardsDealtChosenRule(Set<UnoRule> activeRules) {
        List<UnoRule> cardsDealtRules = new ArrayList<>();
        cardsDealtRules.add(SEVEN_CARDS_DEALT);
        cardsDealtRules.add(FOURTEEN_CARDS_DEALT);
        cardsDealtRules.add(TWENTY_CARDS_DEALT);
        for (UnoRule rule : cardsDealtRules) {
            if (cardsDealtRules.contains(rule)) {
                return Integer.parseInt(rule.value);
            }
        }
        return 7;
    }

    public static int getDrawCardsChosenRule(Set<UnoRule> activeRules) {
        List<UnoRule> cardsToDrawRules = new ArrayList<>();
        cardsToDrawRules.add(DRAW_ONE_CARD_IF_YOU_DONT_HAVE);
        cardsToDrawRules.add(DRAW_TWO_CARDS_IF_YOU_DONT_HAVE);
        for (UnoRule rule : cardsToDrawRules) {
            if (cardsToDrawRules.contains(rule)) {
                return Integer.parseInt(rule.value);
            }
        }
        return 7;
    }




}
