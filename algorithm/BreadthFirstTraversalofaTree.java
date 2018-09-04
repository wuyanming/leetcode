package BasicConcepts;

//Level Order Tree Traversal
public class BreadthFirstTraversalofaTree {
    // Recursive Java program for level order traversal of Binary Tree
    /* Class containing left and right child of current
       node and key value*/
    int data;
    BreadthFirstTraversalofaTree left, right;

    public BreadthFirstTraversalofaTree(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    // Root of the Binary Tree
    BreadthFirstTraversalofaTree root;

    public BinaryTree() {
        root = null;
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(BreadthFirstTraversalofaTree root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel(BreadthFirstTraversalofaTree root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BreadthFirstTraversalofaTree(1);
        tree.root.left = new BreadthFirstTraversalofaTree(2);
        tree.root.right = new BreadthFirstTraversalofaTree(3);
        tree.root.left.left = new BreadthFirstTraversalofaTree(4);
        tree.root.left.right = new BreadthFirstTraversalofaTree(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }
}
