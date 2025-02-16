package org.gamenet.dkienenb.component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ComponentedObject {

	private final List<Component> components = new ArrayList<>();

	public boolean hasComponent(Class<? extends Component> componentType) {
		return components.stream()
			.anyMatch(component -> component.getClass().isAssignableFrom(componentType));
	}

	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<T> componentType) {
		if (hasComponent(componentType)) {
			return (T) components.stream()
					.filter(component -> component.getClass().isAssignableFrom(componentType))
					.findFirst()
					.orElseThrow();
		}
		throw new NoSuchElementException(this + " does not contain component " + componentType);
	}

	public void checkDependencies() {
		components.forEach(component -> {
			List<Class<? extends Component>> dependencies = component.getDependencies();
			dependencies.stream()
				.filter(dependency -> !hasComponent(dependency))
				.forEach(dependency -> {
					throw new IllegalStateException("Unmet component dependency: " + component + " depends on " + dependency);
				});
		});
	}

	public <T extends Component> ComponentedObject addComponent(T component) {
		components.add(component);
		component.setAttached(this);
		checkDependencies();
		return this;
	}
}
