package com.atguigu.springboot.controller;

import sun.text.IntHashtable;

public class choushu {
    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,7,13,19};
        int i = nthSuperUglyNumber(12, primes);
        System.out.println(i);
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] arr = new int[n];
        int[] index =new int[primes.length];
        arr[0]=1;
        for(int i=1;i<n;i++){
            arr[i]=primes[0]*arr[index[0]];
            for(int j = 1;j<primes.length;j++){
                arr[i] = Math.min(arr[i],primes[j]*arr[index[j]]);
            }
            for(int k=0;k<primes.length;k++){
                if(arr[i] == primes[k]*arr[index[k]]) index[k]++;
            }
        }
        return arr[n-1];
    }
}
