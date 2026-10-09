package w3Schools;

public class Main {

	public static void main(String[] args) {
		fibonacciSequence();
	}
	
	public static void fibonacciSequence() {
		int prev2 = 0;
		int prev1 = 1;
		
		System.out.println(prev2);
		System.out.println(prev1);
		
		for (int fibo = 0; fibo < 18; fibo++) {
			int newFibo = prev1 + prev2;
			System.out.println(newFibo);
			prev2 = prev1;
			prev1 = newFibo;
		}
	}

}
