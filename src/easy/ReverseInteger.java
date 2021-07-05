package easy;

import com.sun.jdi.request.BreakpointRequest;

import java.util.HashMap;

public class ReverseInteger {
//    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    public static void main(String[] args) {
        System.out.println(reverseInteger(-2147483412));
    }

    public static int reverseInteger(int x) {

        if (x == 0) return 0;

        int num = x;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;

            if (reversed > Integer.MAX_VALUE / 10) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10){
                return 0;
            }

            reversed = (reversed * 10) + digit;
            num /= 10;
        }

        return reversed;
    }
}
