package datastructures;

public interface Hashtable <K, V>
{
	// maps this key value pair to the hashtable
	// @param	key		the key that maps to the passed value in the hashtable
	// @param	value	the value corresponding to the given key
	// @returns 		the value of the previous entry, null if there is no previous value
	public V  put(K key, V value);
	
	// maps this key value pair to the hashtable only if there is an existing key-value pair for 
	//		the given key
	// @param	key		the key that maps to the passed value in the hashtable
	// @param	value	the value corresponding to the given key
	// @return	 		the value of the previous entry
	public V replace(K key, V newValue);
	
	
	// gets the value from mapped to this key in the hashtable
	// @param	key		the key corresponding to the desired value
	// @return			the value corresponding to the given key in the hashtable, null if there is no value for that key
	public V get(K key);
	
	
	// removes and returns the value corresponding to the given key
	// @param	key		a key for a key-value pair in the hashtable
	// @return			the value mapped to the given key, null if there is no value for that key
	public V remove(K key);
	
	
}
