package website.wang;

import java.util.Arrays;

/**
 * 桶排序
 * <p>
 * 桶排序是计数排序的升级版。
 * 它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 为了使桶排序更加高效，我们需要做到这两点：
 * - 在额外空间充足的情况下，尽量增大桶的数量
 * - 使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
 * 同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。
 * <p>
 * 1、设置一个定量的数组当作空桶；
 * 2、遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 3、对每个不是空的桶进行排序；
 * 4、从不是空的桶里把排好序的数据拼接起来。
 *
 * @author: luu
 * @date: 2021-02-01 13:58
 **/
public class BucketSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        // 设定桶的数量
        int bucketSize = arr.length / 3;
        // 获取最大最小值
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        // 计算桶的index值
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int item : arr) {
            int index = (item - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], item);
        }
        // 回写数据
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了快速排序
            QuickSort quickSort = new QuickSort();
            bucket = quickSort.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    /**
     * 扩容
     */
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

}
