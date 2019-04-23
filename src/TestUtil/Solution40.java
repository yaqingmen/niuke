package TestUtil;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
        //1.堆排序
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2 - o1);
//        if(input.length == 0 || k <= 0 || k > input.length)
//            return new ArrayList<>();
//        for(int num : input) {
//            maxHeap.offer(num);
//            if(maxHeap.size() > k)
//                maxHeap.poll();
//        }
//        return new ArrayList<>(maxHeap);
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret.add(nums[i]);
        return ret;
    }
    public void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(int[] nums, int l, int h) {
        int p = nums[l];     /* 切分元素 */
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Solution40 t = new Solution40();
        System.out.println(t.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4));

    }

}
