package snack.controller;


import snack.model.vo.Snack;

import java.util.Arrays;

// 간식 탕비실
public class SnackPantry {

    // 최대 간식 종류 개수
    public static final int SIZE = 10;

    // 탕비실에 있는 간식들을 저장하는 배열
    private Snack[] snacks;

    private int count;

    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public SnackPantry() {
        snacks = new Snack[SIZE];
        count = 4;
        snacks[0] = new Snack("에이스", 1000, 10);
        snacks[1] = new Snack("사과", 1000, 10);
        snacks[2] = new Snack("커피", 1500, 10);
        snacks[3] = new Snack("과자", 2000, 10);
    }

    // 탕비실에 있는 간식들을 출력
    public void printSnackPantry() {
        for (Snack snack : snacks) {
            // null이 아니면 간식 information 출력
            if (snack != null) System.out.println(snack.inform());
        }
    }

    // 간식 탕비실에 추가하기
    public void add(String snack, int price) {
        snacks[count++] = new Snack(snack, price, 10);
//        printSnackPantry();
    }

    public Snack[] getSnacks() {
        return snacks;
    }
}
