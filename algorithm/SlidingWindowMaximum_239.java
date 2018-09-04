package Amazon20180831;

import java.util.LinkedList;

public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // remove smaller numbers in k range as they are useless
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // q contains index... r contains content
            dq.offer(i);

            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }

        }

        return result;
    }
    //We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) as each element is put and polled once.
    //At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means
    //
    //If an element in the deque and it is out of i-(k-1), we discard them.
    //We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array
    //
    //Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail.
    //This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i],
    //or any other subsequent window: a[i] would always be a better candidate.
    //
    //As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
}
