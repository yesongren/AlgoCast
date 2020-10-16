package solutions;

/**
 * Created by yesongren on 2020/10/16
 * 167. Two Sum II - Input array is sorted
 */
public class P003_TwoSum2_InputArrayIsSorted {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) return new int[]{i + 1, j + 1};
            else if (nums[i] + nums[j] > target) --j;
            else ++i;
        }
        return new int[]{-1, -1};
    }
}
