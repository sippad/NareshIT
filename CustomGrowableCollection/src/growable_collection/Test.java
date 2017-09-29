package growable_collection;

public class Test {
	public static void main(String[] args) {
		MyCollection coll = new MyCollection();
		coll.add("m");
		coll.add("y");
		coll.add("n");
		coll.add("a");
		coll.add("m");
		coll.add("e");
		coll.add("i");
		coll.add("s");
		coll.add("k");
		coll.add("h");
		
		//11		
		coll.add("a");
		coll.add("n");
		coll.add("a");
		coll.add("n");
		coll.add("d");
		coll.add("i");
		coll.add("a");
		coll.add("m");
		
		System.out.println(coll);
				
	}
}
