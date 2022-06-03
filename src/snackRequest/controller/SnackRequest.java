package snackRequest.controller;

import snackRequest.model.vo.Request;

public class SnackRequest {

    private Request[] requests;
    private int numRequests;
    private static final int MAX_REQUEST = 10;

    public SnackRequest() {
        requests = new Request[MAX_REQUEST];
    }

    // 신청한 과자를 신청서 리스트에 추가하는 메서드
    public void add(Request request) {
        if (numRequests == 10) {
            System.out.println("더이상 신청할 수 없습니다."); // idk something like this
        } else {
            System.out.printf("%s가 신청서에 추가되었습니다.", request.getName());
            requests[numRequests++] = request;
        }
    }

}
