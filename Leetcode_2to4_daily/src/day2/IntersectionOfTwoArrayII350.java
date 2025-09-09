package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrayII350 {
	public static int[] intersectBF(int[] nums1, int[] nums2) {
		List<Integer> resultList = new ArrayList<>();
		boolean[] visited = new boolean[nums2.length];
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (!visited[j] && nums1[i] == nums2[j]) {
					resultList.add(nums1[i]);
					visited[j] = true;
					break;
				}
			}
		}
		return resultList.stream().mapToInt(i -> i).toArray();
	}

	public static int[] intersectSortTP(int[] nums1, int[] nums2) {
		List<Integer> resultList = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				resultList.add(nums1[i++]);
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else
				j++;
		}

		return resultList.stream().mapToInt(p -> p).toArray();
	}

	public static int[] intersectFreqMap(int[] nums1, int[] nums2) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		List<Integer> resultList = new ArrayList<>();
		for (int num : nums1) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		for (int num : nums2) {
			if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
				resultList.add(num);
				freqMap.put(num, freqMap.get(num) - 1);
			}
		}

		return resultList.stream().mapToInt(e -> e).toArray();
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5 };
		int[] nums2 = { 1, 2, 5, 6, 7 };

//		System.out.println(Arrays.toString(intersectSortTP(nums1, nums2)));
		System.out.println(Arrays.toString(intersectFreqMap(nums1, nums2)));
	}
}
