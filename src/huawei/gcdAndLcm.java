package huawei;

import java.util.Scanner;

public class gcdAndLcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(get_lcm(a,b));

    }

    /**
     * 两个数的最大公约数（递归写法）
     * @param a
     * @param b
     * @return 最大公约数
     */
    public static int get_gcd(int a, int b) {
        int max = (a > b) ? a : b;
        int min = (a < b) ? a : b;

        if(max % min != 0) {
            return get_gcd(min, max % min);
        }else{
            return min;
        }
    }

    /**
     * 两个数的最大公约数（非递归写法）
     * @param a
     * @param b
     * @return
     */
    public static int get_gcd1(int a, int b) {
        //最大公约数
        int gcd = 0;

        //保证a是大数
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        //特殊
        if(a % b == 0){
            gcd = b;
        }

        while (a % b > 0) {
            a = a % b;   //余数和商辗转相除法

            //交换
            //保证a是大数
            if(a < b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            //特殊
            if(a % b == 0){
                gcd = b;
            }

        }
        return gcd;
    }

    /**
     * 两数最小公倍数=两数积除以最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int get_lcm(int a, int b) {
        return a * b /get_gcd(a,b);
    }


}
