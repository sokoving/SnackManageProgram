package view;

import snack.controller.SnackPantry;
import snackRequest.controller.SnackRequest;
import snackRequest.model.vo.Request;

import java.util.Scanner;

public class EmployeePage {

    private Scanner sc;
    private SnackPantry pantry;
    private SnackRequest request;

    public EmployeePage() {
        sc = new Scanner(System.in);
        pantry = new SnackPantry();
        request = new SnackRequest();
    }

    public void employeePage() {
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
                    requestSnack();
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

    private void requestSnack() {
        System.out.println("================ 간식 요청 ================");
        System.out.print("요청할 간식 이름: ");
        String snack = sc.nextLine();
        request(snack);
        request.printRequests();
    }

    private void request(String snack) {
        request.add(snack);
    }


}
