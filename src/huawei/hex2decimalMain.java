package huawei;

import org.junit.Test;

import java.util.Scanner;

public class hex2decimalMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine().substring(2);
//            System.out.println(Integer.parseInt(str, 16));
        }
    }
    public int hex2Deci(String s){
        int sum = 0;
        int count = 0;

        while(count < s.length()) {
            //当前位的幂次
            int mi = s.length() - count - 1;
            //当前字符
            char ch = s.charAt(count);
            int tmp = 0;
            if (ch >= '0' && ch <= '9') {
                tmp = ch - '0';
            } else if (ch >= 'A' && ch <= 'Z') {
                tmp = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'z') {
                tmp = ch - 'a' + 10;
            }
            sum += tmp * Math.pow(16,mi);
            count++;
        }
        return sum;
    }

    @Test
    public void testHex2deci(){
//        hex2decimalMain test = new hex2decimalMain();
//        System.out.println(test.hex2Deci("3ab"));
//        StringBuilder s =  new StringBuilder();
        int k = 7,x=12;
//        System.out.println(x%=(k%=5));
//        System.out.println(x %=(k-k%5));
//        System.out.println(x %=k-k%5);
        System.out.println((x%=k)-(k%=5));
    }
}
