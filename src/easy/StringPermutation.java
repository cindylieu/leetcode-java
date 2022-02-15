package easy;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("ggacba", "aabc"));
    }

    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0;
        int match = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0)
                    match++;
            }

            if (match == map.size())
                return true;

            if (windowEnd >= pattern.length()-1) {
                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                        match--;
                    map.put(leftChar, map.get(leftChar)+1);
                }
            }
        }
        return false;
    }
}
