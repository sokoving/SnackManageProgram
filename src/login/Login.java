package login;

import snack.controller.SnackPantry;
import snackRequest.controller.SnackRequest;

import java.util.Scanner;

public class Login {

    private SnackPantry pantry;
    private SnackRequest request;
//    private EmployeeController emp;

    private Scanner sc;

    public Login() {
        pantry = new SnackPantry();
        request = new SnackRequest();
        sc = new Scanner(System.in);
    }

    public void mainMenu() {
        // 로그인 하기
        System.out.println("Together Inc. 홈페이지에 오신것을 환영합니다.");
        System.out.println("================= 로그인 =================");
        while (true) {
            System.out.println("1. 직원");
            System.out.println("2. 사원 관리자");
            System.out.println("3. 간식 관리자");
            System.out.println("9. 프로그램 종료");
            System.out.print(">> ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    employeeLogin();
                    break;
                case 2:
                    empManagerLogin();
                    break;
                case 3:
                    snackManagerLogin();
                    break;
                case 9:
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); // 프로세스 종료
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private void employeeLogin() {
        System.out.println("=============== 직원 로그인 ===============");
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("PWD: ");
            String pwd = sc.nextLine();
            if (id.equals("id") && pwd.equals("pwd")) employeePage();
            System.out.println("아이디/비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private void empManagerLogin() {
        System.out.println("============== 직원 관리자 로그인 ==============");
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("PWD: ");
            String pwd = sc.nextLine();
            if (id.equals("id") && pwd.equals("pwd")) empMgrPage();
            System.out.println("아이디/비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private void empMgrPage() {

    }

    private void snackManagerLogin() {
        System.out.println("============== 간식 관리자 로그인 ==============");
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("PWD: ");
            String pwd = sc.nextLine();
            if (id.equals("id") && pwd.equals("pwd")) snackMgrPage();
            System.out.println("아이디/비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private void snackMgrPage() {
    }

    private void employeePage() {
        while (true) {
        System.out.println("=============== 직원 페이지 ===============");
            System.out.println("1. 간식 재고 조회");
            System.out.println("2. 간식비 계좌 조회");
            System.out.println("3. 간식 구입");
            System.out.println("4. 간식 요청");
            System.out.println("9. 메인으로 돌아가기");
            System.out.print(">> ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewSnackStock();
                    break;
                case 2:
                    viewSnackAccount();
                    break;
                case 3:
                    purchaseSnack();
                    break;
                case 4:
//                    requestSnack();
                    break;
                case 9:
                    // 프로그램 종료
                    System.out.println("메일으로 돌아갑니다.");
                    System.exit(0); // 프로세스 종료
                default:
                    System.out.println("\n잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private void viewSnackStock() {
        System.out.println("============== 간식 재고 조회 ==============");
        pantry.printSnackPantry();
    }

    private void viewSnackAccount() {
        System.out.println("============= 간식비 계좌 조회 =============");

    }

    private void purchaseSnack() {
        System.out.println("================= 간식 구입 ================");

    }

    private void requestSnack(String snack) {
        System.out.println("================ 간식 요청 ================");

    }


}
