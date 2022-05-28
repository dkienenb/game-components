package org.gamenet.dkienenb.component;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

	private final List<Class<? extends Component>> dependencies;

	public Component() {
		dependencies = new ArrayList<>(0);
	}

	public Component(List<Class<? extends Component>> dependencies) {
		this.dependencies = dependencies;
	}

	public List<Class<? extends Component>> getDependencies() {
		return dependencies;
	}

}
