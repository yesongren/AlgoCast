package solutions;

/**
 * Created by yesongren on 2020/10/18
 * 136. Single Number
 */
public class P006_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
