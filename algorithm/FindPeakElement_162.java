package HighFrequence.Summary;

public class FindPeakElement_162 {
    //Approach 1: Linear Scan
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
    //Time complexity : O(n)O(n). We traverse the numsnums array of size nn once only.
    //Space complexity : O(1)O(1). Constant extra space is used.



    //Approach 3: Iterative Binary Search
    public int findPeakElementSec(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    //Time complexity : O\big(log_2(n)\big)O(log​2(n)).
    //We reduce the search space in half at every step. Thus, the total search space will be consumed in log_2(n)log2(n) steps.
    // Here, nn refers to the size of numsnums array.
    //
    //Space complexity : O\big(log_2(n)\big)O(log2(n)).
    // We reduce the search space in half at every step. Thus, the total search space will be consumed in log_2(n)log2(n) steps.
    //Thus, the depth of recursion tree will go upto log_2(n)log2(n)

}
