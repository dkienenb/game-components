package org.gamenet.dkienenb.component;

import java.util.List;

public abstract class ImmutableDataStoringComponent<T> extends Component {

	private final T value;

	public ImmutableDataStoringComponent(T value) {
		super();
		this.value = value;
	}

	public ImmutableDataStoringComponent(List<Class<? extends Component>> dependencies, T value) {
		super(dependencies);
		this.value = value;
	}

	protected T getValue() {
		return value;
	}

}