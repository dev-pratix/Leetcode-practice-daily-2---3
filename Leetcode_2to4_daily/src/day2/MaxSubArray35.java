package day2;

public class MaxSubArray35 {
	public static int maxSubArrayBF(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				maxSum = Math.max(maxSum, sum);
			}
		}

		return maxSum;
	}

	public static int maxSubArrayOP(int[] nums) {
		int currentSum = nums[0];
		int maxSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { -1, -2, 3, 4, 5 };
		System.out.println(maxSubArrayBF(nums));
		System.out.println(maxSubArrayOP(nums));
	}
}
