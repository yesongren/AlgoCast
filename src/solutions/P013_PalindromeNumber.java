package solutions;

/**
 * Created by yesongren on 2020/10/21
 * 009. Palindrome Number
 */
public class P013_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        long y = 0;
        while (tmp != 0) {
            int num = tmp % 10;
            y = y * 10 + num;
            tmp = tmp / 10;
        }
        return y == x;
    }

    public boolean isPalindromeString(int x) {
        String str = String.valueOf(x);
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
