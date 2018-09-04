package HighFrequence.Summary;

public class UglyNumber_263 {
    //Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
    //Also try divisor 4 if that makes the code simpler / less repetitive.
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}
