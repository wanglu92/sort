package website.wang;

/**
 * 希尔排序
 * <p>
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫</b>缩小增量排序</b>。
 * <p>
 * 1、选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1
 * 2、按增量序列个数k，对序列进行k 趟排序
 * 3、每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m的子序列，分别对各子表进行直接插入排序。仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度
 * <p>
 * gap增量因子
 *
 * @author: luu
 * @date: 2021-01-31 22:29
 **/
public class ShellSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                // 这个循环里其实就是一个插入排序
                for (int j = i + gap; j < arr.length; j += gap) {
                    int k = j - gap;
                    while (k >= 0 && arr[k] > arr[k + gap]) {
                        int temp = arr[k];
                        arr[k] = arr[k + gap];
                        arr[k + gap] = temp;
                        k -= gap;
                    }
                }
            }
        }
        return arr;
    }

}
