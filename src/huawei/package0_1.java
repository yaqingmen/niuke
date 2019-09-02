package huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class package0_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();//总钱数
            int n = sc.nextInt();//总个数
            int[] v = new int[n];//价格
            int[] p = new int[n];//价值
            int[] q = new int[n];//主/附件
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
                p[i] = sc.nextInt() * v[i];//价值=价格*重要度
                q[i] = sc.nextInt();
            }
            System.out.println(getMaxValue1(n,m,v,p,q));

    }

    public static int getMaxValue(int n, int m, int[] v, int[] p, int[] q) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int curPrice = v[i - 1], curValue = p[i - 1]; //dp[i]是前i前物品，所以物品编号(0,i-1)
                //如果是主件
                if (q[i - 1] == 0) {
                    if (j >= curPrice) {
                        //装得下
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - curPrice] + curValue);
                    }
                } else {
                    if (j >= curPrice + v[q[i - 1]]) {
                        //装得下
                        dp[i][j] = dp[i - 1][j - curPrice] + curValue;
                    }
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 计算前n件物品，体积/价格不超过m的最大价值
     * @param n 总物品数
     * @param m 体积/价格
     * @param weights 权重/价格
     * @param values 价值 价值的定义需要从题目查找如=价格 * 重要程度
     * @param q 主件还是附件
     * @return 最大价值
     */
    public static int getMaxValue1(int n, int m, int[] weights, int [] values, int [] q) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //主件
                if (q[i - 1] == 0) {
                    if (j >= weights[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                    }
                }else {
                    if (j >= weights[i - 1] + weights[q[i - 1]]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
