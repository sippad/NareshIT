package count_char_occurrence;

import java.util.Scanner;

// Using same array (Shrinking the array length) by shifting
public class CountCharacterOccurrence_2 {

	public static void main(String[] args) {
		System.out.println(count("how do you do")); //h:1 o:4 w:1 d:2 y:1 u:1
	}

	public static String count(String input) {
		StringBuilder sb = new StringBuilder();
		// char c1[] =new char[25];
		int count = 1;
		char[] c1 = input.toLowerCase().toCharArray();
		int[] c2 = new int[input.length()];
		char[] temp;
		
		int charCount=0;
		int len = c1.length;
		for (int i = 0; i < len; i++) {
			if(c1[i]==' ')
				continue;
			for (int j = i + 1; j < len; j++) {
				if (c1[i] == c1[j]) {
					c1[j] = ' ';
					count++;
				}
			} //inner for			s
			c2[charCount] = count;
			count = 1;			
			if (c1[i] !=' ') {				
				c1[charCount]=c1[i];		
				charCount++;
			}			
		} // outer for				
		len=charCount;
		for (int i = 0; i < len; i++)			
			sb.append(c1[i] + ":" + c2[i] + " ");			
		return sb.toString().trim();
	}

}
