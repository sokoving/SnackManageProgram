package snackRequest.controller;


import snack.controller.SnackPantry;
import snack.model.vo.Snack;
import view.EmployeePage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SnackRequest {

    //    private Request[] requests;
    private String[] requests;
    private int numRequests;
    private SnackPantry pantry; /////////////////// SnackPantry 생성 /////////////////////
    private static final int MAX_REQUEST = 10;

    public SnackRequest() {
        requests = new String[MAX_REQUEST];
        pantry = new SnackPantry();
        requests[0] = "ace";
        requests[1] = "ace";
        requests[2] = "chocolate";
        requests[3] = "coffee";
        requests[4] = "ace";
        requests[5] = "coffee";
        requests[6] = "juice";
        requests[7] = "coffee";
        requests[8] = "juice";
        requests[9] = "coffee";
    }

    // 신청한 과자를 신청서 리스트에 추가하는 메서드
    public void add(String request) {
        if (numRequests == 10) {
            System.out.println("더이상 신청할 수 없습니다."); // 신청서가 찼을 경우
        } else { // 신청서에 간식 이름 추가
            System.out.printf("%s가 신청서에 추가되었습니다.\n", request);
            requests[numRequests++] = request;
        }
    }

    // 간식 신청 마감, 가장 많이 신청된 간식 추가
    public void closeRequest() {
        // 간식 이름과 신청수 매칭해서 넣어주는 맵
        Map<String, Integer> map = new HashMap();
        for (String request : requests) {
            if (!map.containsKey(request)) map.put(request, 1);
            else map.put(request, map.get(request) + 1);
        }

        String select = "";
        int max = 0;
        // 가장 많이 신청된 간식 이름과 개수 구하기
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                select = entry.getKey();
            }
        }

        // empty가 아닐 경우에 탕비실에 추가
        if (!select.isEmpty()) pantry.add(select);

    }

    // 신청서 출력
    public void printRequests() {
        for (String request : requests) {
            if (request != null) System.out.println(request);
        }
    }

    public SnackPantry getPantry() {
        return pantry;
    }
}
