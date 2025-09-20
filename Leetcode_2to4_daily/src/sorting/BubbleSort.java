package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					nums[j] += nums[j + 1];
					nums[j + 1] = nums[j] - nums[j + 1];
					nums[j] -= nums[j + 1];
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 5, 11 };
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
