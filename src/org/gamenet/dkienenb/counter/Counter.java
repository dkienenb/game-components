package org.gamenet.dkienenb.counter;

import java.util.HashMap;

public class Counter<K> {

	@Override
	public String toString() {
		return "Counter [map=" + map.toString() + "]";
	}

	private HashMap<K, Integer> map = new HashMap<>();

	public void addOne(K key) {
		Integer value = map.get(key);
		if (value == null) {
			value = 0;
		}
		map.put(key, value + 1);
	}

	public int get(K key) {
		Integer value = map.get(key);
		if (value == null) {
			value = 0;
			map.put(key, value);
		}
		return value;
	}

	public int reset(K key) {
		return map.put(key, 0);
	}

	public void reset() {
		map.replaceAll((key, integer) -> 0);
	}
}
