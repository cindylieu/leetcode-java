package medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] s = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] s1 = new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        String[] s2 = new String[]{"eat"};
        String[] s3 = new String[]{""};
        System.out.println(groupAnagrams(s));
        System.out.println(groupAnagrams(s1));
        System.out.println(groupAnagrams(s2));
        System.out.println(groupAnagrams(s3));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        //Input: strs = ["eat","tea","tan","ate","nat","bat"]
        //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        List<List<String>> r = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        if (strs.length == 0) {
            return r;
        }

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(Arrays.toString(chars))) {
                List<String> s = new ArrayList<>();
                s.add(strs[i]);
                map.put(Arrays.toString(chars), s);
            } else {
                map.get(Arrays.toString(chars)).add(strs[i]);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            r.add(entry.getValue());
        }
        return r;
    }
}

//        for (String s : strs) {
//            int ascii = 0;
//            for (int i = 0; i < s.length(); i++) {
//                ascii += s.charAt(i);
//            }
//            if (map.containsKey(ascii)) {
//                map.get(ascii).add(s);
//            } else {
//                List<String> strings = new ArrayList<>();
//                strings.add(s);
//                map.put(ascii, strings);
//            }
//        }