package view;


import snack.controller.SnackPantry;
import snack.model.vo.Snack;
import snackRequest.controller.SnackRequest;

import java.util.Scanner;

public class SnackPage {
    Scanner sc = new Scanner(System.in);

    SnackPantry pantry;
    SnackRequest request;
    int budget = 100000;

    public SnackPage(SnackPantry pantry, SnackRequest request) {
        this.pantry = pantry;
        this.request = request;
    }

    // 2. 간식 관리자 메뉴
    public void SanckManagerMenu() {
        while (true) {
            System.out.println("======================================");
            System.out.println("# 간식관리자의 페이지입니다.");
            System.out.println("1. 재고 조회");
            System.out.println("2. 간식 신청서 조회");
            System.out.println("3. 간식 신청서 정산");
            System.out.println("4. 간식 구입");
            System.out.println("5. 간식 계좌 잔액 조회");
            System.out.println("9. 메인으로 돌아가기");

            String menu = inputStr("\n메뉴 번호: ");
            System.out.println(menu);
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 재고 조회
                    System.out.println("\n # 팬트리에 있는 과자들을 조회합니다.");
                    System.out.println("============================================");
                    pantry.printSnackPantry();
                    break;
                case 2:
                    // 간식 신청서 조회
                    System.out.println("\n # 직원들의 과자 요청서를 조회합니다.");
                    System.out.println("============================================");
                    request.printRequests();
                    break;
                case 3:
                    // 간식 신청서 정산 : 간식 요청서를 합산후 구입
                    acceptRequest();
                    break;
                case 4:
                    // 간식 구입
                    buySnack();
                    break;

                case 5:
                    // 간식 계좌 잔액 조회
                    System.out.println("잔고: " + budget);
                    break;
                case 9:
                    // 메인으로 돌아가기
                    System.out.println("메인으로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch
        }

    }



    // case 4 간식 구입
    private void buySnack() {
        // 간식 이름, 가격, 수량을 입력받아 구매
        System.out.println("간식비 잔고: " + budget);
        String snackName = inputStr("간식 이름: ");
        int snackPrice = inputInt("간식 가격: ");
        int snackStock = inputInt("간식 수량: ");
        // 예산이 가격 * 수량보다 적으면
        // 팬트리에 그 스낵을 넣고
        // 버젯에서 구입 금액을 뺀다
        if ( budget >= snackPrice*snackStock){
            budget -= snackPrice*snackStock;
            pantry.add(snackName, snackPrice, snackStock);
        } else {
            System.out.println("간식비 잔고가 부족합니다.");
        }
    }

    //    case 3 간식 신청서 정산 : 간식 요청서를 합산후 구입
    private void acceptRequest() {
        System.out.println("가장 많은 요청을 받은 품목을 자동 구입합니다.");
        int money = request.closeRequest();
        budget -= money;
        budget += pantry.getMoney();
        pantry.setMoney(0);
        System.out.println(budget);
    }

    // ------ 메서드--------//
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