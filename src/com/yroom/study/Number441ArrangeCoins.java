package com.yroom.study;

public class Number441ArrangeCoins {
    public static int arrangeCoins(int n) {
        //当前行数对应着消耗个数
        long currRow = 1;
        //当前行所消耗的硬币
        long currRowNeedCoins = 1;
        //如果剩下的n还够消耗下一行，行数加一
        while (n - currRowNeedCoins >= currRow + 1) {
            currRow++;
            //计算下一行共需消耗的钱
            currRowNeedCoins = ((1 + currRow) * currRow) / 2;
            //行数加1

        }
        return (int)currRow;
    }

    public static void main(String[] args) {

        System.out.println(arrangeCoins(1804289383));

    }
}
