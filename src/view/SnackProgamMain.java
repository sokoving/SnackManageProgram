package view;

import snackRequest.controller.SnackRequest;

import java.util.Scanner;

public class SnackProgamMain {

    //    private SnackPantry pantry;
    private SnackRequest request;

    private EmployeePage emp;
    private ManagerPage mgr;

    private SnackPage snackPage;
    private Scanner sc;

    public SnackProgamMain() {
//        pantry = new SnackPantry();
        request = new SnackRequest();
        sc = new Scanner(System.in);
        emp = new EmployeePage();
        mgr = new ManagerPage();
        snackPage = new SnackPage();

    }

    public void mainMenu() {
        // 로그인 하기
        System.out.println("Together Inc. 홈페이지에 오신것을 환영합니다.");
        while (true) {
            System.out.println("================= 로그인 =================");
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
            if (id.equals("id") && pwd.equals("pwd")) {
                emp.employeePage();
                break;
            }
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
            if (id.equals("id") && pwd.equals("pwd")) {
                mgr.EmployeeManagerMenu();
                break;
            }
            System.out.println("아이디/비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private void snackManagerLogin() {
        System.out.println("============== 간식 관리자 로그인 ==============");
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("PWD: ");
            String pwd = sc.nextLine();
            if (id.equals("id") && pwd.equals("pwd")) {
                snackPage.SanckManagerMenu();
                break;
            }
            System.out.println("아이디/비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private void empMgrPage() {

    }

    private void snackMgrPage() {
    }

}
