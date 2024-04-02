package org.gamenet.dkienenb.component;

public abstract class MutableDataStoringComponent<T> extends Component {

	protected T value;

	public MutableDataStoringComponent() {
		super();
	}

	protected T getValue() {
		return value;
	}

	protected void setValue(T value) {
		this.value = value;
	}

}
