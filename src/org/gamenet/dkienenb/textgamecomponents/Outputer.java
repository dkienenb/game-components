package org.gamenet.dkienenb.textgamecomponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Outputer {

	private final List<String> log = new ArrayList<>();
	private final Map<String, Color> colorMap = new HashMap<>();

	public void output(String string) {
		for (Map.Entry<String, Color> entry : colorMap.entrySet()) {
			String target = entry.getKey();
			string = string.replaceAll(target, entry.getValue().getRawColorCode() + target + Color.RESET.getRawColorCode());
		}
		outputUncolored(string);
	}

	private void outputUncolored(String string) {
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

	public void addToLog(String string) {
		log.add(string);
	}

	public void colorize(String string, Color color) {
		colorMap.put(string, color);
	}
}
