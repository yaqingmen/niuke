package huawei;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] strs = sc.nextLine().toCharArray();
        //构造count数组
        int[] count = new int[256];
        for(char str : strs){
            count[str]++;
        }
        char[] N = sc.nextLine().toCharArray();
        int res = 0;
        for(int i = 0; i < strs.length; i++){
            //存在
            if(N[0] == strs[i] || (N[0] - strs[i] == 32) || (strs[i] - N[0] == 32)){
                //如果是字母
                if((N[0] >= 65 && N[0] <= 90)){
                    res = count[N[0]] + count[N[0] + 32];
                }else if((N[0] >= 97 && N[0] <= 122)){
                    res = count[N[0]] + count[N[0] - 32];
                }else{
                    res = count[N[0]];
                }

            }
        }
        System.out.println(res);

    }
}
