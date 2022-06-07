package employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListController {
    private List[] l = new List[20];

    public ListController(){};

    // List배열의 자료가 들어가 있는 인덱스 길이 구하기
    public int existList(){
        int count = 0;
        for (List list : l) {
            if(list == null) break;
            count++;
        }
        return count;
    }

    // List배열의 주소값 리턴
    public List[] printList(){
        return l;
    }

    // 데이터 삽입
    public void insert(String time, String histroy, int amount){
        int index = existList();
        l[index] = new List(time,histroy,amount);
        System.out.println(l[index].inform());
    }


}
