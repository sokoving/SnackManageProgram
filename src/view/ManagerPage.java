package view;

import employee.Employee;
import employee.EmployeeManager;

import java.lang.reflect.Member;
import java.util.Scanner;

public class ManagerPage {
    Scanner sc = new Scanner(System.in);
    private EmployeeManager e = new EmployeeManager();

    // 3. 사원 관리자 메뉴
    public void EmployeeManagerMenu() {
        while (true) {
            System.out.println("======================================");

            System.out.println("# 사원관리자의 페이지입니다.");
            System.out.println("1. 직원 정보 조회");
            System.out.println("2. 직원 전체 정보 조회");
            System.out.println("3. 직원 정보 수정");
            System.out.println("4. 입사 직원 처리");
            System.out.println("5. 퇴사 직원 처리");
            System.out.println("6. 간식비 관리");
            System.out.println("9. 로그아웃");

            String menu = inputStr("\n메뉴 번호: ");
            System.out.println(menu);
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 직원 정보 조회
                    searchEmployee();

    //                todo) 특정 직원의 정보를 출력하는 메서드
                    break;
                case 2:
                    // 직원 전체 정보 조회
                    printAllEmployee();
    //                todo) 전체 직원의 정보를 출력하는 메서드
                    break;
                case 3:
                    // 직원 정보 수정
                    updateEmployee();
    //                todo) 직원의 정보를 수정한 결과를 출력하는 메서드
                    break;
                case 4:
                    // 입사 직원 처리
                    insertEmployee();
                    // todo) 입사한 직원의 정보를 직원관리 배열에 넣기
                    break;
                case 5:
                    // 퇴사 직원 처리
                    deleteEmployee();
                    // todo) 퇴사한 직원의 정보를 직원관리 배열에서 삭제하기
                    break;
                case 6:
                    // 간식비 사원 각자 계좌에 돈을 넣기
                    sendMoney();
                    // todo) 사원의 각자 간식비 계좌에 간식비를 입금하고 결과를 출력하는 메서드
                    break;
                case 9:
                    // 로그인 화면으로 돌아가기
                    System.out.println("메인으로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch
        }
    }
//=====================================================================================//

    // 1-1 직원 정보를 조회 하는 메서드
    public void searchEmployee() {

        System.out.println("\n======= 회원 정보 검색 =======");
        System.out.println("# 1. 사원번호로 검색하기");
        System.out.println("# 2. 이름으로 검색하기");
        System.out.println("# 3. E-mail로 검색하기");
        System.out.println("# 9. 이전 페이지로 이동");

        int menu = inputInt("- 메뉴 입력: ");
        switch (menu) {
            case 1:
                // 아이디 검색
                searchNumber();
                break;
            case 2:
                // 이름 검색
                searchName();
                break;
            case 3:
                // 이름 검색
                searchEmail();
                break;
            case 9:
                return;
            default:
                System.out.println("메뉴를 잘못 입력했습니다.");
        }
    }

    // 메뉴 1-1번 처리
    private void searchNumber() {

        String targetId = inputStr("- 조회할 아이디: ");
        Employee employee = e.searchNumber(targetId);
        if (employee != null) {
            System.out.println("\n=========== 검색된 회원 정보 ============");
            System.out.println(employee.inform());
        } else {
            System.out.println("\n- 존재하지 하는 사원이 아닙니다.");
        }
    }

    // 메뉴 1-2번 처리
    private void searchName() {

        String targetName = inputStr("- 조회할 이름: ");
        Employee[] employees = e.searchName(targetName);

        if ( employees.length > 0) {
            System.out.println("\n=========== 검색된 회원 정보 ============");
            for (Employee e : employees) {
                System.out.println(e.inform());
            }
        } else {
            System.out.println("\n- 존재하지 하는 사원이 아닙니다.");
        }
    }

    // 메뉴 1-3번 처리
    private void searchEmail() {

        String targetEmail = inputStr("- 조회할 E-amil: ");
        Employee employee = e.searchEmail(targetEmail);
        System.out.println(employee);
        if (employee != null) {
            System.out.println("\n=========== 검색된 회원 정보 ============");
            System.out.println(employee.inform());
        } else {
            System.out.println("\n- 존재하지 하는 사원이 아닙니다.");
        }
    }

    // 메뉴 2번 처리

    private void printAllEmployee(){
        Employee[] employees = e.printAll();
        for (Employee employee : employees) {
            if(employee == null) return;
            System.out.println(employee.inform());
        }
    }

    //=========================================================

// 메뉴 3번 처리
  private void updateEmployee(){

      System.out.println("\n======= 회원 정보 수정 =======");
      System.out.println("# 1. 비밀번호 수정하기");
      System.out.println("# 2. 이메일 수정하기");
      System.out.println("# 3. 부서 수정하기");
      System.out.println("# 4. 직책 수정하기");
      System.out.println("# 9. 메인으로 돌아가기");

      int menu = inputInt("- 메뉴 입력: ");
      switch (menu) {
          case 1:
              // 비밀번호 수정
              updatePassword();
              break;
          case 2:
              // 이메일 수정
              updateEmail();
              break;
          case 3:
              // 부서 수정
              updateDepartment();
              break;
          case 4:
              // 직책 수정
              updatePosition();
              break;
          case 9:
              return;
          default:
              System.out.println("메뉴를 잘못 입력했습니다.");
      }
  }

  // 3-1 updatePassword
    private void updatePassword(){
        String id = inputStr("- 사원번호: ");
        // 원래 비밀번호
        String oldPw = e.searchNumber(id).getPassword();
        String newPw = inputStr("- 새로운 비밀번호 ");

        if (e.updatePassword(id, newPw)) {
            System.out.println("\n비밀번호 수정 완료!");
        } else {
            System.out.println("\n수정 실패!");
        }
    }

    // 3-2 updateEmail
    private void updateEmail() {
        String id = inputStr("- 사원번호: ");
        String newEmail = inputStr("- 새로운 이메일: ");

        if (e.updateEmail(id, newEmail)) {
            System.out.println("\n이메일 수정 완료!");
        } else {
            System.out.println("\n수정 실패!");
        }

    }
    // 3-3 updateDepartment

    private void updateDepartment(){
        String id = inputStr("- 사원번호 :");
        String newDepartment = inputStr("- 변경된 부서 :");

        if(e.updateDepartment(id, newDepartment)) {
            System.out.println("\n이동된 부서로 수정 완료!");
        } else{
            System.out.println("\n 수정실패!");
        }
    }
    // 3-4 updatePosition

    private void updatePosition(){
        String id = inputStr("- 사원번호 :");
        String newDepartment = inputStr("- 변경된 직책 :");

        if(e.updateDepartment(id, newDepartment)) {
            System.out.println("\n직책 수정 완료!");
        } else{
            System.out.println("\n 수정실패!");
        }
    }

    //=========================================

    //4번 메뉴 처리 insertEmployee
    private void insertEmployee(){

            System.out.println("\n# 사원 정보를 등록합니다.");

            String id = null;
            while (true) {
                id = inputStr("- 사원번호: ");
                if (!e.checkNumber(id)) break;
                System.out.println("- 중복된 사원번호 입니다.!");
            }
            String name = inputStr("- 사원이름: ");
            String password = inputStr("- 비밀번호: ");
            String email = inputStr("- 이메일: ");
            String department = inputStr("- 부서: ");
            String position = inputStr("- 직책: ");
            int account = 0;

            e.insertEmployee(id, name, password, email, department, position,account);
            System.out.println("\n# 사원등록 성공!");
        }

  // 메뉴 5번 처리 deleteEmployee
    private void deleteEmployee() {
        System.out.println("\n======= 사원 정보 삭제 =======");
        System.out.println("# 1. 특정 사원 삭제하기");
        System.out.println("# 2. 모든 회원 삭제하기");
        System.out.println("# 9. 메인으로 돌아가기");

        int menu = inputInt("- 메뉴 입력: ");
        switch (menu) {
            case 1:
                delete();
                break;
            case 2:
                deleteAll();
                break;
            case 9:
                return;
            default:
                System.out.println("메뉴를 잘못 입력했습니다.");
        }

    }

    private void delete() {

        String targetId = inputStr("\n# 삭제 대상 아이디:");

        if (e.checkNumber(targetId)) {
            System.out.println("\n# 회원 정보가 삭제됩니다. [Y/N]");
            String answer = inputStr(">> ");

            switch (answer.toUpperCase().charAt(0)) {
                case 'Y': case 'ㅛ':
                    e.delete(targetId);
                    System.out.printf("\n- [%s]사원의 데이터가 삭제되었습니다.\n", targetId);
                    break;
                case 'N': case 'ㅜ':
                    System.out.println("\n- 삭제를 취소합니다.");
                    break;
            }

        }
    }

    private void deleteAll() {

        System.out.println("\n# 모든 정보가 삭제됩니다. [Y/N]");
        String answer = inputStr(">> ");

        switch (answer.toUpperCase().charAt(0)) {
            case 'Y': case 'ㅛ':
                e.delete();
                System.out.println("\n- 모든 데이터가 삭제되었습니다.");
                break;
            case 'N': case 'ㅜ':
                System.out.println("\n- 삭제를 취소합니다.");
                break;
        }
    }

    //=======================================
    // 6번 메뉴 처리하기
    // 매달 예산 100만원 고정
    // 사원관리자는 간식비 지급 하는 기능을 2가지와 조회하는 기능 총 3가지의 기능을 갖는다.
    // 1. 일괄지급 (간식비는 5만원 고정)
    // 2. 추가 지급( 특정 직원에게 간식비를 추가로 보너스 개념으로 준다)
    // 3. 간식 경비 잔액
    public void sendMoney(){
//        int budget = e.getBudget(); // 예산 가지고 오기
        System.out.println("\n======= 간식비 관리 =======");
        System.out.println("# 1. 간식비 전체지급(전사원)");
        System.out.println("# 2. 간식비 특정지급(우수사원)");
        System.out.println("# 3. 간식비예산 현재잔액 확인");
        System.out.println("# 9. 메인으로 돌아가기");

        int menu = inputInt("- 메뉴 입력: ");
        switch (menu) {
            case 1:
                EmployeeGroupPayment();
                break;
            case 2:
                specialPayment();
                break;
            case 3:
                printBudget();
                break;
            case 9:
                return;
            default:
                System.out.println("메뉴를 잘못 입력했습니다.");
        }
    };

    //6-1번 메뉴 처리

   public void EmployeeGroupPayment() {
             e.groupPayment();
   }

   //6-2번 메뉴 처리 특정 사원에게 간식비를 지급

   public void specialPayment(){
       System.out.println("===== 보너스 간식비를 지급 합니다.=====");
       String specialEmployee = inputStr("- 보너스를 지급받을 사원번호를 입력하세요.\n");
       int snackCost = inputInt("지급할 금액을 입력하세요.\n");

       e.payment(specialEmployee,snackCost);

   }

   //6-3번 메뉴 처리 budget 조회
    public void printBudget(){
        System.out.println("예산을 보여줘");
        e.printSnackCost();
    }

//========================================================================//

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
