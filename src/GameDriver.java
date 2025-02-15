public class GameDriver {
    public static void main(String[] args) {
        Game customUnoGame = UnoGameFactory.createCustomUnoGame();
        customUnoGame.play();


    }
}