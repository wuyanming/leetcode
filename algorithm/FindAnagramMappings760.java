package HighFrequence.Summary;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings760 {
    //Approach #1: Hash Table [Accepted]

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> D = new HashMap();
        for (int i = 0; i < B.length; ++i)
            D.put(B[i], i);

        int[] ans = new int[A.length];
        int t = 0;
        for (int x : A)
            ans[t++] = D.get(x);
        return ans;
    }

    //Complexity Analysis
    //Time Complexity: O(N)O(N), where NN is the length of AA.
    //Space Complexity: O(N)O(N).
}



  /*  Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

      We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

      These lists A and B may contain duplicates. If there are multiple answers, output any of them.

      For example, given

      A = [12, 28, 46, 32, 50]
      B = [50, 12, 32, 46, 28]
      We should return
      [1, 4, 3, 2, 0]
      as P[0] = 1 because the 0th element of A appears at B1, and P1 = 4 because the 1st element of A appears at B[4], and so on.
      Note:

      A, B have equal lengths in range [1, 100].
      A[i], B[i] are integers in range [0, 10^5].*/
