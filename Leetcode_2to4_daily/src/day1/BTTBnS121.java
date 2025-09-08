package day1;

public class BTTBnS121 {

	public int maxProfitBF(int[] nums) {
		int maxProfit = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				maxProfit = Math.max(maxProfit, nums[j] - nums[i]);
			}
		}

		return maxProfit;
	}

	public int maxProfitOnePass(int[] nums) {
		int miniPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int num : nums) {
			if (num < miniPrice)
				miniPrice = num;
			maxProfit = Math.max(maxProfit, num - miniPrice);
		}

		return maxProfit;
	}

}
