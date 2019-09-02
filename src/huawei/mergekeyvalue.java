package huawei;

import java.util.Scanner;

public class mergekeyvalue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] res = new int[num];
        //输入
        for(int i = 0; i < num;i++) {
            int idx = sc.nextInt();
            int value = sc.nextInt();
            if(res[idx] != 0) {
                res[idx]+= value;
            }else{
                res[idx] = value;
            }
        }
        //输出
        for(int i = 0; i<num;i++){
            if(res[i] != 0){
                System.out.println(i+" "+res[i]);
            }
        }
    }
}
