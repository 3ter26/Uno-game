package enums;

import jdk.jfr.Category;

import java.util.*;
import java.util.stream.Collectors;

import static enums.UnoRuleCategory.*;

public enum UnoRule {
    TWO_PLAYERS(NUMBER_OF_PLAYERS,"2"),
    THREE_PLAYERS(NUMBER_OF_PLAYERS,"3"),
    FOUR_PLAYERS(NUMBER_OF_PLAYERS,"4"),
    FIVE_PLAYERS(NUMBER_OF_PLAYERS,"5"),
    SIX_PLAYERS(NUMBER_OF_PLAYERS,"6"),
    SEVEN_PLAYERS(NUMBER_OF_PLAYERS,"7"),
    EIGHT_PLAYERS(NUMBER_OF_PLAYERS,"8"),
    NINE_PLAYERS(NUMBER_OF_PLAYERS,"9"),
    TEN_PLAYERS(NUMBER_OF_PLAYERS,"10"),

    ONE_ZERO_EIGHT_CARDS(NUMBER_OF_CARDS,"108"),
    TWO_ONE_SIX_CARDS(NUMBER_OF_CARDS,"216"),

    SEVEN_CARDS_DEALT(CARDS_DEALT,"7"),
    FOURTEEN_CARDS_DEALT(CARDS_DEALT,"14"),
    TWENTY_CARDS_DEALT(CARDS_DEALT,"20"),

    LTR_PLAYING_FLOW(PLAYING_FLOW,"LTR"),
    RTL_PLAYING_FLOW(PLAYING_FLOW,"LTR"),
    FROM_MIDDLE_TR_FLOW(PLAYING_FLOW,"MTR"),
    FROM_MIDDLE_TL_FLOW(PLAYING_FLOW,"MTL"),

    SAY_UNO_ON_LAST_TWO_CARDS(SAYING_UNO,"SAY_UNO_ON_LAST_TWO_CARDS"),
    SAY_UNO_ON_LAST_CARD(SAYING_UNO,"SAY_UNO_ON_LAST_CARD"),

    CONTINUE_IF_YOU_HAVE(CONTINUE_IF_HAVING,"CONTINUE_IF_YOU_HAVE"),
    CONTINUE_IF_YOU_HAVE_COUNT_2(CONTINUE_IF_HAVING,"CONTINUE_IF_YOU_HAVE_COUNT_2"),

    DRAW_ONE_CARD_IF_YOU_DONT_HAVE(DRAW_CARDS,"1"),
    DRAW_TWO_CARDS_IF_YOU_DONT_HAVE(DRAW_CARDS,"2"),

    DUPLICATED_DRAW_CARDS_ARE_GATHERED(DRAW_CARDS_IS_GATHERED,"DUPLICATED_DRAW_CARDS_ARE_GATHERED"),
    NO_GATHERING_FOR_DRAW_CARDS(DRAW_CARDS_IS_GATHERED,"NO_GATHERING_FOR_DRAW_CARDS"),

    PLAY_AFTER_DRAWING(PLAY_IF_DRAWN,"PLAY_AFTER_DRAWING"),
    IF_DRAW_THAN_DONT_PLAY(PLAY_IF_DRAWN,"IF_DRAW_THAN_DONT_PLAY"),

    SAME_NUMBER_DIFFERENT_COLOR_ALLOWED(COLOR_RESTRICTION,"SAME_NUMBER_DIFFERENT_COLOR_ALLOWED"),
    ONLY_SAME_COLOR_IS_ALLOWED(COLOR_RESTRICTION,"ONLY_SAME_COLOR_IS_ALLOWED"),

    LOSER_MUST_BE_PUNISHED(PUNISHMENTS,"LOSER_MUST_BE_PUNISHED"),
    NO_PUNISHMENTS(PUNISHMENTS,"NO_PUNISHMENTS"),

    WITH_POINTS(POINTS,"WITH_POINTS"),
    LAST_ONE_IS_WINNER(POINTS,"LAST_ONE_IS_WINNER");

    private final UnoRuleCategory category;
    private final String value;

    UnoRule(UnoRuleCategory category, String value) {
        this.category = category;
        this.value = value;
    }

    public UnoRuleCategory getCategory() {
        return category;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return switch (this) {
            case TWO_PLAYERS -> "2 players";
            case THREE_PLAYERS -> "3 players";
            case FOUR_PLAYERS -> "4 players";
            case FIVE_PLAYERS -> "5 players";
            case SIX_PLAYERS -> "6 players";
            case SEVEN_PLAYERS -> "7 players";
            case EIGHT_PLAYERS -> "8 players";
            case NINE_PLAYERS -> "9 players";
            case TEN_PLAYERS -> "10 players";
            case ONE_ZERO_EIGHT_CARDS -> "108 cards";
            case LTR_PLAYING_FLOW -> "Left to right playing flow";
            case WITH_POINTS -> "The winning is by points";
            case NO_PUNISHMENTS -> "No punishments";
            case RTL_PLAYING_FLOW -> "Right to left playing flow";
            case SEVEN_CARDS_DEALT -> "7 cards dealt";
            case TWO_ONE_SIX_CARDS -> "206 cards";
            case LAST_ONE_IS_WINNER -> "Last one is winner";
            case PLAY_AFTER_DRAWING -> "Player is allowed to throw after drawing";
            case TWENTY_CARDS_DEALT -> "20 cards dealt";
            case FROM_MIDDLE_TL_FLOW -> "Middle to right playing flow";
            case FROM_MIDDLE_TR_FLOW -> "Middle to left playing flow";
            case CONTINUE_IF_YOU_HAVE -> "Continue throwing as long as you have playable cards";
            case FOURTEEN_CARDS_DEALT -> "14 cards dealt";
            case SAY_UNO_ON_LAST_CARD -> "Player should say UNO on last card";
            case IF_DRAW_THAN_DONT_PLAY -> "Player isn't allowed to throw after drawing";
            case LOSER_MUST_BE_PUNISHED -> "Losers must be punished";
            case SAY_UNO_ON_LAST_TWO_CARDS -> "Player should say UNO on last two cards";
            case ONLY_SAME_COLOR_IS_ALLOWED -> "throwing is only allowed if the player is having the same color of the topCardOnDiscardPile";
            case NO_GATHERING_FOR_DRAW_CARDS -> "If multiple throw cards are thrown, than each are separated";
            case CONTINUE_IF_YOU_HAVE_COUNT_2 -> "(2-times only) Continue throwing as long as you have playable cards";
            case DRAW_ONE_CARD_IF_YOU_DONT_HAVE -> "If no playable card, than player should draw one card";
            case DRAW_TWO_CARDS_IF_YOU_DONT_HAVE -> "If no playable card, than player should draw two cards";
            case DUPLICATED_DRAW_CARDS_ARE_GATHERED -> "Duplicated draw cards are gathered";
            case SAME_NUMBER_DIFFERENT_COLOR_ALLOWED -> "Same number different color allowed to be thrown";
            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
    }

    public static List<UnoRule> getRulesByCategory(UnoRuleCategory category) {
        return Arrays.stream(values())
                .filter(rule -> rule.getCategory() == category)
                .collect(Collectors.toList());
    }

    public static Set<UnoRule> getBasicUnoRules() {
        Set<UnoRule> basicUnoRules = new HashSet<>();
         basicUnoRules.add(TWO_PLAYERS);
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




}
