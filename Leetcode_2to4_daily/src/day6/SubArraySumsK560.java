package day6;

public class SubArraySumsK560 {
	public static int subArraySumsKBF(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k)
					count++;
			}

		}
		return count;
	}

	public static void main(String[] args) {
		int [] nums = {1,1,1};
		System.out.println(subArraySumsKBF(nums, 3));
	}
}
