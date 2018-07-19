package org.gamenet.dkienenb.factory;

@FunctionalInterface
public interface Factory<T> {
	
	public abstract T create();

}
