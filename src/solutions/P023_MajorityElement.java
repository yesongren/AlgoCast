package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2021/2/17
 * 169. Majority Element
 */
public class P023_MajorityElement {
    public int majorityElement(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            if (stack.isEmpty() || stack.peek() == num) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }
        return stack.peek();
    }
}
