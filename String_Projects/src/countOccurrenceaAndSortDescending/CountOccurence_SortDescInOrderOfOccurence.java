package countOccurrenceaAndSortDescending;

import java.util.Scanner;

public class CountOccurence_SortDescInOrderOfOccurence {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		countAndSort(input);
		sc.close();
	}
	
	public static String countAndSort(String sentence){
		StringBuilder sb= new StringBuilder();
		int occur=1;
		int len = sentence.length();		
		char ch[] = sentence.toLowerCase().toCharArray();
		int count[] = new int[len];
		for(int i=0; i<len;i++){			
			if(ch[i]==' ')
				continue;
			for(int j=0;j<len;j++){
				if(ch[i]==ch[j]){
					ch[j]=' ';
					occur++;
				}							
			}//inner for
			count[i]=occur;
			occur=1;			
		}		
		for(int i=0; i<len;i++){
			if(ch[i]!=' '){
				sb.append(ch[i] + ":" + count[i] + " ");	
			}			
		}
		return sb.toString();		
	}
}
