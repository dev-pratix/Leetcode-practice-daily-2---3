package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams438 {
	// s = "abcdfcgvgcbd" s - string
	// p = "abc" p - pattern

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length()) {
			return result;
		}

		int[] pCount = new int[26]; // to match the frequency for array equals
		int[] sCount = new int[26]; // to match the frequency

		for (char c : p.toCharArray()) {
			pCount[c - 'a']++; // count the frquency of those character like [1,1,1,0000000...26]
		}

		int m = p.length(); // window size
		for (int i = 0; i < s.length(); i++) {
			sCount[s.charAt(i) - 'a']++;
			if (i >= m) {
				sCount[s.charAt(i - m) - 'a']--;
			}

			if (Arrays.equals(sCount, pCount)) {
				result.add(i - m + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "abcdefghbca";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
	}
}
