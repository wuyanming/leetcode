package HighFrequence.Summary;

public class FindtheDifference_389 {
    public char findTheDifference(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);

        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }


    public char findTheDifferenceSec(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }
}
