package HighFrequence.Summary;

public class GuessNumberHigherorLower_374 {
    //Approach #2 Binary Search [Accepted]
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    //Time complexity : O\big(\log_2 n\big)O(log2n). Binary Search is used.
    //Space complexity : O(1)O(1). No extra space is used.


    //Approach #3 Ternary Search [Accepted]
    public int guessNumberSec(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }
    //Time complexity : O\big(\log_3 n \big)O(log3n). Ternary Search is used.
    //Space complexity : O(1)O(1). No extra space is used.


    public static int guess(int num) {
        return 0;
        //You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
        //-1 : My number is lower
        // 1 : My number is higher
        // 0 : Congrats! You got it!
    }

    ;
}
