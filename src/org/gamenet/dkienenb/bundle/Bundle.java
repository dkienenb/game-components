package org.gamenet.dkienenb.bundle;

public class Bundle<A, B> {

	private final A first;
	private final B second;

	public Bundle(A a, B b) {
		this.first = a;
		this.second = b;
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}

}
