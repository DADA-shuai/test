package com.atguigu.springboot.controller;

import java.util.*;

public class quanpailie {
    private static List list = new ArrayList();

    public static void main(String[] args) {
        char[] map = new char[]{'a', 'b', 'c', 'c','a','d'};
        quchong(map);
        System.out.println(list);
    }

    private static void gogogo(char[] map, int start) {
        if (start == map.length - 1) {
            list.add(new String(map));
        }
        for (int i = start; i < map.length; i++) {
            if (i == start || map[start] != map[i]) {
                jiaohuan(map, start, i);
                gogogo(map, start + 1);
                jiaohuan(map, start, i);
            }
        }

    }

    private static void jiaohuan(char[] map, int i, int j) {
        char temp = map[i];
        map[i] = map[j];
        map[j] = temp;
    }

    private static void quchong(char[] map){
        Arrays.sort(map);
        HashMap hashMap = new HashMap();
        for (int i = 0; i< map.length;i++){
            hashMap.put(map[i],1);
        }
        Set set = hashMap.keySet();
        int i = 0;
        char[] chars = new char[set.size()];
        for (Object o : set) {
            chars[i++] =(char) o;
        }
        int start = 0;
        gogogo(chars, start);
    }
}
