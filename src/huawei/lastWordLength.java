package huawei;

import java.util.Scanner;

public class lastWordLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] strs = string.split(" ");

        System.out.println(strs[strs.length-1].length());

    }
}
