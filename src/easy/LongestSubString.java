package easy;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubString {

    public static void main(String[] args) {
        String str = "cbbebi";
        longestSubstringKDistinct(str, 3);
        System.out.println("answer " + longestSubstringKDistinct(str, 3));
    }

    public static int longestSubstringKDistinct(String str, int k) {
            if (str == null || str.length() == 0)
                throw new IllegalArgumentException();

            HashMap<Character, Integer> map = new HashMap<>();
            int maxLength = 0;
            int currLength = 0;
            int windowStart = 0;

            for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
                char endChar = str.charAt(windowEnd);
                char startChar = str.charAt(windowStart);

                while (map.size() >= k) {
                    maxLength = Math.max(currLength, maxLength);
                    if (map.get(startChar) > 1) {
                        map.put(endChar, map.get(endChar) - 1);
                    } else {
                        map.remove(startChar);
                    }
                    currLength--;
                }

                if (!map.containsKey(endChar)) {
                    map.put(endChar, 1);
                } else {
                    map.put(endChar, map.get(endChar) + 1);
                }

                currLength++;
                System.out.println(map);
            }

            return maxLength;
        }
}
