package org.gamenet.dkienenb;

import java.util.List;
import java.util.Random;

public class Util {

	public static <T> T getRandomFromList(List<T> list, Random random) {
		return list.get(random.nextInt(list.size()));
	}

}
