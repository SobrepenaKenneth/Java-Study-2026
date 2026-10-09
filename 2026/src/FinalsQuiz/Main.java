package FinalsQuiz;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		BinarySearchTree tree = new BinarySearchTree();

		int choice;

		do {
			System.out.println("╔═══════════════════════════════════╗");
			System.out.println("║  Binary Search Tree - Operations  ║");
			System.out.println("╠═══════════════════════════════════╣");
			System.out.println("║ ► 1. Insert                       ║");
			System.out.println("║ ► 2. Display (In-order)           ║");
			System.out.println("║ ► 3. Search                       ║");
			System.out.println("║ ► 4. Count Leaf Nodes             ║");
			System.out.println("║ ► 5. Minimum                      ║");
			System.out.println("║ ► 6. Exit                         ║");
			System.out.println("╚═══════════════════════════════════╝");
			System.out.print(" ► Enter choice: ");

			while (!scanner.hasNextInt()) {
				System.out.println("\n╔═══════════════════════════════════╗");
				System.out.println("║Please input number only.          ║");
				System.out.println("╚═══════════════════════════════════╝\n");
				scanner.next();
				System.out.print(" ► Enter choice: ");
			}
			choice = scanner.nextInt();
			System.out.println("─────────────────────────────────────");

			switch (choice) {
			case 1:
				System.out.print("Enter key to insert: ");
				int key = scanner.nextInt();
				if (tree.search(key)) {
					System.out.println("─────────────────────────────────────");
					System.out.println("Key " + key + " already exists.");
					System.out.println("─────────────────────────────────────");
					System.out.println("Duplicates not allowed.");
					System.out.println("─────────────────────────────────────");
				} else {
					tree.insertKey(key);
					System.out.println("─────────────────────────────────────");
					System.out.println("Key " + key + " inserted.");
					System.out.println("─────────────────────────────────────");
					System.out.println();
				}
				break;

			case 2:
				tree.displayInOrder();
				System.out.println("─────────────────────────────────────\n");
				break;

			case 3:
				if (tree.countLeafNodes() == 0) {
					System.out.println("The BST is empty. Nothing to search.");
					System.out.println("─────────────────────────────────────\n");
				} else {
					System.out.print("Enter key to search: ");
					int target = scanner.nextInt();
					System.out.println("─────────────────────────────────────");
					System.out.println(tree.search(target));
					System.out.println("─────────────────────────────────────");
				}
				break;

			case 4:
				System.out.println("Number of leaf nodes: " + tree.countLeafNodes());
				System.out.println("─────────────────────────────────────\n");
				break;

			case 5:
				Integer min = tree.findMinimum();
				if (min == null) {
					System.out.println("The BST is empty. No minimum.");
					System.out.println("─────────────────────────────────────\n");
				} else {
					System.out.println("Minimum key: " + min);
					System.out.println("─────────────────────────────────────\n");
				}
				break;

			case 6:
				System.out.println("Program Terminated...");
				System.out.println("─────────────────────────────────────");
				break;

			default:
				System.out.println("Invalid choice! Please pick 1-6.");
				System.out.println("─────────────────────────────────────");
			}
		} while (choice != 6);

		scanner.close();
	}
}