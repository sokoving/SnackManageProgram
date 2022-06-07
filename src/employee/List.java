package employee;

public class List {
    private String time;// 송금 시간
    private String history;// 송금 내역
    private int amount; // 송금 금액

    public List(String time, String history, int amount) {
        this.time = time;
        this.history = history;
        this.amount = amount;
    }

    public String inform(){
        return String.format("%s | %s | %s |",time,history,amount);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
