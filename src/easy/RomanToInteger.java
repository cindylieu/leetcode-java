package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    // Symbol       Value
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000
    // For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    // Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
    // Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    // The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
    // I can be placed before V (5) and X (10) to make 4 and 9.
    // X can be placed before L (50) and C (100) to make 40 and 90.
    // C can be placed before D (500) and M (1000) to make 400 and 900.
    // Given a roman numeral, convert it to an integer.

    public static void main(String[] args) {
        System.out.println(romanToInteger("I"));
        System.out.println(romanToInteger("III"));
        System.out.println(romanToInteger("IV"));
        System.out.println(romanToInteger("IX"));
        System.out.println(romanToInteger("LVIII"));
        System.out.println(romanToInteger("MCMXCIV"));
    }

    public static Integer romanToInteger(String s) {
        Map<Character, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        if (s.length() == 1) return romanNumbers.get(s.charAt(0));

        Integer numberConverted = 0;

        int i = 0;

        // look ahead to next value
        while (i <= s.length()-2) {
            char cur = s.charAt(i);
            char next = s.charAt(i+1);

            if ((cur == 'I' && (next == 'V' || next == 'X')) ||
                    (cur == 'X' && (next == 'L' || next == 'C')) ||
                    (cur == 'C' && (next == 'D' || next == 'M'))) {
                numberConverted += (romanNumbers.get(next) - romanNumbers.get(cur));
                i += 2;
            } else {
                numberConverted += romanNumbers.get(cur);
                i++;
            }
        }

        if (i == s.length()-1) {
            numberConverted += romanNumbers.get(s.charAt(i));
        }

        return numberConverted;
    }

}
