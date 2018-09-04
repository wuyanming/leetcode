package HighFrequence.Summary;

public class JumpGame_55 {
    //Approach 4: Greedy
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
    //Time complexity : O(n)O(n). We are doing a single pass through the nums array, hence nn steps, where nn is the length of array nums.
    //Space complexity : O(1)O(1). We are not using any extra memory.
}
