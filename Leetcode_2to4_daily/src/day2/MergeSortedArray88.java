package day2;

import java.util.Arrays;

public class MergeSortedArray88 {
	public static void mergeBF(int[] num1, int m, int[] num2, int n) {
		for (int i = 0; i < n; i++) {
			num1[m + i] = num2[i];
		}
		Arrays.sort(num1);
	}

	public static void mergeTP(int[] num1, int m, int[] num2, int n) {
		int[] resultArray = new int[m + n];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (num1[i] < num2[j])
				resultArray[k++] = num1[i++];
			else {
				resultArray[k++] = num2[j++];
			}
		}

		while (i < m)
			resultArray[k++] = num1[i++];
		while (j < n)
			resultArray[k++] = num1[j++];

		// java is passed by value so i need to use for loop for copying the value to
		// original nums1
		for (int p = 0; p < m + n; p++) {
			num1[p] = resultArray[p];
		}

	}

	public static void mergeTPReversed(int[] num1, int m, int[] num2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (num1[i] > num2[j])
				num1[k--] = num1[i--];
			else
				num1[k--] = num2[j--];
		}
		while (j >= 0)
			num1[k--] = num2[j--];

	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 0, 0, 0 };
		int[] nums2 = { 1, 2, 3 };
//		mergeBF(nums1, 4, nums2, nums2.length);
//		mergeTP(nums1, 4, nums2, nums2.length);
		mergeTPReversed(nums1, 4, nums2, nums2.length);
		System.out.println(Arrays.toString(nums1));
	}
}
