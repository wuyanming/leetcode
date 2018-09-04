package Amazon20180831;

public class LowestCommonAncestorofaBinaryTree_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }


    //Expanded the last line to be more readable.
    public static TreeNode lowestCommonAncestor_Second(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor_Second(root.left, p, q);
        TreeNode right = lowestCommonAncestor_Second(root.right, p, q);

        //result
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else { //both left and right are not null, we found our result
            return root;
        }
    }
}
