package org.gamenet.dkienenb.component;

public abstract class ImmutableDataStoringComponent<T> extends Component {

	private final T value;

	protected T getValue() {
		return value;
	}

	public ImmutableDataStoringComponent(T value) {
		this.value = value;
	}

}