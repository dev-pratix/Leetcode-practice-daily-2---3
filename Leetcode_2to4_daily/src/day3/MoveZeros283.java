package day3;

import java.util.Arrays;

public class MoveZeros283 {
	public static void moveZeroBF(int[] nums) {
		int[] extraArray = new int[nums.length];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				extraArray[index++] = nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = extraArray[i];
		}
	}

	public static void moveZeroTP(int[] nums) {
		// so here i will take a pointer pos which will reassign all non-zero value
		// in-place at start and filled
		// remaining array spaces with zero
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[pos++] = nums[i];
			}
		}

		while (pos < nums.length) {
			nums[pos++] = 0;
		}

	}

	public static void moveZeroSlowFast(int[] nums) {
		// so here i will take a slow pointer which will only take non-zero nums
		// fast will keep traversing in order
		// and if found non-zero element by fast we will swap that part
		int slow = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			if (nums[fast] != 0) {
				int temp = nums[slow];
				nums[slow] = nums[fast];
				nums[fast] = temp;
				slow++;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 0, 3, 4, 0, 6 };
		System.out.println(Arrays.toString(array));
		moveZeroSlowFast(array);
		System.out.println(Arrays.toString(array));

	}
}
