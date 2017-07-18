import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelConsonentCount {

	public static void main(String[] args) {
		int vowelsCount=0;
		int consonentCount=0;
		String input;
//		int length=0;		
//		String s1 = "aeiou";
//		String s2 = "a12eiou3b";
//		String s3 = "12abeiosfg4 321";
//		String s4 = "35feasfc aafghe er*";  
//		String s5 = "24sfaca as463 sdio 45";
		Scanner sc = new Scanner(System.in);
				
		String vPat  = "[aeiou]";	
		String cPat = "[bcdfghjklmnpqrstvwxyz]";
		Pattern p1 = Pattern.compile(vPat);
		Pattern p2 = Pattern.compile(cPat);
//		input=s1;
		input = sc.nextLine();				
		Matcher m1 = p1.matcher(input);
		Matcher m2 = p2.matcher(input);
		while(m1.find())		
			vowelsCount++;
		while(m2.find())
			consonentCount++;
		
//		System.out.println("Vowels : "+vowelsCount+"\nConsonents : "+(input.length()-vowelsCount));
		System.out.println("Vowels : "+vowelsCount+"\nConsonents : "+consonentCount);	
	}
}
