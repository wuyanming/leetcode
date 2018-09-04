package HighFrequence.Summary;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray_215 {
    //O(N lg N) running time + O(1) memory
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    //O(N lg K) running time + O(K) memory
    public int findKthLargestSec(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
//优先队列中元素默认按照自然顺序排列，也就是数字默认是最小的在队列头，字符串则按字典排序。
//如果想实现按照自己的意愿进行优先级排列的话，需要实现comparator接口。
