package HighFrequence.Summary;

public class NextPermutation31 {
    //Approach 2: Single Pass Approach
    //Time complexity : O(n)O(n). In worst case, only two scans of the whole array are needed.
    //Space complexity : O(1)O(1). No extra space is used. In place replacements are done.

    //https://leetcode.com/problems/next-permutation/solution/

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] < num[i]. So, elements from num[i] to num[n-1] is reversely sorted.
    //To find the next permutation, we have to swap some numbers at different positions, to minimize the increased amount, we have to make the highest changed position as high as possible. Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted. So, we want to increase the number at index i-1, clearly, swap it with the smallest number between num[i,n-1] that is larger than num[i-1]. For example, original number is 121543321, we want to swap the '1' at position 2 with '2' at position 7.
    //The last step is to make the remaining higher position part as small as possible, we just have to reversely sort the num[i,n-1]
    class Solution {
        public void nextPermutation(int[] num) {
            int n = num.length;
            if (n < 2)
                return;
            int index = n - 1;
            while (index > 0) {
                if (num[index - 1] < num[index])
                    break;
                index--;
            }
            if (index == 0) {
                reverseSort(num, 0, n - 1);
                return;
            } else {
                int val = num[index - 1];
                int j = n - 1;
                while (j >= index) {
                    if (num[j] > val)
                        break;
                    j--;
                }
                swap(num, j, index - 1);
                reverseSort(num, index, n - 1);
                return;
            }
        }

        public void swap(int[] num, int i, int j) {
            int temp = 0;
            temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }

        public void reverseSort(int[] num, int start, int end) {
            if (start > end)
                return;
            for (int i = start; i <= (end + start) / 2; i++)
                swap(num, i, start + end - i);
        }
    }
}
