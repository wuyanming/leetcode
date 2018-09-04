package Amazon20180831;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    //If you use set,you can find the element in O(1).But if you use List,you may find the element in O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
