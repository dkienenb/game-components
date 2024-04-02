package org.gamenet.dkienenb.component;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

	private ComponentedObject attached;

	public Component() {
	}

	@SuppressWarnings("static-method")
	public List<Class<? extends Component>> getDependencies() {
		return new ArrayList<>(0);
	}

	public ComponentedObject getAttached() {
		return attached;
	}

	public void setAttached(ComponentedObject attached) {
		this.attached = attached;
	}

}
