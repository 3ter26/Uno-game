
import controllers.CardsTable;
import enums.UnoRule;
import models.Player;

import java.util.List;
import java.util.Set;

public abstract class Game {

    protected Set<UnoRule> rules;
    protected List<Player> players;
    protected CardsTable tableCards;

    public abstract void play();
    public abstract void dealCards();
}
