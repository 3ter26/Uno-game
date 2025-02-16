import controllers.CardsTable;
import enums.Color;
import enums.UnoRule;
import enums.UnoRuleCategory;
import helpers.UnoGameConfigurator;
import models.Card;
import models.Player;

import java.util.*;

import static enums.UnoRule.TWO_ONE_SIX_CARDS;
import static enums.UnoRuleCategory.*;

public class CustomUnoGame extends Game {
    private Card topCardOnDiscardPiles;
    private Stack<Card> discardPiles;
    private int currentPlayerIndex;
    private int direction = 1;

    private Map<UnoRuleCategory, UnoRule> rulesMap;


    public CustomUnoGame(Set<UnoRule> customRules) {
        this.rules = new HashSet<>(customRules);
        this. rulesMap = new HashMap<>();
        initRulesMap();
        this.players = new ArrayList<>();
        this.tableCards = new CardsTable();
        if (customRules.contains(TWO_ONE_SIX_CARDS)) {
            tableCards.initUnoCards();
        }
        this.discardPiles = new Stack<>();
        initPlayers();
    }

    private void initRulesMap() {
        for (UnoRule rule : rules) {
            rulesMap.put(rule.getCategory(), rule);
        }
    }

    private void initPlayers() {
        this.players = UnoGameConfigurator.getPlayersBasedOn(rules);
    }

    @Override
    public void play() {
        dealCards();
        topCardOnDiscardPiles = tableCards.drawCard();
        discardPiles.push(topCardOnDiscardPiles);
        currentPlayerIndex = 0;

        boolean gameWon = false;

        while (!gameWon) {
            Player player = players.get(currentPlayerIndex);

            System.out.println("\n=== " + player.getName() + "'s turn ===");
            System.out.println("Latest played Card: " + topCardOnDiscardPiles);
            System.out.println(player.getName() + "'s hand: " + player.getCardsInHand());

            Card cardToPlay = choosePlayableCard(player);

            int numberOfCardsToDraw = Integer.parseInt(getRuleOfType(DRAW_CARDS).getValue());

            if (cardToPlay == null) {
                System.out.println(player.getName() + " has no playable card and MUST draw");
                player.drawCard(tableCards, numberOfCardsToDraw);
            } else {
                System.out.println(player.getName() + " plays " + cardToPlay);
                if (player.getCardsInHand().size() == 1) {
                    player.sayUNO();
                }
                applyActionWildCards(cardToPlay);
                discardPiles.push(cardToPlay);
                topCardOnDiscardPiles = cardToPlay;
            }

            if (player.getCardsInHand().isEmpty()) {
                System.out.println("\n\n\n---------- ---------- ---------- ----------> " + player.getName() + " is WINNER <---------- ---------- ---------- ---------- ");
                gameWon = true;
            } else {
                advanceToNextPlayer();
            }
        }
    }

    private void applyActionWildCards(Card card) {
        switch (card.getCardType()) {
            case ACTION_CARD_SKIP: {
                System.out.println("Action card: Next player is skipped");
                advanceToNextPlayer();
                break; }
            case ACTION_CARD_REVERSE: {
                System.out.println("Action card: Reverse gaming flow");
                direction *= -1;
                break; }
            case ACTION_CARD_DRAW_TWO: {
                System.out.println("Action card: Next player draws 2 cards and skip");
                int nextPlayerIndex = getNextPlayerIndex();
                Player nextPlayer = players.get(nextPlayerIndex);
                nextPlayer.drawCard(tableCards, Integer.parseInt(card.getCardType().getValue()));
                advanceToNextPlayer();
                break; }
            case WILD_CARD_DRAW_FOUR: {
                System.out.println("Action card: Next player draws 4 cards and skip");
                int nextIndex = getNextPlayerIndex();
                Player nextPlayer = players.get(nextIndex);
                nextPlayer.drawCard(tableCards, Integer.parseInt(card.getCardType().getValue()));
                advanceToNextPlayer();
                break;
            }
        }
    }

    private void advanceToNextPlayer() {
        currentPlayerIndex = getNextPlayerIndex();
    }

    private Card choosePlayableCard(Player player) {
        Card onTopCard = !discardPiles.isEmpty() ? discardPiles.pop() : topCardOnDiscardPiles;

        for (Card card : player.getCardsInHand()) {
            if (card.isIfWildCard()) {
                player.removeCardFromHand(card);
                Color choosenColor = chooseColorForWild(player);
                card.setColor(choosenColor);
                return card;
            }
            if (onTopCard != null && card.getColor() == onTopCard.getColor()) {
                player.removeCardFromHand(card);
                return card;
            }
            if (onTopCard != null && card.getNumber() == onTopCard.getNumber() && card.getNumber() != -1) {
                player.removeCardFromHand(card);
                return card;
            }
            if (onTopCard != null && card.getCardType() == onTopCard.getCardType() && card.isIfActionCard()) {
                player.removeCardFromHand(card);
                return card;
            }
        }
        return null;
    }

    private Color chooseColorForWild(Player player) {
        Color[] colors = Color.values();
        /*
        I am supposed to ask the user to input/choose which color he is supposed to choose,
        after that I am supposed to execute a switch statement to check which color is choosen
        and return it for this method
         */
            return colors[0];
    }

    private int getNextPlayerIndex() {
        int next = currentPlayerIndex + direction;
        int playersSize = Integer.parseInt(getRuleOfType(NUMBER_OF_PLAYERS).getValue());

        if (next < 0) {
            next = playersSize - 1;
        } else if (next >= playersSize) {
            next = 0;
        }
        return next;
    }

    @Override
    public void dealCards() {
        int cardsDealt = Integer.parseInt(getRuleOfType(CARDS_DEALT).getValue());

        for (Player player : players) {
            for (int i = 0; i < cardsDealt; i++) {
                player.addCardToHand(tableCards.drawCard());
            }
        }
        System.out.println("JUST FINISHED THE dealCards(), and each player is having cards of no. " + players.getFirst().getCardsInHand().size());
    }

    private UnoRule getRuleOfType(UnoRuleCategory category) {
        return rulesMap.get(category);
    }


}
