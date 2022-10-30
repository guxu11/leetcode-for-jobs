package test;

import org.junit.Test;

import java.util.*;

/**
 * @author 7991uxug@gmail.com
 * @date 2/19/23 7:14 PM
 */
public class PracticePage {
    Map<Integer, Integer> freqMap = new HashMap<>();
    Random random = new Random();
    public int[] topKFrequent(int[] nums, int k) {
        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int[] freqNums = new int[freqMap.size()];
        int i = 0;
        for (int num: freqMap.keySet()) {
            freqNums[i++] = num;
        }
        sort(freqNums, 0, freqNums.length - 1, k);
        return Arrays.copyOfRange(freqNums, 0, k);
    }

    private void sort(int[] nums, int left, int right, int k) {
        if (left < right) {
            int partition = partition(nums, left, right);
            if (partition == k) return;
            else if (partition > k) sort(nums, left, partition - 1, k);
            else sort(nums, partition + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int index = left + random.nextInt(right - left + 1);
        swap(nums, left, index);
        index = left;
        int pivot = freqMap.get(nums[index]);
        for (int i = index + 1; i <= right; i++) {
            if (freqMap.get(nums[i]) > pivot) {
                swap(nums, i, ++index);
            }
        }
        swap(nums, left, index);
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    @Test
    public void test() {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        for (int i: ints) {
            System.out.print(i + " ");
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        char[] chars = new char[1];
        System.out.println(chars[0] == 0);

    }
}
