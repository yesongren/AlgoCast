package solutions;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/10/26
 * 268. Missing Number
 */
public class P015_MissingNumber {
    /*
        public int missingNumberXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        for (int i = 0; i <= nums.length; i++) {
            res ^= i;
        }
        return res;
    }
    */
    public int missingNumberXOR(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            res ^= nums[i] ^ i;
        }
        return res ^ n;
    }

    public int missingNumberBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low >> 1);
            if (nums[mid] > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
