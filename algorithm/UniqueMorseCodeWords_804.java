package HighFrequence.Summary;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_804 {
    //Approach #1: Hash Set [Accepted]
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> seen = new HashSet();

        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char c : word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }

        return seen.size();
    }
    //Complexity Analysis
    //Time Complexity: O(S)O(S), where SS is the sum of the lengths of words in words.
    //We iterate through each character of each word in words.
    //
    //Space Complexity: O(S)O(S).
}
