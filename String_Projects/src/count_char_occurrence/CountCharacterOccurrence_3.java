package count_char_occurrence;

import java.util.Scanner;


public class CountCharacterOccurrence_3 {
	
	public static void main(String[] args) {
		System.out.println(count("how AreeEE yOU ARE H"));
	}

	public static String count(String sInput){		
		StringBuilder sb = new StringBuilder();
		//char c1[]	=new char[25];		
		int count=1;		
		char[] c1= sInput.toLowerCase().toCharArray();
		char[] temp;
		int[] c2=new int[sInput.length()];
		int len= c1.length;
		
		for(int i=0;i<len;i++){			
			if(c1[i]==' ')		
				continue;
			
			for(int j=i+1;j<len;j++){
										
				if(c1[i]==c1[j]){
					c1[j]=' ';
					count++;					
				}
			}//inner for
			c2[i]=count;
			count=1;			
		}//outer for
		
		for(int i=0;i<c1.length;i++)	
			if(c1[i]!=' ')
			sb.append(c1[i]+":"+c2[i]+" ");	
		return sb.toString().trim();
		
	}
}
