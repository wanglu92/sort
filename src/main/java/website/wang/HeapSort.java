package website.wang;

import com.alibaba.fastjson.JSONObject;

/**
 * 堆排序
 *
 * @author: luu
 * @date: 2021-02-01 11:00
 **/
public class HeapSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        HeapSort.buildMaxHeap(arr, arr.length);
        int len = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            len--;
            HeapSort.heapify(arr, 0, len);
        }
        return arr;
    }

    /**
     * 构建大顶堆
     */
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            HeapSort.heapify(arr, i, len);
        }
    }

    /**
     * 堆化函数
     */
    private static void heapify(int[] arr, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxIndex = i;
        if (left < len && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (i != maxIndex) {
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            HeapSort.heapify(arr, maxIndex, len);
        }
    }
}
