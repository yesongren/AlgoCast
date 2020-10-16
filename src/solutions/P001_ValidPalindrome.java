package solutions;

/**
 * Created by yesongren on 2020/10/16
 * 125. Valid Palindrome
 */
public class P001_ValidPalindrome {
    private boolean isPalindrome(String s) {
        //空串也是回文串
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) { //小于等于也对
            //当遍历到非字母或数字的字符，跳过
            while (i < j && !isAlphanumeric(s.charAt(i))) ++i;
            while (i < j && !isAlphanumeric(s.charAt(j))) --j;
            if (!isEqualIgnoreCase(s.charAt(i), s.charAt(j))) return false; //一定要先判断是否相等，然后再自增i, j
            ++i;
            --j;
        }
        return true;
    }
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    private boolean isEqualIgnoreCase(char c1, char c2) {
        // ASCII码表中，小写字母比相应大写字母大32
        if (c1 >= 'A' && c1 <= 'Z') c1 += 32;
        if (c2 >= 'A' && c2 <= 'Z') c2 += 32;
        return c1 == c2;
    }
}
