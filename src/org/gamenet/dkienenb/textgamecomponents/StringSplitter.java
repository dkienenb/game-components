package org.gamenet.dkienenb.textgamecomponents;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StringSplitter {

	public List<String> splitIntoWords(String stringToSplit) {
		String[] splitString = stringToSplit.split(" ");
		List<String> stringList = Arrays.asList(splitString);
		removeNullStrings(stringList);
		return stringList;
	}

	private void removeNullStrings(List<String> stringList) {
		for (Iterator<String> iterator = stringList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (null != string) {
				if (string.trim().equals("")) {
					iterator.remove();
				}
			} else {
				iterator.remove();
			}
		}
	}

}
