package TestUtil;

public class Solution46 {
    public static void main(String[] args) {
        String s = "12258";
        //System.out.println(s.substring(1,3));

        Solution46 t = new Solution46();
        System.out.println(t.numDecodings("12258"));

    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0)
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '0')
                continue;
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }


}
