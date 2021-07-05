package easy;

import java.util.HashMap;

public class PalindromeNumber {

    //Given an integer x, return true if x is palindrome integer.
    //An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

    public static void main(String[] args) {
        //true
        System.out.println(palindromeNumber(1));
        System.out.println(palindromeNumber(121));

        //false
        System.out.println(palindromeNumber(1231));
        System.out.println(palindromeNumber(-1231));
    }

    public static boolean palindromeNumber(int x) {
        if (x < 0) return false; // if negative return false
        if (x <= 9) return true; // if single digit return true

        int num = x;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = (reversed * 10) + digit;
            num /= 10;
        }

        return reversed == x;
    }
}
