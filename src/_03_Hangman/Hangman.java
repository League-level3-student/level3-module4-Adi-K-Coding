package _03_Hangman;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Hangman implements KeyListener {
	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.run();
		h.game();
	}

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> gameWords = new Stack<String>();
	String currentWord;
	int lives = 10;

	void run() {
		frame.add(panel);
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setSize(new Dimension(100, 50));
		frame.setVisible(true);
	}

	void game() {
		String userNumber = JOptionPane.showInputDialog("How many words would you like to guess?(Up till 266)");
		int userNumberInt = Integer.parseInt(userNumber);
		for (int i = 0; i < userNumberInt; i++) {
			String wordFromDict = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!gameWords.contains(wordFromDict)) {
				gameWords.push(wordFromDict);
			}
		}
		game2();
	}

	void game2() {
		currentWord = gameWords.pop();
		String underscores = "";
		for (int i = 0; i < currentWord.length(); i++) {
			underscores += "_";
		}
		label.setText(underscores);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean correctGuess = false;
		char letter = e.getKeyChar();
		for (int i = 0; i < currentWord.length(); i++) {
			if (letter == currentWord.charAt(i)) {
				correctGuess = true;
				String text = label.getText();
				String modifiedText = text.substring(0, i) + letter + text.substring(i + 1);
				label.setText(modifiedText);
			}
		}
		if (correctGuess == false) {
			lives -= 1;
			System.out.println("Lives: " + lives);
			if (lives <= 0) {
				JOptionPane.showMessageDialog(null, "The correct word was " + currentWord);
				int playAgainNumber = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
				if (playAgainNumber == 0) {
					game();
					lives = 10;
				} else {
					System.exit(0);
				}
			}
		}
		if (!label.getText().contains("_") && !gameWords.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Correct, the word was " + currentWord);
			game2();
			lives = 10;

		} else if (!label.getText().contains("_")) {
			JOptionPane.showMessageDialog(null, "You won. Good Job. ");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
