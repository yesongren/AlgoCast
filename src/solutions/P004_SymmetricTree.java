package solutions;

import common.TreeNode;

/**
 * Created by yesongren on 2020/10/16
 * 101. Symmetric Tree
 */
public class P004_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null) return false;  // if (t1 == null && t2 != null)
        if (t2 == null) return false;
        //在递归判断过程中存在短路现象，也就是做“与”操作时，如果前面的值返回 false 则后面的不再进行计算
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
