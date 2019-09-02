package huawei;

import org.junit.Test;

import java.util.Scanner;

public class spiltStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //遍历输入字符串
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 2;
        while (cnt-- != 0) {
            String s1 = sc.nextLine();
            if (s1.length() < 8) {
                appzero(stringBuilder, s1, 8);
            } else if (s1.length() == 8 || s1.length() % 8 == 0) {
                stringBuilder.append(s1);
            } else {
                int idx = (s1.length() / 8) * 8;
                stringBuilder.append(s1.substring(0, idx));
                appzero(stringBuilder, s1.substring(idx), 8);
            }
        }
        //按格式输出
        String s = stringBuilder.toString();
        for (int i=0; i<s.length(); i+=8) {
            System.out.println(s.substring(i, i+8));
        }

    }

    /**
     *
     * @param sb
     * @param origin
     * @param expect
     */
    public  static void appzero(StringBuilder sb, String origin, int expect){
        int err = expect - origin.length();
        sb.append(origin);
        //补0
        while(err-- != 0){
            sb.append("0");
        }
    }
    @Test
    public void testappZero(){
        spiltStrings test = new spiltStrings();
        StringBuilder sb = new StringBuilder();
        String tt = "abcdefgdg";
        test.appzero(sb,tt.substring(8),8);
        System.out.println(sb);
    }
}
