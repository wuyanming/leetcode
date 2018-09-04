package HighFrequence.Summary;

public class MaxIncreasetoKeepCitySkyline807 {
//The skyline looking from the top is col_maxes = [max(column_0), max(column_1), ...].
//Similarly, the skyline from the left is row_maxes [max(row_0), max(row_1), ...]
//In particular, each building grid[r][c] could become height min(max(row_r), max(col_c)),
//and this is the largest such height. If it were larger, say grid[r][c] > max(row_r),
//then the part of the skyline row_maxes = [..., max(row_r), ...] would change.
//These increases are also independent (none of them change the skyline), so we can perform them independently.
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMaxes = new int[N];
        int[] colMaxes = new int[N];

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
            }

        int ans = 0;

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                ans += Math.min(rowMaxes[r], colMaxes[c])   - grid[r][c];

        return ans;
    }

    //Time Complexity: O(N^2)O(N2), where NN is the number of rows (and columns) of the grid. We iterate through every cell of the grid.
    //Space Complexity: O(N)O(N), the space used by row_maxes and col_maxes.
}
