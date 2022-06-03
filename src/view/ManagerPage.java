package view;

import java.util.Scanner;

public class ManagerPage {
    Scanner sc = new Scanner(System.in);
    // 3. 사원 관리자 메뉴
    public void EmployeeManagerMenu() {
        System.out.println("======================================");

        System.out.println("# 사원관리자의 페이지입니다.");
        System.out.println("1. 직원 정보 조회");
        System.out.println("2. 직원 전체 정보 조회");
        System.out.println("3. 직원 정보 수정");
        System.out.println("4. 퇴사 직원 처리");
        System.out.println("5. 간식비 사원 각자 계좌에 돈을 넣기");
        System.out.println("9. 메인으로 돌아가기");

        String menu = inputStr("\n메뉴 번호: ");
        System.out.println(menu);
        switch (Character.getNumericValue(menu.charAt(0))) {
            case 1:
                // 직원 정보 조회
//                todo) 특정 직원의 정보를 출력하는 메서드
                break;
            case 2:
                // 직원 전체 정보 조회
//                todo) 전체 직원의 정보를 출력하는 메서드
                break;
            case 3:
                // 직원 정보 수정
//                todo) 직원의 정보를 수정한 결과를 출력하는 메서드
                break;
            case 4:
                // 퇴사 직원 처리
                // todo) 퇴사 직원의 정보를 삭제한 결과를 출력하는 메서드
                break;
            case 5:
                // 간식비 사원 각자 계좌에 돈을 넣기
                // todo) 사원의 각자 간식비 계좌에 간식비를 입금하고 결과를 출력하는 메서드
                break;
            case 9:
                // 메인으로 돌아가기
                System.out.println("메인으로 돌아갑니다.");
                break;
            default:
                System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
        } // end switch
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
