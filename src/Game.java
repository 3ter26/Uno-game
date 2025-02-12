/*
In your code, there must be an abstract class, called Game. In order to create a new
game variation, ideally, a developer will only need to create a new class that extends
your abstract Game class, and then do necessary implementation of abstract methods in
order to create an Uno Game */

import enums.UnoRule;
import models.Card;
import models.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    protected List<UnoRule> rules;
    protected List<Player> players;
    protected CardsDeck cardsDeck;



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

    public CardsDeck getCardsDeck() {
        return cardsDeck;
    }



    public abstract void play();
}
