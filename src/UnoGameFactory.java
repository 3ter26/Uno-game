import enums.UnoRule;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static enums.UnoRule.*;

public class UnoGameFactory {

    public static Game createCustomUnoGame() {
        Set<UnoRule> chosenRules = UnoGameConfigurator.getCustomRules();
        return new CustomUnoGame(chosenRules);
    }
}
