import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution29 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length ==0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        //对于出栈序列的每个元素
        for (int i = 0; i < popA.length; i++) {
            int j =0;
            if(stack.isEmpty()) {
                int idx = indexOf(pushA,popA[i]);
                if (idx < 0) return false;
                for(j =0; j <= indexOf(pushA,popA[i]); j++) {
                    stack.push(pushA[j]);
                }
                stack.pop();
            }else if(popA[i] != stack.peek()) {
                //在剩余的pushA数组找到元素的下标j，直接push
                for(j = j + 1; j < pushA.length; j++) {
                    //找到了，直接push,pop
                    //找不到，就返回fasle;
                    int idx = indexOf(pushA,popA[i]);
                    if(idx < 0 || idx < j+1) return false;
                    else {
                        stack.push(pushA[idx]);
                        stack.pop();
                    }
                }
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private int indexOf(int[] pushA, int j) {
        int idx;
        for(idx = 0; idx < pushA.length; idx++) {
            if(j == pushA[idx])
                return idx;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] pushA= new int[] {1,2,3,4,5};
        int [] popA= new int[] {4,5,3,2,1};



    }
}

//import java.util.ArrayList;
//        import java.util.Stack;
//public class Solution {
//    public boolean IsPopOrder(int [] pushA,int [] popA) {
//        if(pushA.length ==0 || popA.length == 0)
//            return false;
//
//        Stack<Integer> stack = new Stack<>();
//
//        int oldidx = 0;
//        int idx = 0;
//        //遍历出栈的每个元素
//        for (int i = 0; i < popA.length; i++) {
//            //1。stack是空
//            if(stack.isEmpty()) {
//                idx = indexOf(pushA,popA[i]);
//                if (idx < 0) return false;
//                for(int j =0; j <= idx; j++) {
//                    stack.push(pushA[j]);
//                }
//                //2.栈非空，当前的pop栈 ！= 栈顶且push栈没有完
//            }else if(popA[i] != stack.peek()) {
//                //在剩余的pushA数组找到元素的下标j，直接push
//                idx = indexOf(pushA,popA[i]);
//                if(idx < 0) return false;
//                for(int j = oldidx+1; j <= idx; j++) {
//                    //找到了，直接push,pop
//                    //找不到，就返回fasle;
//                    stack.push(pushA[j]);
//                }
//            }
//            stack.pop();
//            oldidx = idx;
//        }
//        return stack.isEmpty();
//    }
//
//    private int indexOf(int[] pushA, int j) {
//        int idx;
//        for(idx = 0; idx < pushA.length; idx++) {
//            if(j == pushA[idx])
//                return idx;
//        }
//        return -1;
//    }
//}
//
