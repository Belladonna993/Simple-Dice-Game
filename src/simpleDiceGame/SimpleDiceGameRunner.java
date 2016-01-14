package simpleDiceGame;

public class SimpleDiceGameRunner {

	public static void main(String[] args) {
		SimpleDiceGameController go = new SimpleDiceGameController();
		
		boolean playAgain = true;
		Rules.displayRules();

		while(playAgain) {
			go.setRounds();
			go.playGame();
			go.displayFinalScore();
			playAgain = go.playAgain();
		}
	}
}
