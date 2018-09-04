package HighFrequence.Summary;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        return true;
    }

    //The "i + 1" made me a bit confused, then realized "+1" is to exclude 0 from valid index.
    //Why not initialzing the array as -1, and simply keep i in the array. This also avoids the overflow issue.


    public boolean isIsomorphicSec(String s, String t) {
        int len = s.length();
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < 256; i++) {
            m1[i] = m2[i] = -1;
        }

        for (int i = 0; i < len; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = m2[t.charAt(i)] = i;
        }
        return true;
    }
}
