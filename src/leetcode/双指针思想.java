package leetcode;

public class 双指针思想 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(17));
    }

    /**
     * 判断一个数是否是两数的平方和
     * @param c
     * @return true 可以写成两个数的平和之和
     */
    public static boolean judgeSquareSum(int c) {
        int i = 0, j =(int)Math.sqrt(c);
        while(i < j) {
            int sum = i * i + j * j;
            if(sum == c){
                return true;
            }else if(sum < c) i++;
            else j--;
        }
        return false;
    }
}
