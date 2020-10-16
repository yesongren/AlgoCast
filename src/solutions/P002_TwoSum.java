package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2020/10/16
 * 001. Two Sum
 */
public class P002_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[] {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
