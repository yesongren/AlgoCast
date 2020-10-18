package solutions;

import common.TreeNode;

/**
 * Created by yesongren on 2020/10/19
 * 100. Same Tree
 */
public class P008_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q== null) return true;
        else if (p == null || q == null) return false;
        else return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
