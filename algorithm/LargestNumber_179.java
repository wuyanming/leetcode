package HighFrequence.Summary;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {
    //Approach #1 Sorting via Custom Comparator [Accepted]
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
    //Complexity Analysis
    //Time complexity : \mathcal{O}(nlgn)O(nlgn)
    //
    //Although we are doing extra work in our comparator, it is only by a constant factor.
    //Therefore, the overall runtime is dominated by the complexity of sort, which is \mathcal{O}(nlgn)O(nlgn) in Python and Java.
    //
    //Space complexity : \mathcal{O}(n)O(n)
    //
    //Here, we allocate \mathcal{O}(n)O(n) additional space to store the copy of nums.
    //Although we could do that work in place (if we decide that it is okay to modify nums),
    //we must allocate \mathcal{O}(n)O(n) space for the final return string.
    //Therefore, the overall memory footprint is linear in the length of nums.
}
