package solutions;

import common.TreeNode;

/**
 * Created by yesongren on 2021/2/17
 * 104. Maximum Depth of Binary Tree
 */
public class P022_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            res = Math.max(left, right) + 1;
        }
        return res;
    }
}
