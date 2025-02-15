package enums;

public enum UnoRuleCategory {
    NUMBER_OF_PLAYERS,
    NUMBER_OF_CARDS,
    CARDS_DEALT,
    PLAYING_FLOW,
    DRAW_CARDS,
    SAYING_UNO,
    PUNISHMENTS,
    POINTS,
    DRAW_CARDS_IS_GATHERED,
    COLOR_RESTRICTION,
    CONTINUE_IF_HAVING,
    PLAY_IF_DRAWN;

    @Override
    public String toString() {
        return switch (this) {
            case NUMBER_OF_PLAYERS -> "Number of players from (2-10)";
            case NUMBER_OF_CARDS -> "Total number of Uno cards";
            case CARDS_DEALT -> "Number of Cards Dealt";
            case PLAYING_FLOW -> "playing Flow";
            case DRAW_CARDS ->
                    "How many cards the player is supposed to draw";
            case POINTS ->
                    "How you want the winning to be?";
            case SAYING_UNO -> "If player must say \"UNO\" on";
            case PUNISHMENTS -> "If there is punishments";
            case PLAY_IF_DRAWN ->
                    "If the player didn't had playable card and he/she drawn, than is he/she allowed to throw?";
            case COLOR_RESTRICTION, CONTINUE_IF_HAVING ->
                    "If the player had a playable card, is he/she's allowed to continue throwing till facing unplayable cards?";
            case DRAW_CARDS_IS_GATHERED ->
                    "If a chain of draw cards are thrown, do you want them to be gathered until un-draw card is thrown?";
        };
    }
}
