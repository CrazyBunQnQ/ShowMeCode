package com.crazybunqnq.util;

/**
 * Created by CrazyBun on 2016/7/11.
 */
public class ArrayUtil {
    /**
     * 得到两个整型数组的交集并从小到大排序
     *
     * @param nums1
     * @param nums2
     *
     * @return compute their intersection.
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);
        return merge(nums1, nums2);
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * quick sort 给整型数组中某一段元素从小到大排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
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
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    // use merge to delete dumplicate
    public static int[] merge(int[] nums1, int[] nums2) {
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
