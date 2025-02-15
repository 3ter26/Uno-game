import enums.UnoRule;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnoGameFactory {

    public static Game createCustomUnoGame() {
        Scanner scanner = new Scanner(System.in);
        Set<UnoRule> chosenRules = new HashSet<>();

        System.out.println("Welcome to the Uno Game Engine!\nWould you like to choose the Basic Uno Game? (Y) or customize your own variation? (N)");
        String customChoice = scanner.nextLine();
        if (customChoice.equals( "Y")) {
            chosenRules.addAll(UnoRule.getBasicUnoRules());
            return new CustomUnoGame(chosenRules);
        } else {
            System.out.println("Choose Number of Cards Dealt: \n A) 14.\n B) 20.");
            customChoice = scanner.nextLine();
            if (customChoice.equals("A"))
              chosenRules.add(UnoRule.FOURTEEN_CARDS_DEALT);
            else if (customChoice.equals("B"))
              chosenRules.add(UnoRule.TWENTY_CARDS_DEALT);

            System.out.println("Choose playing Flow:\n A) LTR\n B) RTL");
            customChoice = scanner.nextLine();
            if (customChoice.equals("A"))
              chosenRules.add(UnoRule.LTR_PLAYING_FLOW);
            else
              chosenRules.add(UnoRule.RTL_PLAYING_FLOW);

            System.out.println("Player must say \"UNO\" on: \n A) Last Card only.\n B) Last two Cards.");
            customChoice = scanner.nextLine();
            if (customChoice.equals("A"))
                chosenRules.add(UnoRule.SAY_UNO_ON_LAST_CARD);
            else
                chosenRules.add(UnoRule.SAY_UNO_ON_LAST_TWO_CARDS);

        }

        return new CustomUnoGame(chosenRules);
    }
}
