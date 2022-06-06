package view;

import employee.Employee;
import employee.EmployeeManager;
import snack.controller.SnackPantry;
import snack.model.vo.Snack;
import snackRequest.controller.SnackRequest;

import java.util.Scanner;

// 직원 페이지
public class EmployeePage {

    private Scanner sc;
    private SnackPantry pantry;
    private SnackRequest request;

    private int money;
    public EmployeePage(SnackPantry pantry, SnackRequest request) {
        sc = new Scanner(System.in);
        this.request = request;
        this.pantry = pantry;
    }

    // 직원 메인 페이지
    public void employeePage(Employee employee) {
        boolean loop = true;
        while (loop) { // 직원 메인 페이지
            System.out.println("=============== 직원 페이지 ===============");
            System.out.println("1. 간식 재고 조회");
            System.out.println("2. 간식비 계좌 조회");
            System.out.println("3. 간식 구입");
            System.out.println("4. 간식 요청");
            System.out.println("9. 이전으로 돌아가기");
            System.out.print(">> ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // 간식 재고 조회
                    viewSnackStock();
                    break;
                case 2: // 간식비 계좌 조회
                    viewSnackAccount(employee);
                    break;
                case 3: // 간식 구입
                    purchaseSnack(employee);
                    break;
                case 4: // 간식 요청
                    requestSnack();
                    break;
                case 9:
                    // 이전으로 돌아가기
                    System.out.println("이전으로 돌아갑니다.");
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
    private void viewSnackAccount(Employee employee) {
        System.out.println("============= 간식비 계좌 조회 =============");
        System.out.println("간식비 잔고: " + employee.getAccount());
    }

    // 간식 구입
    private void purchaseSnack(Employee employee) {
        System.out.println("================= 간식 구입 ================");
        System.out.print("구입할 간식 이름: ");
        String purchase = sc.nextLine();

        // 탕비실 간식 리스트 불러오기
        Snack[] list = pantry.getSnacks();
        boolean loop = true;
        int amount = 0;
        while (loop) {
            System.out.print("구입할 간식 개수: ");
            amount = sc.nextInt();
            sc.nextLine();

            for (Snack snack : list) {
                if (snack == null) break;
                // 구입한 간식 개수 만큼 재고에서 빼주기
                if (snack.getName().equals(purchase)) {
                    // 구입하는 간식 수가 재고보다 많을 경우, 실패
                    if (snack.getStock() - amount < 0) {
                        System.out.println("구입할 간식 개수가 재고보다 많습니다.");
                        System.out.printf("재고 : %d / 입력: %d\n", snack.getStock(), amount);
                        break; // break for loop
                    } else if (employee.getAccount() < amount * snack.getPrice()) { // 구입하는 간식 비용이 간식비 잔고보다 많을 경우, 실패
                        System.out.println("잔고가 부족합니다.");
                        System.out.printf("총 가격: %d / 간식비 잔고: %d\n", amount * snack.getPrice(), employee.getAccount());
                        break;
                    }
                    // 구매한 개수만큼 재고에서 빼주기
                    snack.setStock(snack.getStock() - amount);
                    // 직원이 낸 돈 만큼 탕비실 돈통에 돈이 쌓임
                    pantry.setMoney(pantry.getMoney() + snack.getPrice() * amount);
                    // 직원이 낸 돈 만큼 본인 간식 잔고에서 빼기
                    employee.setAccount(employee.getAccount() - snack.getPrice() * amount);
                    loop = false;
                    break;
                }
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
