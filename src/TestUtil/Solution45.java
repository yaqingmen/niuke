package TestUtil;

import java.util.Arrays;

public class Solution45 {
    public static void main(String[] args) {
        Solution45 t = new Solution45();
        int[] numbers = new int[]{3,32,321};
        System.out.println(t.PrintMinNumber(numbers));

    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for(int i = 0; i < n ;i++) {
            nums[i] = numbers[i] + "";
        }
        String ret = "";
        Arrays.sort(nums,(o1,o2) -> (o1 + o2).compareTo(o2 + o1));
        for(String val : nums){
            //对nums 字符串数组排序
            ret += val;
        }
        return ret;
    }

}
