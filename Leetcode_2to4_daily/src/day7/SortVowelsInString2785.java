package day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SortVowelsInString2785 {

	public static String sortVowels(String s) {
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		List<Character> vList = new ArrayList<>();
		for (char c : s.toCharArray()) {
			if (vowels.contains(c)) {
				vList.add(c);
			}
		}

		Collections.sort(vList);
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (char c : s.toCharArray()) {
			if (vowels.contains(c)) {
				sb.append(vList.get(idx++));
			} else
				sb.append(c);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "lEetcOde";
		System.out.println(sortVowels(str));
	}
}
