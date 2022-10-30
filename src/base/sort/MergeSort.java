package base.sort;

import org.junit.Test;

import java.util.*;

/**
 * @author 7991uxug@gmail.com
 * @date 11/2/22 12:22 AM
 */
public class MergeSort {
    public int[] sort(int[] nums) {
        if (nums.length <= 1) return nums;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i]});
        }
        while (queue.size() > 1) {
            queue.add(merge(queue.poll(), queue.poll()));
        }
        return queue.poll();
    }

    private int[] merge(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return nums2;
        if (nums2.length == 0) return nums1;
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[index1] < nums2[index2]) {
                nums[i] = nums1[index1];
                index1++;
            } else {
                nums[i] = nums2[index2];
                index2++;
            }
            if (index1 == nums1.length || index2 == nums2.length) {
                break;
            }
        }
        if (index1 == nums1.length) {
            for (int i = index1 + index2; i < len; i++) {
                nums[i] = nums2[index2++];
            }
        }
        if (index2 == nums2.length) {
            for (int i = index1 + index2; i < len; i++) {
                nums[i] = nums1[index1++];
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {19, 97, 9, 17, 1, 8};
        int[] sort = sort(nums);
        System.out.println(Arrays.toString(sort));
    }
}
