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
		LinkedList<Pair<K,V>> list = hashtable[hash(key)];
		
		//create list if none exists at this index
		if(list == null) 
		{
			list = new LinkedList<Pair<K,V>>();
		}
		else
		{
			//if there is a matching key in this list
			if(list.contains(pair))
			{
				int index = list.indexOf(pair);
				oldValue = list.get(index).getValue();
				list.remove(index);
			}
			else 
			{
				size++;
			}
		}
		list.add(pair);//add pair to list
		
		
		return oldValue;
	}
	
	@Override
	public V replace(K key, V newValue) 
	{
		Pair<K, V> pair = new Pair<K, V>(key, newValue);
		LinkedList<Pair<K,V>> list = hashtable[hash(key)];
		
		//if list exists and contains the same key
		if(list != null)
		{
			if(list.contains(pair))
			
				return put(key, newValue);
		}
		
		//returns null otherwise
		return null;
	}

	@Override
	public V get(K key) 
	{
		Pair<K, V> pair = new Pair<K, V>(key, null);
		LinkedList<Pair<K,V>> list = hashtable[hash(key)];
		
		//if there is a matching key in this list
		if(list != null)
		{
			if(list.contains(pair))
			{
				int index = list.indexOf(pair);
				return list.get(index).getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) 
	{
		Pair<K, V> pair = new Pair<K, V>(key, null);
		LinkedList<Pair<K,V>> list = hashtable[hash(key)];
		
		//if there is a matching key in this list
		if(list != null)
		{
			if(list.contains(pair))
			{
				int index = list.indexOf(pair);
				V pairVal =  list.get(index).getValue();
				list.remove(index);
				size--;
				return pairVal;
			}
		}
		
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
