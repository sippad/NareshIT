package growable_collection;

public class MyCollection {
	private Object[] arr1;
	private int currIndex = 0;

	public MyCollection() {
		arr1 = new Object[10];
	}
	
	public void add(Object obj) {
		if (currIndex == arr1.length) {
			System.out.println("Inserting new item....length crossed the capacity");
			increaseCapacity();
		}
		arr1[currIndex++] = obj;
		System.out.println("Object " + obj + " stored at " + currIndex);
		
	}

	public void increaseCapacity() {
		System.out.println("about to increase object size ...current size is "+currIndex);
		Object[] arr2 = new Object[currIndex * 2];http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2393593
		for (int i = 0; i < arr1.length; i++)
			arr2[i] = arr1[i];	
		arr1 = arr2;		
	}
	
	public boolean contains(Object obj){
		return false;
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        int i;
		if (currIndex - 1 == -1)
			return "[]";
		sb.append('[');
		for (i = 0; i < currIndex-1; i++){
			System.out.println("Appending "+arr1[i]+" to sb");
			sb.append(arr1[i]+",");
		}					
		return sb.append(arr1[i] + "]").toString();
	}

}
