package view;

import snack.controller.SnackPantry;
import snack.model.vo.Snack;
import snackRequest.controller.SnackRequest;

import java.util.Scanner;

// 직원 페이지
public class EmployeePage {

    private Scanner sc;
    private SnackPantry pantry;
    private SnackRequest request; /////////////////// SnackRequest 생성 /////////////////////

    public EmployeePage() {
        sc = new Scanner(System.in);
        request = new SnackRequest();
        pantry = request.getPantry();
    }

    public void employeePage() {
        boolean loop = true;
        while (loop) {
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
                case 1: // 간식 재고 조회
                    viewSnackStock();
                    break;
                case 2: // 간식비 계좌 조회
                    viewSnackAccount();
                    break;
                case 3: // 간식 구입
                    purchaseSnack();
                    break;
                case 4: // 간식 요청
                    requestSnack();
                    break;
                case 5:
                    request.closeRequest();
                    break;
                case 9:
                    // 프로그램 종료
                    System.out.println("메인으로 돌아갑니다.");
                    loop = false;
                    break;
                default:
                    System.out.println("\n잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    // 간식 재고 조회
    private void viewSnackStock() {
        System.out.println("============== 간식 재고 조회 ==============");
        pantry.printSnackPantry();
    }

    // 간식비 계좌 조회
    private void viewSnackAccount() {
        System.out.println("============= 간식비 계좌 조회 =============");

    }

    // 간식 구입
    private void purchaseSnack() {
        System.out.println("================= 간식 구입 ================");
        System.out.print("구입할 간식 이름: ");
        String purchase = sc.nextLine();
        System.out.print("구입할 간식 개수: ");
        int amount = sc.nextInt();
        sc.nextLine();

        Snack[] list = pantry.getSnacks();
        for (Snack snack : list) {
            if (snack == null) break;
            // 구입한 간식 개수 만큼 재고에서 빼주기
            if (snack.getName().equals(purchase)) {
                snack.setStock(snack.getStock() - amount);
                break;
            }
        }
        System.out.printf("%s을(를) %d개 구매하셨습니다.\n", purchase, amount);

    }

    // 간식 요청
    private void requestSnack() {
        System.out.println("================ 간식 요청 ================");
        System.out.print("요청할 간식 이름: ");
        String snack = sc.nextLine();
        request(snack);
    }

    private void request(String snack) {
        // 간식 신청서에 신청한 간식 이름 넣기
        request.add(snack);
    }

    public SnackPantry getPantry() {
        return pantry;
    }
}
