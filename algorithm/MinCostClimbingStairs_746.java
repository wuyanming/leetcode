package HighFrequence.Summary;

public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;

        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
    //Time Complexity: O(N)O(N) where NN is the length of cost.
    //Space Complexity: O(1)O(1), the space used by f1, f2.
}
