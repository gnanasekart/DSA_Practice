package basicPractice;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class HashCodeInternal {

	@Test
	public void internals(){
	String text = "Gnana";

	//Get the hashcode ->int
	int hashCode = text.hashCode();
	System.out.println(hashCode);
	int n=16;

	//get the index
	int index=hashCode & (n-1);
	System.out.println(index);

	//Terminology - Bucket, LinkedList, Collision
	//Initial and max capacity, default load factor

	Map<String, Integer> map = new HashMap<String, Integer>();

	map.put("babu", 42);
	map.put("hari", 40);
	map.put("haja", 28);

	int age = map.get("hari");
	System.out.println(age);
	}
}
