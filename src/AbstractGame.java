/*
In your code, there must be an abstract class, called Game. In order to create a new
game variation, ideally, a developer will only need to create a new class that extends
your abstract Game class, and then do necessary implementation of abstract methods in
order to create an Uno Game */

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame {

    //Because you cannot possibly cover all game rules, think of a way that you can allow
    //developers to extend your code and add more game rules to it (or any other features
    //such as new cards or new card dealing mechanisms) with minimal effort.
    List<UnoRule> rules = new ArrayList<>();

    //Inside the Game class, there must be a method called play, which simulates the game.
    //Surely, you can add other methods as well.
    public void play() {

    }
}
