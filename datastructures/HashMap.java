package datastructures;

import java.util.LinkedList;

public class HashMap<K, V> implements Hashtable<K, V>
{

	private int mapSize;
	private int size = 0;
	private LinkedList<Pair<K,V>>[] hashtable;
	
	//TODO adjust size in every method
	HashMap()
	{
		this.mapSize = 100;
		hashtable = new LinkedList[this.mapSize];
	}
	HashMap(int mapSize)
	{
		this.mapSize = mapSize;
		hashtable = new LinkedList[this.mapSize];
	}
	
	@Override
	public V put(K key, V value) 
	{
		Pair<K, V> pair = new Pair<K, V>(key, value);
		V oldValue = null;
		
		if(hashtable[hash(key)] == null)
		{
			hashtable[hash(key)] = new LinkedList<Pair<K,V>>();
			
		}
		else
		{
			LinkedList<Pair<K,V>> list = hashtable[hash(key)];
			if(list.contains(pair))
			{
				int index = list.indexOf(pair);
				oldValue = list.get(index).getValue();
				list.remove(index);
				list.add(pair);
			}
		}
		
		return oldValue;
	}

	@Override
	public V replace(K key, V newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//returns the hashcode for the given key
	private int hash(K key)
	{
		return key.hashCode() % mapSize;
	}
	
	private class Pair<K, V>
	{
		private K key;
		private V value;
		
		public Pair(K key, V value) 
		{
			this.key = key;
			this.value = value;
		}
		public K getKey()
		{
			return key;
		}
		public V getValue()
		{
			return value;
		}
		private void setValue(V value)
		{
			this.value = value;
		}
		
		public boolean equals(Object pair)
		{
			if(pair.getClass().equals(this.getClass()))
				return ((Pair) pair).getKey().equals(key);
			return false;
		}
	}
}
