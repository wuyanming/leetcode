package HighFrequence.Summary;

import org.junit.Test;

public class PlusOne66 {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;

        while (index >= 0 && carry > 0) {
            digits[index] = (digits[index] + carry) % 10;
            carry = digits[index] == 0 ? 1 : 0;
            index--;
        }

        if (carry > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int[] digits = {4,3,2,1};
        int[] result  = plusOne(digits);
        System.out.println("result: "+result.toString());
    }
}
