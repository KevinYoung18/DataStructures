package datastructures;

public class HashMapDemo 
{
	public static void main(String args[])
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("first", 1);
		System.out.println(map.get("first"));
		System.out.println(map.replace("first", 2));
		System.out.println(map.get("first"));
		System.out.println(map.remove("first"));
		System.out.println(map.get("first"));
		
	}
}
