package huawei;

import java.util.Arrays;
import java.util.Collections;

public class sortedAlgrithoms {
    private static int[] pq;

    public static void main(String[] args) {
        int[] array = new int []{2,1,4,8,1,3};
//        int [] res = bubbleSort(array);
//        int [] res = MergeSort(array);
//       QuickSort(array,0,array.length-1);
        heapSort(array);
        for(int i = 0; i < pq.length; i++) {
            System.out.print(pq[i]+" ");
        }

    }

    /**
     * 冒泡排序：每交换一轮，尾部最大数就拍好了
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        //遍历多少轮
        for (int i = 0; i < array.length; i++)
            //因为经过了i轮后面的数字已经排好序了
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }
    /**
     * 选择排序：每次都从元素中选最小的一个排到开头
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            //假设最小数是第一个
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            //最小索引更新了再交换
            if(minIndex != i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }

        }
        return array;
    }

    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            //对于不同的分组。
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;

    }
    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        //递归终止条件
        if (array.length < 2) return array;
        //一半数组
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        //将两段排序好的数组归并
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
    /**
     * 快速排序方法
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    public static void QuickSort(int[] array, int lo, int hi) {
//        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        if(hi <= lo) return ;
        int smallIndex = partition(array, lo, hi);
        QuickSort(array, lo, smallIndex - 1);
        QuickSort(array, smallIndex + 1, hi);
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(int[] array, int lo, int hi) {
        int i = lo,j = hi + 1;
        int privot = array[lo];
        while(true) {
            while(array[++i] < privot) if(i == hi) break;
            while(array[--j] > privot) if(j == lo) break;
            if(i >= j) break;
            swap(array, i, j);
        }
        swap(array,lo, j);
        return j;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 堆排序
     * @param array 待排序数组
     */
    public static void heapSort(int[] array){
        pq = new int[array.length + 1];
        for(int i = 1; i < array.length + 1; i++) {
            pq[i] = array[i - 1];
        }
        //构造堆
        int N = array.length;
        for(int k = N/2; k >= 1; k--) {
            sink(pq, k, N);
        }
        //把堆的根节点的数取出放在N，然后修复前N-1个数构成的堆
        while(N > 1) {
            swap(pq, 1, N--);
            //把根节点下沉到合适位置，注意此时N已经是N--
            sink(pq, 1, N);
        }
    }

    public static void sink(int[] array, int k, int N){
        //儿子的坐标一定要小于整体数组
        while(2 * k <= N) {
            //左儿子
            int j = 2 * k;
            //判断左儿子大还是右儿子大
            if(j < N && (array[j] < array[j + 1])) j++;
            //如果父亲不再小于最大的儿子，就跳出
            if(array[k] >= array[j]) break;
            swap(array, k, j);
            k = j;
        }
    }
}

