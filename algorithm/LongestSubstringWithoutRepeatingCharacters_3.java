package Amazon20180831;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    //Approach 3: Sliding Window Optimized
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    //Java (Assuming ASCII 128)
    //The previous implements all have no assumption on the charset of the string s.
    //If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
    //Commonly used tables are:
    //
    //int[26] for Letters 'a' - 'z' or 'A' - 'Z'
    //int[128] for ASCII
    //int[256] for Extended ASCII
    public int lengthOfLongestSubstring_Second(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    //Time complexity : O(n)O(n). Index jj will iterate nn times.
    //Space complexity (HashMap) : O(min(m, n))O(min(m,n)). Same as the previous approach.
    //Space complexity (Table): O(m)O(m). mm is the size of the charset.
}
