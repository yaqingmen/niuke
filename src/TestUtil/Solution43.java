package TestUtil;

public class Solution43 {
    public static void main(String[] args) {
        Solution43 t = new Solution43();
        int res = t.NumberOf1Between1AndN_Solution(13);
        System.out.println(res);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ones;

    }
}
