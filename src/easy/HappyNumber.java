package easy;

public class HappyNumber {
    public static void main(String[] args) {
        //true
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        // check n < 10, return false is n < 10
        // separate the digits of n
        // n % 10
        // n = n / 10
        // add each digit
        // repeat until result is 1
        if (n < 10) {
            return false;
        }
        int result = 0;
        int count = 0;
        while (result != 1) {
            while (count <- 50) {
                result = 0;
                while (n != 0) {
                    int i = n % 10;
                    result += i*i;
                    n /= 10;
                }
                n = result;
                count++;
            }
            return false;
        }
        return true;
    }
}
