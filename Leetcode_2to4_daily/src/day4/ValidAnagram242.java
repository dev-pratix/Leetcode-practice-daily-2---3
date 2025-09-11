package day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Arrays.sort(sArray);
		Arrays.sort(tArray);
		return Arrays.equals(sArray, tArray);
	}

	public static boolean isAnagramHM(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> hMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			hMap.put(c, hMap.getOrDefault(c, 0) + 1);
		}

		for (char c : t.toCharArray()) {
			hMap.put(c, hMap.getOrDefault(c, 0) - 1);
			if (hMap.get(c) < 0)
				return false;
		}

		return true;
	}

	public static boolean isAnagramFreq(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			count[c - 'a']--;
			if (count[c - 'a'] < 0)
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		String s = "Appa".toLowerCase();
		String t = "ppAA".toLowerCase();

		System.out.println(isAnagram(s, t));
		System.out.println(isAnagramHM(s, t));
		System.out.println(isAnagramFreq(s, t));

	}
}
