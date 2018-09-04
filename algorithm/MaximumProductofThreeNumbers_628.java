package HighFrequence.Summary;

import java.util.Arrays;

public class MaximumProductofThreeNumbers_628 {
    //Approach #2 Using Sorting [Accepted]
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
    //Time complexity : O\big(nlog(n)\big)O(nlog(n)). Sorting the numsnums array takes nlog(n)nlog(n) time.
    //Space complexity : O(log(n)))O(log(n))). Sorting takes O(logn) space.


    //Approach #3 Single Scan [Accepted]
    public int maximumProductSe(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
    //Time complexity : O(n)O(n). Only one iteration over the numsnums array of length nn is required.
    //Space complexity : O(1)O(1). Constant extra space is used.
}
