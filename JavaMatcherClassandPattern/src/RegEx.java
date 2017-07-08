import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	
	public static void main(String[] args) {
		
		String s1 = "Michael Phelps	23	United States	2008	08-24-08	Swimming	8	0	0	8";
		String s2 = "Pieter van den Hoogenband	22	Netherlands	2000	10-01-00	Swimming	2	0	2	4";
		String s3 = "Andrew Lauterstein	21	Australia	2008	08-24-08	Swimming	0	1	2	3";
		final String REGEX1 = "\\s\\d{2}\\s";
		final String REGEX2 = "\\s\\d{4}\\s";
		final String INPUT = "Michael Phelps    23	United States	2008	08-24-08	Swimming	8	0	0	8";
		 
		      Pattern p1 = Pattern.compile(REGEX1);
		      Pattern p2 = Pattern.compile(REGEX2);
		      Matcher m1 = p1.matcher(s2);   // get a matcher object
		      Matcher m2 = p2.matcher(s2);   // get a matcher object
		      int endOfAge=0,startOfYear=0;
		      int count = 0;

		      while(m1.find()) {		           		       
		         endOfAge=m1.end();		    
		      }
		      
		      while(m2.find()){
		    	startOfYear = m2.start();
		      }
		      
		      System.out.println("End of Age : "+endOfAge);
		      System.out.println("Start of Year : "+startOfYear);
		      System.out.println(s2.substring(endOfAge, startOfYear));
	}
}
