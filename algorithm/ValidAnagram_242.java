package StringSummary;

import java.util.Arrays;

public class ValidAnagram_242 {
    //Approach #2 (Hash Table) [Accepted]

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    //Complexity analysis
    //Time complexity : O(n)O(n). Time complexity is O(n)O(n) because accessing the counter table is a constant time operation.
    //
    //Space complexity : O(1)O(1). Although we do use extra space,
    //the space complexity is O(1)O(1) because the table's size stays constant no matter how large nn is.


    //Approach #1 (Sorting) [Accepted]
    public boolean isAnagramSec(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //Complexity analysis
    //Time complexity : O(n \log n)O(nlogn). Assume that nn is the length of ss, sorting costs O(n \log n)O(nlogn) and comparing two strings costs O(n)O(n).
    // Sorting time dominates and the overall time complexity is O(n \log n)O(nlogn).
    //
    //Space complexity : O(1)O(1). Space depends on the sorting implementation which, usually,
    //costs O(1)O(1) auxiliary space if heapsort is used. Note that in Java,
    //toCharArray() makes a copy of the string so it costs O(n)O(n) extra space, but we ignore this for complexity analysis because:
    //
    //It is a language dependent detail.
    //It depends on how the function is designed. For example, the function parameter types can be changed to char[].
}
