package datastructures;

public class HashMapDemo 
{
	public static void main(String args[])
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("first", 1);
		System.out.println(map.get("first"));
	}
}
