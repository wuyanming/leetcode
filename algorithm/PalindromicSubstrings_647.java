package HighFrequence.Summary;

public class PalindromicSubstrings_647 {
    //Approach #1: Expand Around Center [Accepted]
    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;

        for (int center = 0; center <= 2 * N - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }

        return ans;
    }
    //Time Complexity: O(N^2)O(N2) where NN is the length of S. Each expansion might do O(N)O(N) work.
    //Space Complexity: O(1)O(1).



    //Approach #2: Manacher's Algorithm [Accepted]
    public int countSubstringsSec(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c : S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v : Z) ans += (v + 1) / 2;
        return ans;
    }
    //Time Complexity: O(N)O(N) where NN is the length of S. As discussed above, the complexity is linear.
    //Space Complexity: O(N)O(N), the size of A and Z.
}
