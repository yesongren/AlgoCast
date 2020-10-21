package solutions;

/**
 * Created by yesongren on 2020/10/20
 * 647. Palindromic Substrings
 */
public class P012_PalindromicSubstrings {
    public int countSubstringsDP(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), cnt = 0;
        boolean[][] f = new boolean[n][n];
        int i, j;
        for (i = n - 1; i >= 0; --i) {
            for (j = i; j < n; ++j) {
                if (i == j) f[i][j] = true;
                else if (i + 1 == j) f[i][j] = s.charAt(i) == s.charAt(j);
                else f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];

                if (f[i][j]) cnt++;
            }
        }
        return cnt;
    }


    public int countSubstringsExpand(String s) {
        if (s == null || s.length() == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += expandAndCount(s, i, i);
            cnt += expandAndCount(s, i, i + 1);
        }
        return cnt;
    }

    private int expandAndCount(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
