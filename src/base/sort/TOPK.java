package base.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 7991uxug@gmail.com
 * @date 2/26/23 5:10 PM
 */
public class TOPK {
    Random random = new Random();
    public int[][] kClosest(int[][] points, int k) {
        sort(points, 0, points.length-1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void sort(int[][] points, int l, int r, int k) {
        if (l < r) {
            int partition = partition(points, l, r);
            if (partition == k-1) return;
            else if (partition > k-1) {
                sort(points, l, partition - 1, k);
            } else {
                sort(points, partition + 1, r, k);
            }
        }
    }
    private int partition(int[][] points, int l, int r) {
        int index = l + random.nextInt(r - l + 1);
        swap(points, index, l);
        index = l;
        int pivot = getDist(points[index]);
        for (int i = index+1; i <= r; i++) {
            if (getDist(points[i]) < pivot) {
                swap(points, i, ++index);
            }
        }
        swap(points, index, l);
        return index;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int getDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    @Test
    public void test() {
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
//        int k = 2;
//        int[][] res = kClosest(points, k);
//        for (int i = 0; i < res.length; i++) {
//            for (int j = 0; j < res[0].length; j++) {
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();
//        }
//        sort(points, 0, 2, 2);
        int[][] ints = kClosest(points, 2);
        for (int[] a: ints) {
            System.out.println(Arrays.toString(a));
        }
    }
}
