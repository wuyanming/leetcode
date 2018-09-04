package HighFrequence.Summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_II_119 {

    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++)
            for (int j = i; j >= 1; j--)
                result[j] += result[j - 1];
        return Arrays.asList(result);
    }


    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int tmp = ret.get(j - 1) + ret.get(j);
                ret.set(j, tmp);
            }
            ret.add(1);
        }
        return ret;
    }
}
