package enums;

import java.util.ArrayList;
import java.util.List;

public enum UnoRule {
    TWO_PLAYERS,
    THREE_PLAYERS,
    FOUR_PLAYERS,
    FIVE_PLAYERS,
    SIX_PLAYERS,
    SEVEN_PLAYERS,
    EIGHT_PLAYERS,
    NINE_PLAYERS,
    TEN_PLAYERS,

    ONE_ZERO_EIGHT_CARDS,
    TWO_ONE_SIX_CARDS,

    SEVEN_CARDS_DEALT,
    FOURTEEN_CARDS_DEALT,
    TWENTY_CARDS_DEALT,

    LTR_PLAYING_FLOW,
    RTL_PLAYING_FLOW,
    FROM_MIDDLE_TR_FLOW,
    FROM_MIDDLE_TL_FLOW,

    SAY_UNO_ON_LAST_TWO_CARDS,
    SAY_UNO_ON_LAST_CARD,

    CONTINUE_IF_YOU_HAVE,
    CONTINUE_IF_YOU_HAVE_COUNT_2,

    DRAW_ONE_CARD_IF_YOU_DONT_HAVE,
    DRAW_TWO_CARDS_IF_YOU_DONT_HAVE,

    DUPLICATED_DRAW_CARDS_ARE_GATHERED,
    NO_GATHERING_FOR_DRAW_CARDS,

    PLAY_AFTER_DRAWING,
    IF_DRAW_THAN_DONT_PLAY,

    SAME_NUMBER_DIFFERENT_COLOR_ALLOWED,
    ONLY_SAME_COLOR_IS_ALLOWED,

    LOSER_MUST_BE_PUNISHED,
    NO_PUNISHMENTS,

    WITH_POINTS,
    LAST_ONE_IS_WINNER;



    public static List<UnoRule> getBasicUnoRules() {
        List<UnoRule> basicUnoRules = new ArrayList<>();
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
