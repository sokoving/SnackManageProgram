package view;


import snack.controller.SnackPantry;
import snackManager.SnackManager;
import snackRequest.controller.SnackRequest;

import java.util.Scanner;

public class SnackPage {
    Scanner sc = new Scanner(System.in);

    SnackPantry pantry;
    SnackRequest request;
    SnackManager snackMan;
    int budget = 100000;

    public SnackPage(SnackPantry pantry, SnackRequest request, SnackManager snackMan) {
        this.pantry = pantry;
        this.request = request;
    }

    // 2. 간식 관리자 메뉴
    public void SnackManagerMenu() {
        while (true) {
            System.out.println("======================================");
            System.out.println("# 간식관리자의 페이지입니다.");
            System.out.println("1. 탕비실 재고 관리");
            System.out.println("2. 간식 신청서 관리");
            System.out.println("3. 간식 구입");
            System.out.println("4. 간식비 관리");
            System.out.println("9. 이전 페이지로 돌아가기");

            String menu = inputStr("\n메뉴 번호: ");
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 탕비실 재고 관리
//                    managePantryStock();
                    break;
                case 2:
                    // 간식 신청서 관리
//                    manageSnackRequest();
                    break;
                case 3:
                    // 간식 구입
                    buySnack();
                    break;
                case 4:
                    // 간식비 관리
//                    manageSnackBudget();
                    break;

                case 9:
                    // 이전 페이지로 돌아가기
                    System.out.println("이전 페이지로 돌아가기");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch
        }

    }



    // case 4 간식 구입
    private void buySnack() {
        // 간식 이름, 가격, 수량을 입력받아 구매한 결과 출력
        System.out.println("간식비 잔고: " + budget);
        String snackName = inputStr("간식 이름: ");
        int snackPrice = inputInt("간식 가격: ");
        int snackStock = inputInt("간식 수량: ");
        String msg = snackMan.buySnack(snackName, snackPrice, snackStock);
        if (msg != null) {
            System.out.println(msg);
        } else {
            System.out.println("잔액 부족으로 과자 입고에 실패하였습니다.");
        }
    }

    //    case 3 간식 신청서 정산
    // 1. 수동 정산
   // 2. 자동 정산 후
 /*   private void acceptRequest() {
        System.out.println("가장 많은 요청을 받은 품목을 자동 구입합니다.");
        int money = request.closeRequest();
        budget -= money;
        budget += pantry.getMoney();
        pantry.setMoney(0);
        System.out.println(budget);
    }
*/
    // ------ 메서드--------//


    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    // 문자열 입력 받기
    private String inputStr(String msg) {
        System.out.printf(msg);
        return sc.next();
    }

    // 숫자 입력받기
    private int inputInt(String msg) {
        System.out.printf(msg);
        return sc.nextInt();
    }
}