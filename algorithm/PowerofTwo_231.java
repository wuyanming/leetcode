package HighFrequence.Summary;

public class PowerofTwo_231 {
    //Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && ((n & (n - 1)) == 0));
    }

    //Power of 2 means only one bit of n is '1', Here is my solution,just count the number of "1" bit
    public boolean isPowerOfTwoSec(int num) {
        if (num < 0)
            return false;
        return Integer.bitCount(num) == 1;
    }
}
