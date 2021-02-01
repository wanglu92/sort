package website.wang;

/**
 * 计数排序
 * <p>
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * <p>
 * 1、找出待排序的数组中最大和最小的元素；
 * 2、统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 3、对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 4、反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 *
 * @author: luu
 * @date: 2021-02-01 12:55
 **/
public class CountingSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        // 获取最大最小值
        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        // 统计
        int[] save = new int[max - min + 1];
        for (int value : arr) {
            save[value - min] += 1;
        }
        // 回写
        int index = 0;
        for (int i = 0; i < save.length; i++) {
            while (save[i] != 0) {
                arr[index] = i + min;
                index++;
                save[i] -= 1;
            }
        }
        return arr;
    }

}
