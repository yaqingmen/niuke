package huawei;

import java.util.*;

public class filterAndSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (sc.hasNext()) {
            TreeSet<Integer> res = new TreeSet<>();
            for (int i = 0; i < num; i++) {
                res.add(sc.nextInt());
            }


            //输出
//        for(Iterator iter = res.iterator(); iter.hasNext();){
//            System.out.println(iter.next());
//        }
            for (Integer n : res) {
                System.out.println(n);
            }
        }

    }
}
