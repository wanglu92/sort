package website.wang;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 归并排序是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列。
 * 即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2路归并。
 * <p>
 * 1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * 2、设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * 3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * 4、重复步骤 3 直到某一指针达到序列尾；
 * 5、将另一序列剩下的所有元素直接复制到合并序列尾。
 *
 * @author: luu
 * @date: 2021-01-31 23:54
 **/
public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] left = sort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] right = sort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        return MergeSort.merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index = 0;
        int indexLeft = 0;
        int indexRight = 0;
        while (indexLeft < left.length && indexRight < right.length) {
            if (left[indexLeft] < right[indexRight]) {
                result[index] = left[indexLeft];
                indexLeft += 1;
            } else {
                result[index] = right[indexRight];
                indexRight += 1;
            }
            index += 1;
        }
        while (indexLeft < left.length) {
            result[index] = left[indexLeft];
            indexLeft += 1;
            index += 1;
        }
        while (indexRight < right.length) {
            result[index] = right[indexRight];
            indexRight += 1;
            index += 1;
        }
        return result;
    }

}
