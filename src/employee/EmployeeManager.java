package employee;


public class EmployeeManager {
    //===========필드

    // 사원 정보 배열에 관리
    private Employee[] e = new Employee[SIZE];

    // 이 회사의 직원은 10명 고정 상수 변수 SIZE
    public static final int SIZE = 10;

    //========= 생성자
    // 생성시 Employee 초기화
    public EmployeeManager() {
        e[0] = new Employee("00000", "1234a", "김철수", "abc@naver.com", "영업", "과장",0);
        e[1] = new Employee("00001", "1235b", "홍길동", "abe@naver.com", "관리","대리",0);
        e[2] = new Employee("00002", "1236c", "김지우", "abf@naver.com", "총무","사원",0);
        e[3] = new Employee("00003", "1237d", "윤이슬", "abq@naver.com", "인사","주임",0);
        e[4] = new Employee("00004", "1238e", "송민호", "abx@naver.com", "영업","대리",0);
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
    }    ;


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
        Employee [] temp = new Employee[count];
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
        if(delIdx != -1) {
            for (int i = delIdx; i < existEmployee()-1 ; i++) {
                e[i] = e[i + 1];
            }
            e[existEmployee()-1] = null;
            return true;
        }
        return false;
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

}
