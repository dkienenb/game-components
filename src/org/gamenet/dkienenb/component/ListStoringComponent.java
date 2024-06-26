package org.gamenet.dkienenb.component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class ListStoringComponent<T> extends ImmutableDataStoringComponent<List<T>> {

	public ListStoringComponent() {
		super(new ArrayList<>());
	}

	protected Stream<T> stream() {
		return getValue().stream();
	}

}
