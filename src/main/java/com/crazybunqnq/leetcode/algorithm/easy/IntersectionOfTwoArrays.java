package com.crazybunqnq.leetcode.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * <p>
 * Created by Administrator on 2016/7/8.
 */
public class IntersectionOfTwoArrays {
    /**
     * defeat 9%
     *
     * @param nums1
     * @param nums2
     *
     * @return
     */
    public static int[] intersection17ms(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        for (int x = 0; x < nums2.length; x++) {
            for (int y = 0; y < nums1.length; y++) {
                if (nums2[x] == nums1[y]) {
                    nums.add(nums2[x]);
                }
            }
        }
        int length = nums.size();
        int[] result = new int[length];
        for (int i : nums) {
            result[--length] = i;
        }
        return result;
    }

    /**
     * defeat 33%
     *
     * @param nums1
     * @param nums2
     *
     * @return
     */
    public static int[] intersection7ms(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        Set<Integer> result = new HashSet<>();

        if (nums1 == null || nums2 == null)
            return null;

        for (int n : nums1) {
            set.add(n);
        }
        for (int m : nums2) {
            if (set.contains(m)) {
                result.add(m);
            }
        }
        int size = result.size();
        int[] res = new int[result.size()];
        for (int k : result) {
            res[--size] = k;
        }
        return res;
    }

    /**
     * defeat 93%
     *
     * @param nums1
     * @param nums2
     *
     * @return
     */
    public static int[] intersection4ms(int[] nums1, int[] nums2) {
        qsort(nums1, 0, nums1.length - 1);
        qsort(nums2, 0, nums2.length - 1);
        return merge(nums1, nums2);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    // my own quick sort
    private static void qsort(int[] arr, int left, int right) {
        int start = left;
        int end = right;
        if (left >= right) {
            return;
        }
        int target = arr[left];
        while (true) {
            while (arr[left] <= target && right > left) {
                left++;
            }
            while (arr[right] > target && right >= left) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
        }
        swap(arr, start, right);
        qsort(arr, start, right - 1);
        qsort(arr, right + 1, end);
    }

    // use merge to delete dumplicate
    private static int[] merge(int[] nums1, int[] nums2) {
        int reserveLen = nums1.length + nums2.length;
        int[] ret = new int[reserveLen];

        int idx1 = 0;
        int idx2 = 0;
        int count = 0;
        for (int i = 0; i < reserveLen; i++) {
            if (idx1 >= nums1.length || idx2 >= nums2.length) {
                break;
            }
            int last1 = nums1[idx1];
            int last2 = nums2[idx2];
            while (idx1 + 1 < nums1.length && nums1[idx1 + 1] == last1) {
                idx1++;
            }
            while (idx2 + 1 < nums2.length && nums2[idx2 + 1] == last2) {
                idx2++;
            }

            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] == nums2[idx2]) {
                ret[count++] = nums1[idx1];
                idx1++;
                idx2++;
            } else {
                idx2++;
            }
        }
        int[] real_ret = new int[count];
        for (int i = 0; i < count; i++) {
            real_ret[i] = ret[i];
        }
        return real_ret;
    }
}
