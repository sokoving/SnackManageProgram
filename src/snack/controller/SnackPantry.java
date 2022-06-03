package snack.controller;


import snack.model.vo.Snack;

// 간식 탕비실
public class SnackPantry {
    
    // 최대 간식 종류 개수
    public static final int SIZE = 10;
    
    // 탕비실에 있는 간식들을 저장하는 배열
    private Snack[] snacks = new Snack[SIZE];

    public SnackPantry() {
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

}
