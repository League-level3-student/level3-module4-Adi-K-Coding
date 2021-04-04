package _00_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener, ActionListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton undoButton = new JButton("Undo");
	Stack<Character> undo = new Stack<Character>();

	public static void main(String[] args) {
		_02_TextUndoRedo runner = new _02_TextUndoRedo();
		runner.Run();
	}

	void Run() {
		frame.add(panel);
		panel.add(label);
		panel.add(undoButton);
		frame.addKeyListener(this);
		undoButton.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 400));
frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
			label.setText(label.getText() + e.getKeyChar());
		} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (label.getText().length() > 0) {
				undo.push(e.getKeyChar());
				String labelSubstring = label.getText().substring(0, label.getText().length() - 1);
				label.setText(labelSubstring);
			}
		}
frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText(label.getText() + undo.pop());
		frame.pack();

	}

}
