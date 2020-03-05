package com.atguigu.springboot.controller;

public class Ugly {
    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,7,13,19};
        int i = login(n, primes);
        System.out.println("第"+n+"个丑数："+i);
    }

    public static int login(int n,int[] primes){
        //定义存储丑数的数组
        int[] ugly = new int[n];
        ugly[0] = 1;
        //定义辅助数组
        int[] arg = new int[primes.length];
        //定义计数器
        int idx = 1;
        while(idx<n){
            int min = ugly[arg[0]]*primes[0];
            for(int i=1;i<primes.length;i++){
                if (min>ugly[arg[i]]*primes[i]){
                    min=ugly[arg[i]]*primes[i];
                }
            }
            for (int i =0;i<primes.length;i++){
                if (min==ugly[arg[i]]*primes[i]){
                    arg[i]++;
                }
            }
            ugly[idx]=min;
            idx++;
        }
        return ugly[n-1];
    }
}
