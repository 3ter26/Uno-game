import enums.UnoRule;
import helpers.UnoGameConfigurator;

import java.util.Set;

public class UnoGameFactory {
    public static Game createCustomUnoGame() {
        Set<UnoRule> chosenRules = UnoGameConfigurator.getCustomRules();
        return new CustomUnoGame(chosenRules);
    }
}
