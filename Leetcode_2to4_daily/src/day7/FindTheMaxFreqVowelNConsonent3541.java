package day7;

public class FindTheMaxFreqVowelNConsonent3541 {
	public static int maxFreqConsNVowel(String str) {
		int [] cFreq = new int[26];
		int vMax = 0, cMax= 0;
		for(char c : str.toLowerCase().toCharArray()) {
			cFreq[c-'a']++;
			if(c == 'a'|| c=='e'||c=='i'||c=='o'||c=='u') {
				vMax=Math.max(vMax, cFreq[c-'a']);
			}else {
				cMax=Math.max(cMax,cFreq[c-'a']);
			}
		}
		
		return cMax+vMax;
	}
	
	public static void main(String[] args) {
		String str = "aaabcioubbbbc";
		System.out.println(maxFreqConsNVowel(str));
	}
}
