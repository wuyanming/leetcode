package MathSummary;

import org.junit.Test;

public class PowerofThree_326 {
    //Approach #4 Integer Limitations [Accepted]
    public boolean isPowerOfThree(int n) {

        return n > 0 && 1162261467 % n == 0;
    }

    //Complexity Analysis
    //Time complexity : O(1)O(1). We are only doing one operation.
    //
    //Space complexity : O(1)O(1). We are not using any additional memory.

    @Test
    public void test() {
        int max = 1;
        while (max * 3 > max) max *= 3;
        System.out.println(max);
    }



    //Approach #1 Loop Iteration [Accepted]
    public boolean isPowerOfThreeSec(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
    //Complexity Analysis
    //Time complexity : O(log_b(n))O(log​b(n)). In our case that is O(log_3n)O(log3n).
    //The number of divisions is given by that logarithm.
    //
    //Space complexity : O(1)O(1). We are not using any additional memory.
}
