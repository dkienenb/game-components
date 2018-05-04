package org.gamenet.dkienenb.textgamecomponents;

import java.util.List;
import java.util.Scanner;

public class Inputer {

	public Inputer(Outputer out) {
		super();
		this.out = out;
		splitter = new StringSplitter();
	}

	private StringSplitter splitter;
	private Scanner scanner = new Scanner(System.in);
	private Outputer out;
	
	public List<String> input() {
		out.output("> ");
		String line = inputRaw();
		out.addToLog(line + '\n');
		return splitter.splitIntoWords(line);
	}

	public String inputRaw() {
		return scanner.nextLine();
	}
}
