import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MapExample {
	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
		emp1.setEno(101); emp1.setEname("Hari Krishna"); emp1.setDepartment("Java"); emp1.setSalary(1000);
		Employee emp2 = new Employee();		
		emp2.setEno(102); emp2.setEname("Sudhakar Sharma"); emp2.setDepartment(".net"); emp2.setSalary(2000);
		
		LinkedHashMap map = new LinkedHashMap();
		map.put(emp1.getEno(), emp1);
		map.put(emp2.getEno(), emp2);		
		System.out.println("Original Collection :"+map);
				
		ArrayList al = new ArrayList(map.values());
		Employee e= (Employee)al.get(1);
		e.setDepartment("Python");
		System.out.println("2nd Employee Department Modified :"+map);
		for (Object empObj: al) {
			Employee emp = (Employee)empObj;
			emp.setSalary(emp.getSalary()+emp.getSalary()*0.30);
			System.out.println("Modified salaries : "+emp);
		}		
	}
}
		
		
		
		