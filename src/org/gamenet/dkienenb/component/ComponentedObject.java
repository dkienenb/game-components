package org.gamenet.dkienenb.component;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class ComponentedObject {

	@SafeVarargs
	protected static Map<Class<? extends Component>, Object[]> thisNeedsARealName(Class<? extends Component>... types) {
		Map<Class<? extends Component>, Object[]> map = new HashMap<>();
		Arrays.stream(types)
			.forEach(type -> map.put(type, new Object[0]));
		return map;
	}

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
		} else {
			throw new NoSuchElementException(this + " does not contain component " + componentType);
		}
	}

	public void checkDependencies() {
		components.stream().forEach(component -> {
			List<Class<? extends Component>> dependancies = component.getDependencies();
			dependancies.stream()
				.filter(dependency -> !hasComponent(dependency))
				.forEach(dependency -> {
					throw new IllegalStateException("Unmet component dependency: " + component + " depends on " + dependency);
				});
		});
	}

	protected <T extends Component> void addComponent(T component) {
		components.add(component);
		checkDependencies();
	}

	public <T extends Component> void createAndAddNewComponent(Class<T> componentType, Object... constructorArgs) {
		try {
			Arrays.stream(constructorArgs)
				.map(object -> object.getClass())
				.toArray(Class<?>[]::new);
			Constructor<T> constructor = componentType.getDeclaredConstructor();
			T instance = constructor.newInstance(constructorArgs);
			addComponent(instance);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void createAndAddNewComponents(Map<Class<? extends Component>, Object[]> components) {
		components.entrySet().stream()
		.forEach(entry -> createAndAddNewComponent(entry.getKey(), entry.getValue()));
	}

	public ComponentedObject(Map<Class<? extends Component>, Object[]> initialComponents) {
		createAndAddNewComponents(initialComponents);
	}

	protected ComponentedObject() {}
}
