package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagram {
    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length()-1) {
                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) +1);
                }
            }
        }
        return resultIndices;
    }
}
