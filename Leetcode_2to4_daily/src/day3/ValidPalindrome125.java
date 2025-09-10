package day3;

public class ValidPalindrome125 {
	public static boolean validPalindromeBF(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isLetterOrDigit(c))
				sb.append(c);
		}

		String cleanStr = sb.toString().toLowerCase();
		System.out.println(cleanStr);
		String rev = reverseString(cleanStr).toLowerCase();
		return cleanStr.equals(rev);
	}

	public static boolean validPalindromeTP(String str) {
		if (str.length() == 0) {
			return true;
		}

		int left = 0, right = str.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(str.charAt(left)))
				left++;
			while (left < right && !Character.isLetterOrDigit(str.charAt(right)))
				right--;
			if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}

		return true;

	}

	public static String reverseString(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}

		System.out.println(rev);
		return rev;
	}

	public static void main(String[] args) {
		String str = "ma pam";
		System.out.println(validPalindromeBF(str));
		System.out.println(validPalindromeTP(str));
	}
}
