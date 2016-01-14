package simpleDiceGame;

import javax.swing.JOptionPane;

public class Rules {
	private static final String RULES = ("The goal is to win more rounds than the computer. \n"
			+ "The computer always goes first in the round and rolls two six-sided dice. \n"
			+ "You will be shown the computer's score and must beat it to win the round. \n"
			+ "In other words, the computer's advantage is that it wins ties.\n"
			+ "\n"
			+ "Your advantage as the player is that you may try to beat the computer's score by \n"
			+ "also rolling two six-sided dice or by rolling a single 12-sided die (ones are \nignored and rerolled).\n"
			+ "\n"
			+ "You win a round if you beat the computer's score. Otherwise, the computer wins \nthe round.");

	static void displayRules() {
		JOptionPane.showMessageDialog(null, RULES, "Rules of the Game", JOptionPane.INFORMATION_MESSAGE);
	}

}
