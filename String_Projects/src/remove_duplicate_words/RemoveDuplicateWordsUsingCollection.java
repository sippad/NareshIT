package remove_duplicate_words;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicateWordsUsingCollection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = null;
		System.out.println("REMOVE DUPLICATE WORDS "
				+ "\n1.Cannot remove special characters in sentence\n2.Can remove case insensitive words\n---------------------");
		System.out.print("Enter a simple string with repeated words without special characters : ");
		sentence = sc.nextLine();
		String[] words = sentence.split("[ ]");
				
		LinkedHashSet<String> lhs = new LinkedHashSet();
		//LinkedHashSet -> because it stores unique values in insertion order.
		
		for (int i = 0; i < words.length; i++)					
				lhs.add(words[i].toLowerCase());		
		Iterator itr = lhs.iterator();
		System.out.print("Retrieved elements : ");
		while(itr.hasNext()){
			Object val = itr.next();
			System.out.print(val+" ");
		}	
	}
}