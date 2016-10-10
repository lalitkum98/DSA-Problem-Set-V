package ProblemSetV;

public class MirriorTree {
	static class Node {
		public Node left;
		public Node right;
		public int value;
	}

	public boolean isTreeMirrior(Node root) {
		if (root == null)
			return true;
		if (root.left == null && root.right != null || root.left != null
				&& root.right == null)
			return false;

		if (root.left.value == root.right.value)
			return findTreeMirrior(root.left, root.right);

		return false;
	}

	public boolean findTreeMirrior(Node tree1, Node tree2) {

		if (tree1 == null && tree2 == null)
			return true;
		if (tree1.left != null && tree2.right == null || tree1.right != null
				&& tree2.left == null)
			return false;
		if (tree1.left == null && tree2.right != null || tree1.right == null
				&& tree2.left != null)
			return false;
		if (tree1.value == tree2.value)
			return findTreeMirrior(tree1.left, tree2.right)
					&& findTreeMirrior(tree1.right, tree2.left);

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node();
		root.value = 6;
		root.left = new Node();
		root.left.value = 3;
		root.right = new Node();
		root.right.value = 3;
		root.left.left = new Node();
		root.left.left.value = 4;
		root.right.right = new Node();
		root.right.right.value = 4;
		MirriorTree mt = new MirriorTree();
		System.out.println(mt.isTreeMirrior(root));

	}

}
