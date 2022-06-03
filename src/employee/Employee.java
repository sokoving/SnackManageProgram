package employee;

public class Employee {
    //===============필드
    private String number; // 사원번호
    private String name; // 사원이름
    private String password; // 비밀번호

    private String email; // email
    private String department; //부서이름
    private String position; // 직책
    private int account; //간식비 계좌

    //============생성자
    public Employee(String number, String password, String name, String email, String department, String position, int account) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.email = email;
        this.department = department;
        this.position = position;
        this.account = account;
    }

    //===========메서드

    // employee 정보출력
    public String inform() {
        return String.format("# %s | %s | %s | %s | %s | %s | %d "
                , number, name, password, email, department, position, account);
    }

    public String getNumber() {
        return number;
    }

    // 사원번호가 조회 기준이 되므로 수정 불가
    // 사원번호는 5자리 제한, 사원 번호가 5자리이면 true 리턴
    public boolean setNumber(String number) {
        if(number.length() == 5) {
            return true;
        } else {
            return false;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
