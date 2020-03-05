package com.atguigu.springboot.controller;

public class migong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0) {
                    map[0][j] = 1;
                    continue;
                }
                if (i == 7) {
                    map[7][j] = 1;
                    continue;
                }
                if (j == 0) {
                    map[i][0] = 1;
                    continue;
                }
                if (j == 6) {
                    map[i][6] = 1;
                    continue;
                }
                map[i][j] = 0;
            }
        }
        map[3][1] = 1;
        map[3][2] = 1;
        setWay(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
