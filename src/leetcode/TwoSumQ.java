package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumQ {
    public static void main(String[] args) {


    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[] {map.get(component), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //三数之和
}
