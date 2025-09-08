package day1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
	public int[] twoSumBF(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}

		throw new IllegalArgumentException("No two sum solution exists");
	}

	public int[] twoSumOptimized(int[] nums, int target) {
		Map<Integer, Integer> hMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hMap.containsKey(complement))
				return new int[] { hMap.get(complement), i };
			hMap.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution exists");
	}
}
