package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			double x = rand.nextDouble()*100;
			doubles.push(x);
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String userInput1 = JOptionPane.showInputDialog("Enter a number between 0 and 100(Inclusive.");
		String userInput2 = JOptionPane.showInputDialog("Enter a number between 0 and 100(Inclusive.");
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		int userInputInt1 = Integer.parseInt(userInput1);
		int userInputInt2 = Integer.parseInt(userInput2);
		if (userInputInt1 > userInputInt2) {
			int temp = userInputInt1;
			userInputInt1 = userInputInt2;
			userInputInt2 = temp;
		}
		for (int i = 0; i < doubles.size(); i++) {
			double topOfStack = doubles.pop();
			if (userInputInt1 < topOfStack && topOfStack < userInputInt2) {
				System.out.println(topOfStack);
			}
		}
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}
