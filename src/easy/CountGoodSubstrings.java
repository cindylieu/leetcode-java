package easy;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSubstrings {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz")); // 1
        System.out.println(countGoodSubstrings("aababcabc")); // 4
        System.out.println(countGoodSubstrings2("xyzzaz")); // 1
        System.out.println(countGoodSubstrings2("aababcabc")); // 4
    }

    //10 ms	 37.1 MB
    public static int countGoodSubstrings(String s) {

        int windowStart = 0;
        int distinct = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);

            if (windowEnd - windowStart + 1 == 3) {
                if (map.size() == 3) {
                    distinct++;
                }

                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar)-1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                windowStart++;
            }
        }

        return distinct;
    }

    //2 ms	42.4 MB
    public static int countGoodSubstrings2(String s) {
        int r = 0;

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1) && s.charAt(i-1) != s.charAt(i-2) && s.charAt(i) != s.charAt(i-2)) {
                r++;
            }
        }
        return r;
    }
}
