package HighFrequence.Summary;

public class SearchInsertPosition_35 {
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    //could be neater.
    public int searchInsertSec(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2; // low<=mid, mid<high
            if (nums[mid] >= target) high = mid; // high always decreases (even high-low==1)
            else low = mid + 1; // low always increases
        }
        return low;
    }
}
