package sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void selectionSort(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			int mini = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[mini]) {
					mini = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[mini];
			nums[mini] = temp;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 3, 2, 5 };
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
