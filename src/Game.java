/*
In your code, there must be an abstract class, called Game. In order to create a new
game variation, ideally, a developer will only need to create a new class that extends
your abstract Game class, and then do necessary implementation of abstract methods in
order to create an Uno Game */

import controllers.CardsTable;
import enums.UnoRule;
import models.Player;

import java.util.List;
import java.util.Set;

public abstract class Game {

    protected Set<UnoRule> rules;
    protected List<Player> players;
    protected CardsTable tableCards;



    public void exchangeRule(UnoRule oldRule, UnoRule newRule) {
        if (rules.isEmpty()) {
            System.out.println("There are no rules set!!");
            return;
        }
        for (UnoRule rule : rules) {
            if (rule == oldRule) {
                rules.remove(rule);
                rules.add(newRule);
            }
        }
    }


    public List<Player> getPlayers() {
        return players;
    }

    public CardsTable getTableCards() {
        return tableCards;
    }



    public abstract void play();
    public abstract void dealCards();
}
