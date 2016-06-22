package ProblemSetV;

import java.util.*;

public class TreeZigZagSpiralPrint {
	static class Tree {
		int value;
		Tree left;
		Tree right;
	}

	// Iterative
	public void printZigZag(Tree root) {
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {

			while (!stack2.isEmpty()) {
				Tree element = (Tree) stack2.pop();
				System.out.println(element.value);
				if (element.right != null)
					stack1.push(element.right);
				if (element.left != null)
					stack1.push(element.left);
			}
			while (!stack1.isEmpty()) {
				Tree element = (Tree) stack1.pop();
				System.out.println(element.value);
				if (element.left != null)
					stack2.push(element.left);
				if (element.right != null)
					stack2.push(element.right);
			}

		}

	}

	public int findHight(Tree root) {
		int value;
		if (root == null)
			return 0;
		return Math.max(findHight(root.left), findHight(root.right)) + 1;
	}

	// recursive
	public void printZigZagRec(Tree root) {
		int iteration = 1;
		for (int i = 1; i <= findHight(root); i++) {
			iteration = i % 2;
			printZigZagLevel(root, i, iteration);
		}

	}

	public void printZigZagLevel(Tree root, int level, int itration) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.value);
			return;
		}
		if (itration == 1) {
			printZigZagLevel(root.left, level - 1, itration);
			printZigZagLevel(root.right, level - 1, itration);
		} else {
			printZigZagLevel(root.right, level - 1, itration);
			printZigZagLevel(root.left, level - 1, itration);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree root = new Tree();
		root.value = 8;
		root.left = new Tree();
		root.left.value = 10;
		root.left.left = new Tree();
		root.left.left.value = 15;
		root.right = new Tree();
		root.right.value = 12;
		root.right.left = new Tree();
		root.right.right = new Tree();
		root.right.left.value = 13;
		root.right.right.value = 14;

		TreeZigZagSpiralPrint zz = new TreeZigZagSpiralPrint();
		zz.printZigZag(root);
		zz.printZigZagRec(root);
		// zz.findHight(root);
	}

}
