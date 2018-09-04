package HighFrequence.Summary;

public class ReverseWordsinaString_III_557 {
    //Approach #1 Simple Solution[Accepted]
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
    //Complexity Analysis
    //Time complexity : O(n)O(n). where nn is the length of the string.
    //
    //Space complexity : O(n)O(n). resres of size nn is used.
}
