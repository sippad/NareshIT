class PalindromeThread implements Runnable {
	int number = EvenOddThread.number;

	@Override
	public void run() {
		isPalindrome();
	}

	public void isPalindrome() {
		Thread thInfo = Thread.currentThread();
		int sum = 0;
		int temp = number;
		while (temp > 0) {
			int remainder = 0;
			remainder = temp % 10;
			sum = sum * 10 + remainder;
			temp = temp / 10;
		}
		if (sum == number)
			System.out.println(thInfo + ": Number is a palindrome number");
		else
			System.out.println(thInfo + ": Number is not a palindrome number");
	}
}
