package solutions;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2020/10/26
 * 111. Minimum Depth of Binary Tree
 */
public class P016_MinimumDepthOfBinaryTree {
    public int minDepthRec(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepthRec(root.right) + 1;
        if (root.right == null) return minDepthRec(root.left) + 1;
        return Math.min(minDepthRec(root.left), minDepthRec(root.right)) + 1;
    }

    public int minDepthIter(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            depth++;
        }
        return -1;
    }
}
