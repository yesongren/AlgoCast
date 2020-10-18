package solutions;

/**
 * Created by yesongren on 2020/10/18
 * 371. Sum of Two Integers
 */
public class P005_SumOfTwoIntegers {
    public int getSumRecursive(int a, int b) {
        return b == 0 ? a : getSumRecursive(a ^ b, (a & b) << 1);
    }

    // Time: O(m), Space: O(1)
    public int getSumIterative(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
