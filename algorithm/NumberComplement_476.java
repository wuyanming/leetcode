package HighFrequence.Summary;

public class NumberComplement_476 {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    //UPDATE
    //As several people pointed out, we don't need to left shift 1.
    //That's true because the highest 1 bit will always become 0 in the Complement result. So we don't need to take care of that bit.

    public class Solution {
        public int findComplement(int num) {
            return ~num & (Integer.highestOneBit(num) - 1);
        }
    }


    public int FindComplement(int num) {
        int mask = 1;
        while (mask < num) mask = (mask << 1) | 1;
        return ~num & mask;
    }
}
