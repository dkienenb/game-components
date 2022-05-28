package org.gamenet.dkienenb.component;

import java.util.List;

public abstract class MutableDataStoringComponent<T> extends Component {

	protected T value;

	public MutableDataStoringComponent() {
		super();
	}

	public MutableDataStoringComponent(List<Class<? extends Component>> dependencies) {
		super(dependencies);
	}

	protected T getValue() {
		return value;
	}

	protected void setValue(T value) {
		this.value = value;
	}

}
