import enums.UnoRule;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static enums.UnoRule.*;

public class UnoGameFactory {

    public static Game createCustomUnoGame() {
        Scanner scanner = new Scanner(System.in);
        Set<UnoRule> chosenRules = new HashSet<>();

        System.out.println("Welcome to the Uno Game Engine!\nWould you like to choose the Basic Uno Game? (y) or customize your own variation? (n)");
        String customChoice = scanner.nextLine();
        if (customChoice.equals("y")) {
            chosenRules.addAll(UnoRule.getBasicUnoRules());
            return new CustomUnoGame(chosenRules);
        } else {

            System.out.println("Select number of players from (2-9 players)");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "2" -> chosenRules.add(TWO_PLAYERS);
                case "3" -> chosenRules.add(THREE_PLAYERS);
                case "4" -> chosenRules.add(FOUR_PLAYERS);
                case "5" -> chosenRules.add(FIVE_PLAYERS);
                case "6" -> chosenRules.add(SIX_PLAYERS);
                case "7" -> chosenRules.add(SEVEN_PLAYERS);
                case "8" -> chosenRules.add(EIGHT_PLAYERS);
            }

            System.out.println("Select Total number of cards on discardPile:\n A) 108\n B) 216");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "108" -> chosenRules.add(ONE_ZERO_EIGHT_CARDS);
                case "216" -> chosenRules.add(TWO_ONE_SIX_CARDS);
            }

            System.out.println("Choose Number of Cards Dealt: \n A) 7\n B) 14\n C) 20");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "7" -> chosenRules.add(SEVEN_CARDS_DEALT);
                case "14" -> chosenRules.add(FOURTEEN_CARDS_DEALT);
                case "20" -> chosenRules.add(TWENTY_CARDS_DEALT);
            }

            System.out.println("Choose playing Flow:\n A) LTR\n B) RTL\n C) MTR (Middle To Right)\n D) MTL (Middle To Left)");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case ("LTR") -> chosenRules.add(LTR_PLAYING_FLOW);
                case ("RTL") -> chosenRules.add(RTL_PLAYING_FLOW);
                case ("MTR") -> chosenRules.add(FROM_MIDDLE_TR_FLOW);
                case ("MTL") -> chosenRules.add(FROM_MIDDLE_TL_FLOW);
            }

            System.out.println("Player must say \"UNO\" on (a/b): \n A) Last Card only.\n B) Last two Cards.");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "a" -> chosenRules.add(SAY_UNO_ON_LAST_CARD);
                case "b" -> chosenRules.add(SAY_UNO_ON_LAST_TWO_CARDS);
            }

            System.out.println("When is the player supposed to say UNO? (a/b)\n A) On last card ONLY?\n B) On last two cards?");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "a" -> chosenRules.add(SAY_UNO_ON_LAST_CARD);
                case "b" -> chosenRules.add(SAY_UNO_ON_LAST_TWO_CARDS);
            }

            System.out.println("If the player had a playable card, is he/she's allowed to continue throwing till facing unplayable cards? (a/b)\n A) Yes, he/she keep throwing until doesn't having a playable card\n B) Yes, but only for two times - as well as having an applicable card, he/she is allowed to play");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "a" -> chosenRules.add(CONTINUE_IF_YOU_HAVE);
                case "b" -> chosenRules.add(CONTINUE_IF_YOU_HAVE_COUNT_2);
            }

            System.out.println("How many cards is supposed the player to draw, if he/she isn't having a playable card?\n A) 1 card to draw\n B) 2 card to draw");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "1" -> chosenRules.add(DRAW_ONE_CARD_IF_YOU_DONT_HAVE);
                case "2" -> chosenRules.add(DRAW_TWO_CARDS_IF_YOU_DONT_HAVE);
            }

            System.out.println("If the player didn't had playable card and he/she drawn, than is he/she allowed to throw? or no? (y/n)\n");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "y" -> chosenRules.add(PLAY_AFTER_DRAWING);
                case "n" -> chosenRules.add(IF_DRAW_THAN_DONT_PLAY);
            }

            System.out.println("If a chain of draw cards are thrown, do you want them to be gathered until un-draw card is thrown? (y/n)\n");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "y" -> chosenRules.add(DUPLICATED_DRAW_CARDS_ARE_GATHERED);
                case "n" -> chosenRules.add(NO_GATHERING_FOR_DRAW_CARDS);
            }

            System.out.println("Do you want the game to be strict, so that only the cards with same colors are allowed to be played? (y/n)\n");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "y" -> chosenRules.add(SAME_NUMBER_DIFFERENT_COLOR_ALLOWED);
                case "n" -> chosenRules.add(ONLY_SAME_COLOR_IS_ALLOWED);
            }

            System.out.println("Is there punishments for the loser? or no? (y/n)\n");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "y" -> chosenRules.add(LOSER_MUST_BE_PUNISHED);
                case "n" -> chosenRules.add(NO_PUNISHMENTS);
            }

            System.out.println("How you want the winning to be? by points? or last one is a winner?\n A) By Points? (a/b)\n B) Last player is the winner");
            customChoice = scanner.nextLine();
            switch (customChoice) {
                case "a" -> chosenRules.add(WITH_POINTS);
                case "b" -> chosenRules.add(LAST_ONE_IS_WINNER);
            }

        }

        return new CustomUnoGame(chosenRules);
    }
}
