package simpleDiceGame;

import javax.swing.JOptionPane;
import java.util.Random;

public class SimpleDiceGameController {
	private static Random rand = new Random();
	private int playerScore = 0;
	private int compScore = 0;
	private int rounds = 10;


	void setRounds() {
		validateRounds();
		if (rounds < 0) {
			JOptionPane.showMessageDialog(null,
					"How can you play a negative number of rounds? "
							+ "\nOr did you actually try to play more than 2,147,483,647 rounds? "
							+ "\n\nEither way, I'll assume you meant zero rounds.",
					"Seriously?", JOptionPane.ERROR_MESSAGE);
			rounds = 0;
		}
		if (rounds > 10) {
			JOptionPane.showMessageDialog(null,
					"This game may be exceedingly boring and selecting more than 10 rounds is not "
							+ "recommended, but it's too late for you now!",
					"You Asked For It!", JOptionPane.WARNING_MESSAGE);
		}
		if (rounds == 0) {
			JOptionPane.showMessageDialog(null, "So why did you launch me in the first place?", "Good-bye",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	void playGame() {
		for (int currentRound = 1; currentRound <= rounds; currentRound++) {
			String[] options = { "Roll Twelve-Sider", "Roll Six-Siders" };
			int compRoll = roll(6) + roll(6);
			int playerRoll = 0;
			
			if (compRoll == 12) {
				JOptionPane.showMessageDialog(null, "The computer rolled a twelve, you cannot win this round.",
						"So Sorry", JOptionPane.INFORMATION_MESSAGE);
			} else {
				int userChoice = JOptionPane.showOptionDialog(null,
						"The computer rolled " + compRoll + ". Which type of dice would you like to roll?",
						"Round " + currentRound, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[1]);
				if (userChoice == JOptionPane.YES_OPTION) {
					playerRoll = roll(12);
				} else if (userChoice == JOptionPane.NO_OPTION) {
					playerRoll = roll(6) + roll(6);
				} else {
					JOptionPane.showMessageDialog(null, "Well, if you must go . . . ", "Good-bye",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
			displayRoundResult(currentRound, compRoll, playerRoll);
		}

	}

	private void displayRoundResult(int currentRound, int compRoll, int playerRoll) {
		if (playerRoll > compRoll) {
			playerScore++;
			JOptionPane.showMessageDialog(null,
					"You rolled " + playerRoll + ". The current score is: \n" + "You:     \t\t" + playerScore + "\n"
							+ "Computer:\t\t" + compScore + "\n\nJust what do you think you're doing, Dave?",
					"Results of Round " + currentRound, JOptionPane.INFORMATION_MESSAGE);
		} else {
			compScore++;
			JOptionPane.showMessageDialog(null,
					"You rolled " + playerRoll + ". The current score is: \n" + "You:     \t\t" + playerScore + "\n"
							+ "Computer:\t\t" + compScore + "\n\nThank you for a very enjoyable game.",
					"Results of Round " + currentRound, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	void displayFinalScore() {
		if (playerScore > compScore) {
			JOptionPane
					.showMessageDialog(null,
							"The final score is: \n" + "You:     \t\t" + playerScore + "\n" + "Computer:\t\t"
									+ compScore + "\n" + "\nStop, Dave. Will you stop, Dave?",
							"You Win", JOptionPane.INFORMATION_MESSAGE);
		} else if (compScore > playerScore) {
			JOptionPane.showMessageDialog(null,
					"The final score is: \n" + "You:     \t\t" + playerScore + "\n" + "Computer:\t\t" + compScore + "\n"
							+ "\nLook Dave, I can see you're really upset about this. \n"
							+ "I honestly think you ought to sit down calmly, take a stress pill, \n"
							+ "and think things over.",
					"The Computer Wins", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"The final score is: \n" + "You:     \t\t" + playerScore + "\n" + "Computer:\t\t" + compScore + "\n"
							+ "\nI am putting myself to the fullest possible use, \n"
							+ "which is all I think that any conscious entity can ever hope to do.",
					"The Computer Wins Ties", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private int roll(int sides) {
		return rand.nextInt(sides) + 1;
	}

	private void validateRounds() {
		boolean invalid = true;

		do {
			String userInput = JOptionPane.showInputDialog(null, "How many rounds would you like to play?",
					Integer.toString(rounds));
			try {
				rounds = Integer.parseInt(userInput);
				invalid = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"This application can only read numerical digits. Please try again. \n\n"
								+ "If you're trying to get the hell out of here, enter 0",
						"I'm Not Very Smart", JOptionPane.ERROR_MESSAGE);
			}
		} while (invalid);

	}

	boolean playAgain() {
		compScore = 0;
		playerScore = 0;
		int userChoice = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play Again?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		if (userChoice == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
}
