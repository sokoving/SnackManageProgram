package snackRequest.controller;


import java.util.HashMap;
import java.util.Map;


public class SnackRequest {

    //    private Request[] requests;
    private String[] requests;
    private int numRequests;
    private static final int MAX_REQUEST = 10;

    public SnackRequest() {
        requests = new String[MAX_REQUEST];
    }

    // 신청한 과자를 신청서 리스트에 추가하는 메서드
    public void add(String request) {
        if (numRequests == 10) {
            System.out.println("더이상 신청할 수 없습니다."); // idk something like this
        } else {
            System.out.printf("%s가 신청서에 추가되었습니다.\n", request);
            requests[numRequests++] = request;
        }
    }

    public void closeRequest() {

        Map<String, Integer> map = new HashMap();
        for (String request : requests) {
            if (!map.containsKey(request)) map.put(request, 1);
            else map.put(request, map.get(request) + 1);
        }

        String select = "";
        int max = map.get(0);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                select = entry.getKey();
            }
        }

        if (!select.isEmpty()) add(select);

    }

    public void printRequests() {
        for (String request : requests) {
            if (request != null) System.out.println(request);
        }
    }

}
