package DAS;

public class SortingAlgorithm {

	public static void main(String[] args) {
		bubbleSort();

	}
	
	public static void bubbleSort() {
		
		int[] numberList = {5, 2, 8, 1};
		
		for (int i = 0; i < numberList.length - 1; i++) {
			for (int j = 0; j < numberList.length - 1 - i; j++) {
				if (numberList[j] > numberList[j + i]) {
					int temp = numberList[j];
					numberList[j] = numberList[j+1];
					numberList[j + 1] = temp;
				}
			}
			for (int h = 0; h < numberList.length; h++) {
				System.out.print(numberList[h] + ", ");
			}
			System.out.println();
		}
		
	}

}
