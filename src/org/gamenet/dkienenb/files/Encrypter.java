package org.gamenet.dkienenb.files;

import java.util.Random;
import java.util.Scanner;

public class Encrypter {

	private static final String FILE_END = "Encrypted File. Nice try.";

	public static String encrypt(String data, Random random) {
		long seed = random.nextLong();
		Random encryptionRandom = new Random(seed);
		char[] chars = data.toCharArray();
		StringBuilder encryptedDataBuilder = new StringBuilder(String.valueOf(seed) + "-");
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			encryptedDataBuilder.append(encryptChar(c, encryptionRandom) + "-");
		}
		encryptedDataBuilder.append(FILE_END);
		return encryptedDataBuilder.toString();
	}

	public static String encryptChar(char c, Random encryptionRandom) {
		final int multiplier = encryptionRandom.nextInt(335);
		final int character = c;
		return String.valueOf(Math.multiplyExact(multiplier, character));
	}

	public static String dencrypt(String rawInput) {
		final Scanner scanner = new Scanner(rawInput);
		scanner.useDelimiter("-");
		String seedString = scanner.next();
		long seed = Long.valueOf(seedString);
		Random encryptionRandom = new Random(seed);
		StringBuilder sb = new StringBuilder();
		while (scanner.hasNext()) {
			String next = scanner.next();
			char nextChar = dencryptChar(next, encryptionRandom);
			sb.append(nextChar);
		}
		scanner.close();
		return sb.toString();
	}

	public static char dencryptChar(String next, Random encryptionRandom) {
		final int multiplier = encryptionRandom.nextInt(335);
		final int product = Integer.valueOf(next);
		if (product % multiplier == 0) {
			return (char) (product / multiplier);
		}
		throw new RuntimeException();
	}
}