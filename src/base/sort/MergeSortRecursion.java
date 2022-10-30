package base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 7991uxug@gmail.com
 * @date 11/6/22 12:22 PM
 */
public class MergeSortRecursion {

    public int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int mid = (nums.length - 1) / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid + 1);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            nums[index++] = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
        }
        while (index1 < nums1.length) {
            nums[index++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            nums[index++] = nums2[index2++];
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {19, 97, 9, 17, 1, 8};
        nums = new int[]{1,1,1,1,1};
        int[] sort = mergeSort(nums);
        System.out.println(Arrays.toString(sort));
    }
}
