package base.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 7991uxug@gmail.com
 * @date 11/6/22 1:23 PM
 */
public class HeapSort {
    public int[] sort(int[] nums) {
        int N = nums.length;
        for (int i = N/2-1; i >= 0; i--) {
            heapify(nums, N, i);
        }
        for (int i = N-1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
//        Arrays.sort();
        return nums;
    }

    private void heapify(int[] nums, int N, int i) {
        int largest = nums[i];
        for (int j = i*2+1; j < N; j=j*2+1) {
            if (j+1 < N && nums[j] < nums[j+1]) {
                j++;
            }
            if (nums[j] > largest) {
                swap(nums, i, j);
                i = j;
            } else {
                break;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2};
//        HeapSort heapSort = new HeapSort();
//        int[] sort = heapSort.sort(nums);
//        System.out.println(Arrays.toString(sort));
        Deque<Integer> deque = new LinkedList<>();
        deque.poll();
    }
}
