package org.gamenet.dkienenb.reflection;

import java.util.ArrayList;
import java.util.List;

public final class ReflectionUtil {

	public static Class<?>[] getClassArrayFromObjectArray(Object[] array) {
		final List<Class<?>> classList = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			final Object object = array[i];
			classList.add(object.getClass());
		}
		return classList.toArray(new Class<?>[array.length]);
	}

	private ReflectionUtil() {}

}
