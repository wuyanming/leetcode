package Amazon20180831;

import java.util.*;

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;

    }


    //Just in case the interviewer asks ;-) Here's an iterative version that works for duplicate values.
    //(Below, duplicate values must be on the left side of a node. If it needs to be on right side, then just switch the > and >= signs.)
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode prev = null;
            boolean onRightSideOfPrev = false;

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (prev != null && ((!onRightSideOfPrev && prev.val > root.val) || (onRightSideOfPrev && prev.val >= root.val))) {
                    return false;
                }
                prev = root;
                root = root.right;
                onRightSideOfPrev = root == null ? false : true;
            }

            return true;
        }
    }


    //Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }
}
