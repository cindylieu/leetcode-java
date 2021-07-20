package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }

    List<String> result = new ArrayList<>();
    int input;
    int max;

     List<String> generateParenthesis(int n) {
        input = n;
        max = 2*n;

        helper("", 0, 0);

        return result;
    }

    void helper(String s, int open, int close) {
        if (s.length() == max) {
            result.add(s);
            return;
        }

        if (open < input) {
            helper(s + "(", open + 1, close);
        }

        if (close < open) {
            helper(s + ")", open, close + 1);
        }
    }
}
