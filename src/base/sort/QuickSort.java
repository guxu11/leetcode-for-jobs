package base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 7991uxug@gmail.com
 * @date 10/30/22 9:21 PM
 */
public class QuickSort {
    public int[] sort(int[] nums) {
        int left = 0, right = nums.length - 1;
        sort(nums, left, right);
        return nums;
    }
    public void sort(int[] nums, int left, int right) {
        int partition = partition(nums, left, right);
        if (partition == -1) return;
        sort(nums, left, partition - 1);
        sort(nums, partition + 1, right);
    }
    private int partition(int[] nums, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int index = left + 1;
        int partition = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < partition) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index - 1, left);
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    @Test
    public void test() throws InterruptedException {
        int[] nums = {19, 97, 9, 17, 1, 8};
//        System.out.println(partition(nums, 0, nums.length - 1));
        System.out.println(Arrays.toString(nums));
//        System.out.println(partition(nums, 0, nums.length - 1));
        sort(nums);
        System.out.println(Arrays.toString(nums));
        Thread.sleep(1000000);
    }
}
