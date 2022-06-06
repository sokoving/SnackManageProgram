package employee;


import java.util.Scanner;

public class EmployeeManager {
    Scanner sc = new Scanner(System.in);
    //===========필드

    // 사원 정보 배열에 관리
    private Employee[] e = new Employee[SIZE];

    private int budget ;

    // 이 회사의 직원은 10명 고정 상수 변수 SIZE
    public static final int SIZE = 10;

    //========= 생성자
    // 생성시 Employee 초기화
    public EmployeeManager() {
        e[0] = new Employee("00000", "1234a", "김철수", "abc@naver.com", "영업", "과장", 100000);
        e[1] = new Employee("00001", "1235b", "홍길동", "abe@naver.com", "관리", "대리", 0);
        e[2] = new Employee("00002", "1236c", "김지우", "abf@naver.com", "총무", "사원", 0);
        e[3] = new Employee("00003", "1237d", "윤이슬", "abq@naver.com", "인사", "주임", 0);
        e[4] = new Employee("00004", "1238e", "송민호", "abx@naver.com", "영업", "대리", 0);
        // 사원 관리자
        e[5] = new Employee("10004", "1238e", "송민호", "abx@naver.com", "영업","대리",0);
        // 간식 관리자
        e[6] = new Employee("20004", "1238e", "송민호", "abx@naver.com", "영업","대리",0);

        budget = 1000000;
    }

    //=========== 메서드
    // 현재 근무자의 수
    public int existEmployee() {
        int count = 0; // 현재 직원 수
        for (Employee employee : e) {
            if (employee == null) {
                break;
            }
            count++;
        }
        return count;
    }

    // employee 배열 리턴
    public Employee[] printAll() {
        return e;
    }

    ;


    // 직원 정보를 배열 e에 저장하는 메서드 (직원 채용시)
    public void insertEmployee(String number, String name, String password, String email, String department
            , String position, int account) {
        int count = existEmployee();
        e[count] = new Employee(number, name, password, email, department, position, account);
    }

    // 사원 번호를 입력하면 해당 회원 객체를 리턴
    public Employee searchNumber(String inputNumber) {
        int index = findIndexByNumber(inputNumber);
        return (index != -1) ? e[index] : null;
    }

    public Employee searchEmail(String inputEmail) {
        int index = -1;
        for (int i = 0; i < existEmployee(); i++) {
            if (inputEmail.equals(e[i].getEmail())) {
                index = i;
                break;
            }
        }
        return (index != -1) ? e[index] : null;
    }

