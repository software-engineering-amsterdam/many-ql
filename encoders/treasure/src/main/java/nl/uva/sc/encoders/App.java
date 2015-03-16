package nl.uva.sc.encoders;

public class App {

	public static void main(String[] args) throws Exception {

		Game game = new GameFactory().createGame(App.class
				.getResourceAsStream("/example.field"));

		game.play();
	}
}