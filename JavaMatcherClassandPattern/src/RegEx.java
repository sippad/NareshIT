import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	private final static String s1 = "Michael Phelps	23	United States	2008	08-24-08	Swimming	8	0	0	8";
	private final static String s2 = "Pieter van den Hoogenband	22	Netherlands	2000	10-01-00	Swimming	2	0	2	4";
	private final static String s3 = "Andrew Lauterstein	21	Australia	2008	08-24-08	Swimming	0	1	2	3";	
	private static Matcher m1,m2,m3;
	private static Pattern p1,p2,p3;
	
	public static void main(String[] args) {
		int endOfAge=0;
		int startOfYear=0;
		int medals =0 ;
		
		String REGEX1 = "\\s\\d{2}\\s";
		String REGEX2 = "\\s\\d{4}\\s";
		String REGEX3 = "\\s\\d{1}\\s";
		 
		p1 = Pattern.compile(REGEX1);
		p2 = Pattern.compile(REGEX2);
		p3 = Pattern.compile(REGEX3);
		
		m1 = p1.matcher(s3);
		m2 = p2.matcher(s3); 
		m3 = p3.matcher(s3);
				
		while(m1.find()){ 		           		       
		    endOfAge=m1.end();
		    if(m2.find())	
		    	startOfYear=m2.start();
		    if(m3.find())
		    	medals=m3.start();
		}		      		      
		System.out.println("End of Age : "+endOfAge);
		System.out.println("Start of Year : "+startOfYear);
		System.out.println(s3.substring(endOfAge, startOfYear));
		System.out.println(s3.charAt(medals+1));
	}
}
