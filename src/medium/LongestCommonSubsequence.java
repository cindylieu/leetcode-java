package medium;

public class LongestCommonSubsequence {
    // Given two strings text1 and text2, return the length of their longest common subsequence.
    // If there is no common subsequence, return 0.
    //
    // A subsequence of a string is a new string generated from the original string with some characters (can be none)
    // deleted without changing the relative order of the remaining characters.
    //
    // For example, "ace" is a subsequence of "abcde".
    // A common subsequence of two strings is a subsequence that is common to both strings.

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        if (text1.isEmpty() || text2.isEmpty() || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        return lcs(text1, text2, text1.length(), text2.length());

    }

    public static int lcs(String text1, String text2, int len1, int len2) {

        int row = len1 + 1;
        int col = len2 + 1;
        int i, j;

        int[][] dp = new int[row][col];

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++ ) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static int max (int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
