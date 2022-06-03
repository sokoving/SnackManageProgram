package view;

import employee.Employee;
import employee.EmployeeManager;
import snack.controller.SnackPantry;
import snackRequest.controller.SnackRequest;

import java.util.Scanner;

public class SnackProgramMain {

    private EmployeePage emp;
    private ManagerPage mgr;
    private SnackPage snackPage;
    private Scanner sc;
    private SnackPantry pantry;
    private SnackRequest request;
    private EmployeeManager empMgr;

    public SnackProgramMain() {
        sc = new Scanner(System.in);
        pantry = new SnackPantry();
        request = new SnackRequest(pantry);
        emp = new EmployeePage(pantry, request);
        mgr = new ManagerPage();
        snackPage = new SnackPage(pantry, request);
        empMgr = new EmployeeManager();
    }

    // 시작 페이지
    public void mainMenu() {
        System.out.println("Together Inc. 홈페이지에 오신것을 환영합니다.");
        while (true) { // 프로그램 종료할 때 까지 나오는 메인 페이지
            System.out.println("================= 로그인 =================");
            Employee employee;
            while (true) { // 아이디가 존재하는지 체크
                System.out.print("ID: ");
                String id = sc.nextLine();

                employee = empMgr.searchNumber(id);

                if (employee == null) {
                    System.out.println("존재하지 않는 아이디입니다. 다시입력해주세요");
                } else
                    break;
            }

            while (true) { // 비밀번호가 맞는지 체크
                System.out.print("PWD: ");
                String pwd = sc.nextLine();

                if (pwd.equals(employee.getPassword())) {
                    break;
                } else {
                    System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
                }
            }

            // 로그인 성공했을 경우
            char rank = employee.getNumber().charAt(0);
            if (rank == '0') emp.employeePage(); // 직원 페이지
            else if (rank == '1') { // 사원 관리자 일 겨우
                boolean loop = true;
                while (loop) { // 사원 관리자의 메인페이지
                    System.out.println("1. 직원");
                    System.out.println("2. 사원 관리자");
                    System.out.println("9. 로그인 페이지로 돌아가기");
                    System.out.print(">> ");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1: // 직원 페이지로 이동
                            emp.employeePage();
                            break;
                        case 2: // 사원 관리자 페이지로 이동
                            mgr.EmployeeManagerMenu();
                            break;
                        case 9: // 로그인 페이지로 돌아가기
                            loop = false;
                            break;
                        default:
                            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    }
                }
            } else if (rank == '2') { // 간식 관리자 페이지
                boolean loop = true;
                while (loop) { // 간식 관리자의 메인페이지
                    System.out.println("1. 직원");
                    System.out.println("2. 간식 관리자");
                    System.out.println("9. 로그인 페이지로 돌아가기");
                    System.out.print(">> ");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1: // 직원 페이지로 이동
                            emp.employeePage();
                            break;
                        case 2: // 사원 관리자 페이지로 이동
                            snackPage.SanckManagerMenu();
                            break;
                        case 9: // 로그인 페이지로 돌아가기
                            loop = false;
                            break;
                        default:
                            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    }
                }
            }
        }
    }
}