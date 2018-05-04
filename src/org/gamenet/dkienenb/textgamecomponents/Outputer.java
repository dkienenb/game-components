package org.gamenet.dkienenb.textgamecomponents;

import java.util.ArrayList;
import java.util.List;

public class Outputer {

	private List<String> log = new ArrayList<>();

	public void output(String string) {
		System.out.print(string);
		log.add(string);
	}

	public void outputIndented(String string) {
		outputLine("  " + string);
	}

	public void outputLine(String string) {
		output(string + '\n');
	}

	public List<String> log() {
		return log;
	}

	public void clearLog() {
		log.clear();
	}

	public boolean addToLog(String string) {
		return log.add(string);
	}
}
