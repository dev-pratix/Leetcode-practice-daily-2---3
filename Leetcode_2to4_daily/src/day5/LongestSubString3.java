package day5;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString3 {

	// Length of longest substring without repeating character

	public static int lengthOfLongestSubBF(String s) {
		int maxString = 0;
		for (int i = 0; i < s.length(); i++) {
			Set<Character> setString = new HashSet<>();
			for (int j = i; j < s.length(); j++) {
				if (setString.contains(s.charAt(j)))
					break;
				setString.add(s.charAt(j));
				maxString = Math.max(maxString, j - i + 1);
			}
		}
		return maxString;
	}

	public static int lengthOfLongestSubTP(String s) {
		Set<Character> setString = new HashSet<>();
		int left = 0, maxLength = 0;
		for (int right = 0; right < s.length(); right++) {
			while(setString.contains(s.charAt(right))) {
				setString.remove(s.charAt(left));
				left++;
			}
			setString.add(s.charAt(right));
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String str = "helloworld";
//		int i = lengthOfLongestSubBF(str);
		int i = lengthOfLongestSubTP(str);
		System.out.println(i);
	}
}
