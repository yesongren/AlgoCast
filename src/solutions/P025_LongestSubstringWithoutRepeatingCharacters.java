package solutions;

/**
 * Created by yesongren on 2021/2/18
 * 003. Longest Substring Without Repeating Characters
 */
public class P025_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (s.equals("") || n == 0) return 0;
        int start = 0, maxLen = 0;
        int[] map = new int[256];
        for (int end = 0; end < n; end++) {
            map[s.charAt(end)]++;
            while (map[s.charAt(end)] > 1) {
                map[s.charAt(start)]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
