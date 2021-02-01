import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import website.wang.*;

import java.util.Arrays;

/**
 * @author: luu
 * @date: 2021-01-31 21:23
 **/
public class SortTest {

    private int[] arr;
    private int[] result;

    @Before
    public void init() {
        this.arr = new int[]{3, 2, 5, 7, 9, 8, 10, 1, 1, 3, 2, 4, 6, 4, 5};
        // 设置结果
        this.result = getArr();
        Arrays.sort(this.result);
    }

    @Test
    public void bubbleSortTest() {
        Sort sort = new BubbleSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void selectionSortTest() {
        Sort sort = new SelectionSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void insertionSortTest() {
        Sort sort = new InsertionSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void shellSortTest() {
        Sort sort = new ShellSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void mergeSortTest() {
        Sort sort = new MergeSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void quickSortTest() {
        Sort sort = new QuickSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void heapSortTest() {
        Sort sort = new HeapSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void countingSortTest() {
        Sort sort = new CountingSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void bucketSortTest() {
        Sort sort = new BucketSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    @Test
    public void radixSortTest() {
        Sort sort = new RadixSort();
        int[] sort1 = sort.sort(getArr());
        System.out.println(JSONObject.toJSONString(sort1));
        Assert.assertEquals(JSONObject.toJSONString(this.result), JSONObject.toJSONString(sort1));
    }

    private int[] getArr() {
        return Arrays.copyOf(this.arr, this.arr.length);
    }

}