    // 찾을 사원번호 값, 찾은 사원번호 인덱스 값, 못찾을시 -1 리턴
    private int findIndexByNumber(String id) {
        int index = -1;
        for (int i = 0; i < existEmployee(); i++) {
            if (id.equals(e[i].getNumber())) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 검색할 사원의 이름
    // 동명이인 포함 해당 이름과 일치하는 모든 사원정보 배열
    public Employee[] searchName(String name) {
        Employee[] nameArr = new Employee[existEmployee()];
        int count = 0;
        for (int i = 0; i < existEmployee(); i++) {
            if (name.equals(e[i].getName())) {
                nameArr[count++] = e[i];
            }
        }
        Employee[] temp = new Employee[count];
        for (int j = 0; j < count; j++) {
            temp[j] = nameArr[j];
        }
        nameArr = temp;
        return nameArr;
    }

    //존재하는 사원번호인지 확인
    // 존재하는 사원이면 true 리턴, 아니면 false
    public boolean checkNumber(String inputNumber) {
        return findIndexByNumber(inputNumber) != -1;
    }

    //회원의 비밀번호를 변경하는 메서드
    public boolean updatePassword(String number, String newPassword) {
        if (checkNumber(number)) {
            e[findIndexByNumber(number)].setPassword(newPassword);
            return true;
        }
        return false;
    }


    //사원의 이메일을 변경하는 메서드
    public boolean updateEmail(String number, String newEmail) {
        if (checkNumber(number)) {
            e[findIndexByNumber(number)].setEmail(newEmail);
            return true;
        }
        return false;
    }

    //사원의 부서를 변경하는 메서드
    public boolean updateDepartment(String number, String newDepartment) {
        if (checkNumber(number)) {
            e[findIndexByNumber(number)].setDepartment(newDepartment);
            return true;
        }
        return false;
    }

    // 사원의 직책을 변경하는 메서드
    public boolean updatePosition(String number, String newPosition) {
        if (checkNumber(number)) {
            e[findIndexByNumber(number)].setPosition(newPosition);
            return true;
        }
        return false;
    }

    //사원정보 전체 삭제
    public void delete() {
        int count = existEmployee();
        for (int i = 0; i < count; i++) {
            e[i] = null;
        }
    }

    //사원 정보 삭제
    public boolean delete(String number) {
        int delIdx = findIndexByNumber(number); // 삭제할 인덱스
        if (delIdx != -1) {
            for (int i = delIdx; i < existEmployee() - 1; i++) {
                e[i] = e[i + 1];
            }
            e[existEmployee() - 1] = null;
            return true;
        }
        return false;
    }

    // 간식비 일괄 지급 기능
    // 사원 1명당 간식비 5만원 고정 일괄 지급
    // 지급된 금액 만큼 budget에서 차감하기
    public int groupPayment() {
        int count = 0;
        if (budget < existEmployee() * 50000) {
            System.out.println("일괄 지급에 실패 하였습니다.");
            return -1;
        } for (Employee employee : e) {
            if (employee != null) {
                employee.setAccount(50000);
                count++;
            }

        }
        this.budget -= count * 50000;
        System.out.println("지급 성공!! 전 직원에게 간식비 5만원을 지급 하였습니다.");
        return budget;
    }

    // 간식비 특정 지급 기능
    // 특정 사원 1명에게 입력한 만큼의 간식비 지급
    public void payment(String id, int money) {
        Employee bestEmployee = e[findIndexByNumber(id)];
/*        System.out.println(budget);
        System.out.println(money);
        System.out.println(budget < money);
        System.out.println(money >= 50000);*/
        if(budget < money) {
            System.out.println("간식비 예산을 초과한 금액 입니다. 예산을 확인해주세요.");
        } else if (money >= 50000) {
            System.out.println("월 일괄 지급 금액을 초과한 금액입니다. 정말 지급하시겠습니까? \n");
            String answer = inputStr(">> Y : 지급 / N :지급취소 ");
/*            System.out.println((answer.toUpperCase().charAt(0)));
            System.out.println(findIndexByNumber(id));*/
            switch (answer.toUpperCase().charAt(0)) {

                case 'Y' : case 'ㅛ' :
                  bestEmployee.setAccount(bestEmployee.getAccount()+money);
                  // 특정 사원의 account 계좌 늘려주기
                    budget -= money;
                    System.out.printf("%s사원에게 간식비 지급을 완료하였습니다.", bestEmployee.getName());
                    break;

                case 'N': case 'ㅜ':
                    System.out.println("\n- 간식비 지급을 취소합니다.");
                    break;
            }
        }else {
            bestEmployee.setAccount(bestEmployee.getAccount()+money);
            budget -= money;
            System.out.printf("%s사원에게 간식비 지급을 완료하였습니다.", bestEmployee.getName());
        }
    }

    // 간식비 계좌인 budget을 출력
    public void printSnackCost(){
        System.out.println(budget);
    }

    private String inputStr(String msg) {
        System.out.printf(msg);
        return sc.next();
    }

    // 숫자 입력받기
    private int inputInt(String msg) {
        System.out.printf(msg);
        return sc.nextInt();
    }



    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int money) {
        this.budget = money;
    }
}


    //manageEmployee(id, password)  [직원 관리 위임받음]
    //  3-1. 직원 정보 조회
    //  printEmployee()
    //  3-2 직원 전체 정보 조회
    //  printAllEmployee()
    //  3-2 직원 수정
    //  updateEmployee()
    //  3-3 직원 삭제
    //  delEmployee()
    //  3-4 간식비 각자 계좌에 돈을 넣기


