package HighFrequence.Summary;

import org.junit.Test;

public class RangeSumQueryImmutable_303 {
    //Approach #1 (Brute Force) [Time Limit Exceeded]
    //Complexity analysis:
    //Time complexity : O(n)O(n) time per query. Each sumRange query takes O(n)O(n) time.
    //Space complexity : O(1)O(1). Note that data is a reference to nums and is not a copy of it.
    class NumArray1 {
        private int[] data;

        public NumArray1(int[] nums) {
            data = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += data[k];
            }
            return sum;
        }
    }


    //Approach #3 (Caching) [Accepted]
    //Complexity analysis
    //Time complexity : O(1)O(1) time per query, O(n)O(n) time pre-computation. Since the cumulative sum is cached,
    //each sumRange query can be calculated in O(1)O(1) time.
    //
    //Space complexity : O(n)O(n).

    class NumArray2 {
        private int[] sum;

        public NumArray2(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }

    }

    @Test
    public void test(){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 testCase = new NumArray2(nums);
        System.out.println(testCase.sumRange(0,5));
    }
}
