package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupOfAnagrams49 {

	public static List<List<String>> groupOfAnagramKMethod(String[] strs) {
		Map<String, List<String>> result = new HashMap<>();
		for (String str : strs) {
			char[] keyArray = str.toCharArray();
			Arrays.sort(keyArray);
			String key = new String(keyArray);

			result.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
		}

		return new ArrayList<>(result.values());
	}

	public static List<List<String>> groupOfAnagramFreqMap(String[] strs) {
		Map<String, List<String>> result = new HashMap<>();
		for (String str : strs) {
			int[] count = new int[26];
			for (char c : str.toCharArray()) {
				count[c - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int i : count) {
				sb.append('#').append(i);
			}
			String key = sb.toString();
			result.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
		}

		return new ArrayList<>(result.values());
	}

	public static void main(String[] args) {
		String[] strs = { "aabb", "bbaa", "ccaa", "aacc" };
		System.out.println(groupOfAnagramKMethod(strs));
		System.out.println(groupOfAnagramFreqMap(strs));
	}
}
