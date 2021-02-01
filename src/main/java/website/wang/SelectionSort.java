package website.wang;

/**
 * 选择排序
 * <p>
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 工作原理：
 * 1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 2、然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3、以此类推，直到所有元素均排序完毕。
 *
 * @author: luu
 * @date: 2021-01-31 21:39
 **/
public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}
