import java.util.Scanner;

public class EvenOddThread implements Runnable {
	static int number;
	
	@Override
	public void run() {
		Thread thInfo = Thread.currentThread();
		if (number % 2 == 0)
			System.out.println(thInfo + ": Number is Even number");
		else
			System.out.println(thInfo + ": Number is a odd number");		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the integer number : ");
		number = sc.nextInt();
		sc.close();
		EvenOddThread eo = new EvenOddThread();
		PalindromeThread pt = new PalindromeThread();
		Thread eoThread = new Thread(eo);
		Thread pThread = new Thread(pt);
		eoThread.start();
		pThread.start();
	}
}
