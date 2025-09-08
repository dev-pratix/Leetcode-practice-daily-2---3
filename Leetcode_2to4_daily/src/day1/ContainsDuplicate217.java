package day1;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

	public static boolean containsDupBF(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}

	public static boolean containsDuplicateOp(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		for (int num : nums) {
			if (seen.contains(num))
				return true;
			seen.add(num);
		}
		return false;
	}

}
