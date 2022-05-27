package org.gamenet.dkienenb.textgamecomponents;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

	public List<String> splitIntoWords(String stringToSplit) {
		String[] splitString = stringToSplit.split(" ");
		List<String> stringList = Arrays.asList(splitString);
		removeNullStrings(stringList);
		return stringList;
	}

	@SuppressWarnings("static-method")
	private void removeNullStrings(List<String> stringList) {
		if (1 == stringList.size() && stringList.get(0).equals("")) {
			return;
		}
		stringList.stream()
			.filter(string -> string == null || string.equals("") || string.equals("\t") || string.equals("\n") || string.equals("\r"))
			.forEach(string -> stringList.remove(string));
	}

}
