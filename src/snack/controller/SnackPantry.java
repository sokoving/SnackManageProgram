package snack.controller;


import snack.model.vo.Snack;

import java.util.Arrays;

// 간식 탕비실
public class SnackPantry {

    public static final int SIZE = 10;    // 최대 간식 종류 개수
    private Snack[] snacks;         // 탕비실에 있는 간식들을 저장하는 배열
    private int count;      // snacks 배열에 실제 있는 데이터 수
    private int money;      // 사원이 간식을 사고 내는 돈을 저장하는 필드

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

    public void add(String snack, int price, int stock) {
        snacks[count++] = new Snack(snack, price, stock);
//        printSnackPantry();
    }


    // 이름으로 인덱스 번호 찾기
    public int findIndexByName(String name){
        int snackIndex = -1;
        for (int i = 0; i < count; i++) {
            if(name.equals(snacks[i].getName())){
             snackIndex = i;
            }
        }
        return snackIndex;
    }

    // 인덱스 번호로 데이터 삭제하기
    public Snack removeSnackById(int idx){
        Snack dellSnack = snacks[idx];

        for (int i = idx; i < count-1 ; i++) {
            snacks[i] = snacks[i+1];
        }
        snacks[count-1] = null;
        count--;

        return dellSnack;

    }

    public Snack[] getSnacks() {
        return snacks;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
