package org.gamenet.dkienenb.textgamecomponents;

import java.util.List;
import java.util.Scanner;

public class Inputer {

	private final String prompt;

	public Inputer(Outputer out, String prompt) {
		super();
		this.out = out;
		this.prompt = prompt;
		splitter = new StringSplitter();
	}

	private StringSplitter splitter;
	private Scanner scanner = new Scanner(System.in);
	private Outputer out;
	
	public List<String> input() {
		out.output(prompt);
		String line = inputRaw();
		out.addToLog(line + '\n');
		return splitter.splitIntoWords(line);
	}

	public String inputRaw() {
		return scanner.nextLine();
	}

	public Outputer getOut() {
		return out;
	}
}
