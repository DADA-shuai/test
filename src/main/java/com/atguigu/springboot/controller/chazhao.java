package com.atguigu.springboot.controller;

import java.util.ArrayList;

public class chazhao {
    public static void main(String[] args) {
        int arr[][] = {{-1, -1, -1, -1}, {-2, -2, -2, -2}, {-3, -3, -3, -3}, {-4, -4, -4, 4}};
        ArrayList<Integer> list = erfen3(arr, -2);
        for (int i :list){
            System.out.println(i);
        }


    }

    private static ArrayList<Integer> erfen3(int[][] arr, int value) {
        int col = arr.length-1;
        int i = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        while (col >= 0 && i < arr[col].length) {
            if (arr[col][i]>value){
                i++;
            }else if (arr[col][i]<value){
                col--;
            }else{
                integers.add(col);
                integers.add(i);
                return integers;
            }
        }
        return integers;
    }

    //二分查找
    public static int erfen(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (value > arr[mid]) {
            return erfen(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return erfen(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    //二分查找改
    public static ArrayList<Integer> erfen2(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList();
        }
        int mid = (left + right) / 2;
        if (value > arr[mid]) {
            return erfen2(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return erfen2(arr, left, mid - 1, value);
        } else {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(mid);
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != arr[mid]) {
                    break;
                }
                arrayList.add(temp);
                temp--;
            }
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != arr[mid]) {
                    break;
                }
                arrayList.add(temp);
                temp++;
            }
            return arrayList;
        }
    }
}
