package website.wang;

/**
 * 快速排序
 * <p>
 * 快速排序是由东尼·霍尔所发展的一种排序算法。
 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 * 快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 * <p>
 * 快速排序为什么快:
 * 快速排序的最坏运行情况是 O(n²)，比如说顺序数列的快排。
 * 但它的平摊期望时间是 O(nlogn)，且 O(nlogn) 记号中隐含的常数因子很小，比复杂度稳定等于 O(nlogn) 的归并排序要小很多。
 * 所以，对绝大多数顺序性较弱的随机数列而言，快速排序总是优于归并排序。
 * <p>
 * 1、从数列中挑出一个元素，称为 “基准”（pivot）
 * 2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * @author: luu
 * @date: 2021-02-01 09:51
 **/
public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                // 交换
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                // 移动指针
                index++;
            }
        }
        // 交换
        int temp = arr[pivot];
        arr[pivot] = arr[index - 1];
        arr[index - 1] = temp;
        return index - 1;
    }

}
