package com.atguigu.springboot.controller;

public class maopao {
    public static void main(String[] args) {
        int[] x = new int[100];
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) (Math.random() * 100);
        }
        jishu1(x);
        for (int i : x) {
            System.out.print(i + "  ");
        }
    }

    public static void maopao(int[] x) {
        int length = x.length - 1, temp;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            flag = false;
            for (int j = 0; j < length - i; j++) {
                if (x[j] > x[j + 1]) {
                    flag = true;
                    temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    public static void xuanze(int[] x) {
        int length = x.length, temp;
        for (int i = 0; i < length - 1; i++) {
            int index = i, min = x[i];
            for (int j = i + 1; j < length; j++) {
                if (min > x[j]) {
                    min = x[j];
                    index = j;
                }
            }
            temp = x[i];
            x[i] = x[index];
            x[index] = temp;
        }
    }

    public static void charu(int[] x) {
        for (int i = 1; i < x.length; i++) {
            int temp = x[i], j = i - 1;
            while (j >= 0 && temp < x[j]) {
                x[j + 1] = x[j];
                j--;
            }
            x[j + 1] = temp;
        }
    }

    public static void xier(int[] a) {//给每组进行排序
        //优化前
//        for (int a = x.length / 2; a > 0; a /= 2) {//步长 步长小于等于0结束
//            for (int b = a; b < x.length; b++) {//交换次数
//                for (int c = b - a; c >= 0; c -= a) {//遍历数组，以步长交换值
//                    if (x[c] > x[c + a]) {//拿当前的值和加了步长之后的值进行比较
//                        temp = x[c];
//                        x[c] = x[c + a];
//                        x[c + a] = temp;
//                    }
//                }
//            }
//        }
        //优化后
        int j, gap;

        for (gap = a.length / 2; gap > 0; gap /= 2)
            for (j = gap; j < a.length; j++)//从数组第gap个元素开始
                if (a[j] < a[j - gap])//每个元素与自己组内的数据进行直接插入排序
                {
                    int temp = a[j];
                    int k = j - gap;
                    while (k >= 0 && a[k] > temp) {
                        a[k + gap] = a[k];
                        k -= gap;
                    }
                    a[k + gap] = temp;
                }
    }

    public static void quick(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            quick(arr, left, index - 1);
            quick(arr, index + 1, right);
        } else {
            return;
        }
    }

    private static int partition(int[] n, int l, int r) {
// p为基数，即待排序数组的第一个数
        int p = n[l];
        int i = l;
        int j = r;
        while (i < j) {
            // 从右往左找第一个小于基数的数
            while (n[j] >= p && i < j) {
                j--;
            }
            // 从左往右找第一个大于基数的数
            while (n[i] <= p && i < j) {
                i++;
            }
            // 找到后交换两个数
            swap(n, i, j);
        }
        // 使划分好的数分布在基数两侧
        swap(n, l, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void guibingsort(int[] n, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guibingsort(n, left, mid, temp);
            guibingsort(n, mid + 1, right, temp);
            guibing(n, left, right, mid, temp);
        }
    }

    private static void guibing(int[] n, int left, int right, int mid, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (n[i] <= n[j]) {
                temp[t] = n[i];
                t++;
                i++;
            } else {
                temp[t] = n[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = n[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = n[j];
            j++;
            t++;
        }
        t = 0;
        int templeft = left;
        while (templeft <= right) {
            n[templeft] = temp[t];
            templeft++;
            t++;
        }
    }

    //基数排序
    private static void jishu(int[] arr) {
        int max = arr[0];
        int[][] a =new int[10][arr.length];//桶子
        int[] count = new int[10];//计数
        for (int i = 1; i < arr.length; i++) {
            if (max<arr[i]){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();
        for (int i=0,n=1;i<maxLength;i++,n*=10){
            for (int j = 0;j<arr.length;j++){
                int temp = arr[j] / n % 10;
                a[temp][count[temp]] = arr[j];
                count[temp]++;
            }
            int index = 0;
            for (int k = 0;k<count.length;k++){
                if (count[k]!=0){
                    for (int l = 0;l<count[k];l++){
                        arr[index++]=a[k][l];
                    }
                }
                count[k]=0;
            }
        }

    }

    //计数排序
    private static void jishu1(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i:arr){
            if(max<i){
                max = i;
            }
            if (min>i){
                min = i;
            }
        }
        int[] temp = new int[max-min+1];
        for (int i = 0;i<arr.length;i++){
            temp[arr[i]]++;
        }
        for (int i = 0,j=0;i<temp.length;i++){
            while (temp[i]!=0){
                arr[j++]=i+min;
                temp[i]--;
            }
        }
    }
}
