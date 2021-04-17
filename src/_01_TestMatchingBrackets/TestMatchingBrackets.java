package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */

	public static boolean doBracketsMatch(String b) {
		Stack<String> brackets = new Stack<String>();

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '{') {
				brackets.push("{");
			}
			if (b.charAt(i) == '}') {
				if (brackets.isEmpty()) {
					return false;
				}
				brackets.pop();
			}
		}
		if (brackets.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}