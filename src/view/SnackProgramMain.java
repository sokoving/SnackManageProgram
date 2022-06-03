package view;

import java.util.Scanner;

public class SnackProgramMain {
    Scanner sc = new Scanner(System.in);

    // todo) 간식 컨트롤러(= 탕비실?), 직원 컨트롤러(=사원관리자?) 불러올 것

    // 메인 메뉴 출력 메서드
    public SnackProgramMain() {
        while (true) {
            System.out.println("======================================");
            System.out.println("==========간식 관리 메인 페이지===========");
            System.out.println("1. 직원");
            System.out.println("2. 간식 관리자");
            System.out.println("3. 사원 관리자");
            System.out.println("9. 프로그램 종료");

            String menu = inputStr("\n메뉴 번호: ");
            System.out.println(menu);
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 직원 메뉴
                    employeeMenu();
                    break;
                case 2:
                    // 간식 관리자
                     SanckManagerMenu();
                    break;
                case 3:
                    // 사원 관리자
                     EmployeeManagerMenu();
                    break;
                case 9:
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch


        }// end whild(true)

    } //  end SnackProgramMain()

    // 3. 사원 관리자 메뉴
    private void EmployeeManagerMenu() {
        System.out.println("======================================");
        System.out.println("사원관리자의 아이디와 비밀번호를 입력해 주세요");
        String myId = inputStr("아이디: ");
        String myPassword = inputStr("비밀번호: ");
        // todo) 아이디와 비번이 맞는지 확인하는 메서드 구현해야 함

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

    // 2. 간식 관리자 메뉴
    private void SanckManagerMenu() {
        System.out.println("======================================");
        System.out.println("간식관리자의 아이디와 비밀번호를 입력해 주세요");
        String myId = inputStr("아이디: ");
        String myPassword = inputStr("비밀번호: ");
        // todo) 아이디와 비번이 맞는지 확인하는 메서드 구현해야 함

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
                // 신청서 정산
//                todo) 간식 요청서를 합산하는 메서드(수정 필요)
                break;
            case 4:
                // 간식 구입
                // todo) 간식을 구입한 결과를 출려하느 메서드(수정 필요)
                break;
            case 5:
                // 간식 계좌 관리
                // todo) 간식관리자가 관리가 필요한가?(수정 필요)
                break;
            case 9:
                // 메인으로 돌아가기
                System.out.println("메인으로 돌아갑니다.");
                break;
            default:
                System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
        } // end switch

    }

    // 1. 직원 메뉴
    private void employeeMenu() {
        System.out.println("======================================");
        System.out.println("아이디와 비밀번호를 입력해 주세요");
        String myId = inputStr("아이디: ");
        String myPassword = inputStr("비밀번호: ");
        // todo) 아이디와 비번이 맞는지 확인하는 메서드 구현해야 함

        System.out.printf("# %s 님의 간식 관리 페이지입니다.\n", myId);
        System.out.println("1. 재고 조회");
        System.out.println("2. 간식 먹기");
        System.out.println("3. 간식 요청");
        System.out.println("4. 간식 요청서 조회");
        System.out.println("5. 간식비 조회");
        System.out.println("9. 메인으로 돌아가기");

        String menu = inputStr("\n메뉴 번호: ");
        System.out.println(menu);
        switch (Character.getNumericValue(menu.charAt(0))) {
            case 1:
                // 재고 조회
//                todo) SnackPantry의 간식 현황을 조회하는 메서드(간식관리자 1번과 동일)
                break;
            case 2:
                // 간식 먹기
//                todo) 창고에서 간식을 빼내고, 본인 간식비에서 차감한 결과를 출력하는 메서드
                break;
            case 3:
                // 간식 요청
//                todo) 간식 관리자에 SnackPantry에 없는 간식 구입을 요청하고 결과를 출력하는 메서드
                break;
            case 4:
                // 간식 요청서 조회
                // todo) 간식 요청서(다른 직원이 올린 것 포함)를 출력하는 메서드(간식관리자 2번과 동일)
                break;
            case 5:
                // 내 간식비 조회
                // todo) 내 현재 간식비를 출력하는 메서드(사용 내역 조회도 좋을 듯)
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
