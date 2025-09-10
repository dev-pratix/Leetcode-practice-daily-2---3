package day3;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromSA26 {
	public static int removeDupBFSet(int[] nums) {
		Set<Integer> removeDup = new LinkedHashSet<>();
		for (int num : nums) {
			removeDup.add(num);
		}

		int index = 0;
		for (int num : removeDup) {
			nums[index++] = num;
		}

		return index;
	}

	public static int removeDupSF(int[] nums) {
		// what's my plan of action is slow for unique and fast !=slow then slow++ and
		// return slow+1 coz we start slow = 0
		int slow = 0;
		for (int fast = 1; fast < nums.length; fast++) {
			if (nums[fast] != nums[slow]) {
				slow++;
				nums[slow] = nums[fast];
			}
		}
		return slow + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 4, 5, 5 };
		System.out.println(Arrays.toString(nums));
		int index = removeDupSF(nums);
		for (int i = 0; i < index; i++) {
			System.out.print(nums[i] + " ");
		}

	}
}
