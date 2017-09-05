package remove_duplicate_words;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicateWordsWithoutCollection {
	static int len;
	static String words[];

	public static String remove(String sentence) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		System.out.println(" Remove duplicate words from string \n -------------------------");
		System.out.print(" Enter a simple string with repeated words without special characters : ");

		words = sentence.split(" ");
		len = words.length;
		for (int i = 0; i < len; i++) {
			System.out.println("Inside I len:" + len);
			for (int j = i + 1; j < len; j++) {
				System.out.println("  inside j len" + len);
				if (words[i].equalsIgnoreCase(words[j])) {
					System.out.println("    Matched : " + words[i]);
					for (int k = j; k < len; k++) {
						words[k] = words[k + 1];
						System.out.println("      shifting");
						len--;
					}
					System.out.println("Length decreased" + len);
					j--;
				} // if
			}
			sb.append(words[i] + " ");
		}
		System.out.println("Outside length " + len);
		return sb.toString().trim();
		// LinkedHashSet -> because it stores unique values in insertion order.
		// how are you are you ok
		// how are are are you you you
	}
}
