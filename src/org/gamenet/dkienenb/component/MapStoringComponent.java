package org.gamenet.dkienenb.component;

import java.util.HashMap;
import java.util.Map;

public abstract class MapStoringComponent<K, V> extends ImmutableDataStoringComponent<Map<K, V>> {

	public MapStoringComponent() {
		super(new HashMap<>());
	}

	protected void put(K key, V value) {
		getValue().put(key, value);
	}

	protected V get(K key) {
		return getValue().get(key);
	}

	protected void remove(K key) {
		getValue().remove(key);
	}
}
