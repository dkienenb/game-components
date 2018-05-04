package org.gamenet.dkienenb.logicgates;

public class XORGate extends LogicGate {

	@Override
	public boolean logic(boolean a, boolean b) {
		return (a || b) && (!(a && b));
	}

}
