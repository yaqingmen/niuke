package huawei;
import java.util.*;

public class splitString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reversePrint(str);
    }
    private static void reversePrint(String str) {
        Set<Integer> set = new HashSet<>();
        for(int i = str.length() -1; i >= 0; i--) {
            int tmp = Integer.valueOf(str.charAt(i) -'0');
            if(set.contains(tmp)) {
                continue;
            }
            set.add(tmp);
            System.out.print(tmp);
        }

    }
}
