package TestUtil;

import java.util.PriorityQueue;

public class Solution41 {
    public static void main(String[] args) {
        Solution41 t = new Solution41();
        t.Insert(1);
        t.Insert(2);
        t.Insert(3);
        t.Insert(4);
        t.Insert(12);
        t.Insert(5);
        t.Insert(6);
        System.out.println(t.GetMedian());
    }
    //大顶堆存左侧元素，
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
    //小顶堆存右侧元素，且小顶堆所有元素比大堆大
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //数据流中数字的数量
    private int N = 0;

    public void Insert(Integer num) {
        if(N % 2 ==0) {
            //如果是偶数，放到大堆，因为小堆所有元素比大堆大，先放小堆，再冒出最小值放入大堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            //如果是奇数，放到小堆，因为小堆所有元素比大堆大，先放大堆，再冒出最大值放入小堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        N++;
    }
    public Double GetMedian(){
            return N % 2 == 0 ? (maxHeap.peek()+minHeap.peek())/2.0 : maxHeap.peek()*1.0;
    }

}
