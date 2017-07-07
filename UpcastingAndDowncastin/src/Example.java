
public class Example {

	static void m1(Object obj){
		if(obj instanceof A){
			System.out.println("A object");
			System.out.println(((A)obj).x);
		}		
		else if(obj instanceof B){
			System.out.println("B object");			
		}
		else if(obj instanceof C){
			System.out.println("C object");
		}
	}
}
