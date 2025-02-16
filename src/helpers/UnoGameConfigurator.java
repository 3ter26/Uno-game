package helpers;

import enums.UnoRule;
import enums.UnoRuleCategory;
import models.Player;

import java.util.*;

import static enums.UnoRuleCategory.NUMBER_OF_PLAYERS;

public class UnoGameConfigurator {
    private static final Scanner scanner = new Scanner(System.in);

    public static Set<UnoRule> getCustomRules() {
        Set<UnoRule> rules = new HashSet<>();

        System.out.println("Welcome to the Uno Game Engine!\nIf you would like to choose the Basic Uno Game? (enter y) or create your own variation? (enter n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            rules.addAll(UnoRule.getBasicUnoRules());
            return rules;
        }

        for (UnoRuleCategory category : UnoRuleCategory.values()) {
            List<UnoRule> categoryRules = UnoRule.getRulesByCategory(category);
            if (!categoryRules.isEmpty()) {
                System.out.println("Choose " + category.toString() + ": ");
                for (int i = 0; i < categoryRules.size(); i++) {
                    System.out.println((i + 1) + "-) " + categoryRules.get(i).toString());
                }

                int choice = Integer.parseInt(scanner.nextLine()) - 1;
                if (choice >= 0 && choice <= categoryRules.size()) {
                    rules.add(categoryRules.get(choice));
                }
            }
        }
        return rules;
    }

    public static List<Player> getPlayersBasedOn(Set<UnoRule> chosenRules) {
        List<Player> players = new ArrayList<>();
        UnoRule numberOfPlayersRule = chosenRules.stream()
                .filter(rule -> rule.getCategory() == NUMBER_OF_PLAYERS)
                .findFirst().orElse(null);

        if (numberOfPlayersRule == null) {
            System.out.println("No players count rule found! Default is 2 players");
            numberOfPlayersRule = UnoRule.TWO_PLAYERS;
        }

        int numberOfPlayers = Integer.parseInt(numberOfPlayersRule.getValue());
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Enter Player " + i + "'s Name: ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }
        return players;
    }
}
