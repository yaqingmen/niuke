package TestUtil;

import java.util.LinkedList;

import java.util.Queue;


public class Solution41_2 {
    public static void main(String[] args) {
        Solution41_2 t = new Solution41_2();
        t.Insert('g');
        t.Insert('o');
        t.Insert('o');

        System.out.println(t.FirstAppearingOnce());

    }

    private int[] cnts = new int[256];
    Queue<Character> queue = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
       cnts[ch]++;
       queue.offer(ch);
       while(!queue.isEmpty() && cnts[queue.peek()] > 1)
           queue.poll();
    }

    public char FirstAppearingOnce(){
        return queue.isEmpty()? '#' : queue.peek();
    }
}
