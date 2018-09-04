package HighFrequence.Summary;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    //Approach 1: Simulation
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, direction = 0;

        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[direction];
            int cc = c + dc[direction];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                direction = (direction + 1) % 4;
                r += dr[direction];
                c += dc[direction];
            }
        }

        return ans;
    }
    //Complexity Analysis
    //
    //Time Complexity: O(N)O(N), where NN is the total number of elements in the input matrix. We add every element in the matrix to our final answer.
    //
    //Space Complexity: O(N)O(N), the information stored in seen and in ans.



    //Approach 2: Layer-by-Layer
    public List<Integer> spiralOrderSec(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
    //Complexity Analysis
    //
    //Time Complexity: O(N)O(N), where NN is the total number of elements in the input matrix. We add every element in the matrix to our final answer.
    //
    //Space Complexity: O(N)O(N), the information stored in ans.
}
