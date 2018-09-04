package HighFrequence.Summary;

//这道题说有两种特殊的字符，一种是两位字符，只能是二进制的11和10，另一种是单个位字符，只能是二进制的0。现在给了我们一个只包含0和1的数组，
//问我们能否将其正确的分割，使得最后一个字符是个单个位字符。这道题可以使用贪婪算法来做，因为两种字符互不干扰，
//只要我们遍历到了数字1，那么其必定是两位字符，所以后面一位也得跟着，而遍历到了数字0，那么就必定是单个位字符。
//所以我们可以用一个变量i来记录当前遍历到的位置，如果遇到了0，那么i自增1，如果遇到了1，那么i自增2，我们循环的条件是i < n-1，
//即留出最后一位，所以当循环退出后，当i正好停留在n-1上，说明最后一位是单独分割开的，因为题目中限定了最后一位一定是0，所以没必要再判断了
public class OnebitandTwobitCharacters_717 {
    //Approach #1: Increment Pointer [Accepted]
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
    //Complexity Analysis
    //Time Complexity: O(N)O(N), where NN is the length of bits.
    //Space Complexity: O(1)O(1), the space used by i


    //Approach #2: Greedy [Accepted]
    public boolean isOneBitCharacterSec(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }
    //Complexity Analysis
    //Time Complexity: O(N)O(N), where NN is the length of bits.
    //Space Complexity: O(1)O(1), the space used by parity (or i).
}
