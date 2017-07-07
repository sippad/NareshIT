import java.util.Scanner;
	
public class NPVal {
		public static void main(String[] args) {		
			String longStr;
			String subStr;
			String resStr="";
			int Pos;
			int lChar;
			Scanner sc;
	
			sc=new Scanner(System.in);
			System.out.print("String : ");
			longStr=sc.next();
			System.out.print("SubString word : ");
			subStr=sc.next();
						
			for(Pos=longStr.indexOf(subStr);Pos>=0;Pos=longStr.indexOf(subStr,Pos+1)){
				lChar=Pos+subStr.length();
				if(Pos>0){
					resStr+=Character.toString(longStr.charAt(Pos-1));				
				}
				if(lChar!=longStr.length()) {
					 resStr+=Character.toString(longStr.charAt(lChar));
				}	
			}
			System.out.println(resStr);
	   }
	}
