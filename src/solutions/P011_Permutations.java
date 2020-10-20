package solutions;

import java.util.*;

/**
 * Created by yesongren on 2020/10/20
 * 046. Permutations
 */
public class P011_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        // 官方文档推荐用deque替代stack
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            // 由于path这个变量全程只使用一份，这里添加的只是"引用"，在深度优先遍历完成之后，path回到的是根结点成为一个空列表，所以这里添加的应该是path的一个拷贝
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; ++i) {
            if (used[i]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }

    /************* solution 2 - Recursive ***************/
    public List<List<Integer>> permuteRec(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num : nums) cur.add(num);
        perm(res, cur, 0, nums.length - 1);
        return res;
    }

    private void perm(List<List<Integer>> res, List<Integer> cur, int p, int q) {
        if (p == q) res.add(new ArrayList<>(cur));
        else {
            int i;
            for (i = p; i <= q; i++) {
                Collections.swap(cur, i, p);
                perm(res, cur, p + 1, q);
                Collections.swap(cur, i, p);
            }
        }
    }
}
