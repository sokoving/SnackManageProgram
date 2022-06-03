package view;


import snack.controller.SnackPantry;
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
        boolean loop = true;
        while (loop) {
            System.out.println("======================================");
            System.out.println("# 간식관리자의 페이지입니다.");
            System.out.println("1. 재고 조회");
            System.out.println("2. 신청서 조회");
            System.out.println("3. 신청서 합산");
            System.out.println("4. 간식 구입");
            System.out.println("5. 간식 계좌 관리");
            System.out.println("9. 메인으로 돌아가기");

            String menu = inputStr("\n메뉴 번호: ");
            System.out.println(menu);
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 재고 조회
//                todo) SnackPantry의 간식 현황을 조회하는 메서드(직원 1번과 동일)
                    break;
                case 2:
                    // 신청서 조회
//                todo) 간식 요청서(다른 직원이 올린 것 포함)를 출력하는 메서드(직원 4번과 동일)
                    break;
                case 3:
                case 4:
                    // 신청서 정산
//                todo) 간식 요청서를 합산하는 메서드(수정 필요)
                    // 간식 구입
                    // todo) 간식을 구입한 결과를 출려하느 메서드(수정 필요)

                    int money = request.closeRequest();
                    budget -= money;
                    budget += pantry.getMoney();
                    pantry.setMoney(0);
                    System.out.println(budget);
                    break;
                case 5:
                    // 간식 계좌 관리
                    // todo) 간식관리자가 관리가 필요한가?(수정 필요)
                    System.out.println("잔고: " + budget);
                    break;
                case 9:
                    // 메인으로 돌아가기
                    System.out.println("메인으로 돌아갑니다.");
                    break;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch
        }
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