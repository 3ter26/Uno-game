/*
In your code, there must be an abstract class, called Game. In order to create a new
game variation, ideally, a developer will only need to create a new class that extends
your abstract Game class, and then do necessary implementation of abstract methods in
order to create an Uno Game */

import enums.UnoRule;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame {

    List<UnoRule> rules = new ArrayList<>();
    int totalCards = 108;
    int totalPlayers = 2;
    String playersOrderFlow = "LTR";
    boolean withPunishments = false;
    boolean withPoints = false;

    //Inside the Game class, there must be a method called play, which simulates the game.
    //Surely, you can add other methods as well.
    public void play() {

    }
}
