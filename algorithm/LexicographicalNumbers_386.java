package HighFrequence.Summary;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;

        for (int i = 1; i <= n; i++) {
            list.add(curr);

            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }

        }
        return list;
    }

//The basic idea is to find the next number to add.
//Take 45 for example: if the current number is 45, the next one will be 450 (450 == 45 * 10)(if 450 <= n), or 46 (46 == 45 + 1) (if 46 <= n) or 5 (5 == 45 / 10 + 1)(5 is less than 45 so it is for sure less than n).
//We should also consider n = 600, and the current number = 499, the next number is 5 because there are all "9"s after "4" in "499" so we should divide 499 by 10 until the last digit is not "9".
//It is like a tree, and we are easy to get a sibling, a left most child and the parent of any node.

    //Simple Java DFS Solution
    public List<Integer> lexicalOrderSec(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res) {
        if (cur > n)
            return;
        else {
            res.add(cur);
            for (int i = 0; i < 10; ++i) {
                if (10 * cur + i > n)
                    return;
                dfs(10 * cur + i, n, res);
            }
        }
    }
}
