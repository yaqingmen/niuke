package TestUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution38 {
    public static void main(String[] args) {
        Solution38 t = new Solution38();
        ArrayList<String> list = new ArrayList<>();
        list = t.Permutation("abc");
        System.out.println("befor sort:  "+ list);
        Collections.sort(list);
        System.out.println("after sort:  "+list);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.length() > 0 || str != null) {
            char[] chars = str.toCharArray();
            helper(0,chars,list);
        }
        return list;
    }
    public void helper(int begin, char[] chars, ArrayList<String> list) {
        // 递归终止条件
        if(begin == chars.length){
            String val = String.valueOf(chars);
            if(!list.contains(val))
                list.add(val);
        }else{
            for(int i = begin; i < chars.length; i++) {
                swap(chars,i,begin);
                helper(begin+1, chars,list);
                swap(chars,i,begin);
            }
        }

    }
    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
