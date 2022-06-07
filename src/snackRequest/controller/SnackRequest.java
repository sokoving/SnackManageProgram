package snackRequest.controller;


import snack.controller.SnackPantry;
import snack.model.vo.Snack;
import view.EmployeePage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SnackRequest {

    //    private Request[] requests;
    private String[] requests;
    private int numRequests;
    private SnackPantry pantry; /////////////////// SnackPantry 생성 /////////////////////
    private static final int MAX_REQUEST = 10;

    public SnackRequest(SnackPantry pantry) {
        requests = new String[MAX_REQUEST];
        this.pantry = pantry;
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
    public int closeRequest() {

        System.out.print("간식 가격: ");
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("간식 수량: ");
        int stock = sc.nextInt();
        sc.nextLine();

        // 간식 이름과 신청수 매칭해서 넣어주는 맵
        Map<String, Integer> map = new HashMap();
        for (String request : requests) {
            if (request != null) {
                if (!map.containsKey(request)) map.put(request, 1);
                else map.put(request, map.get(request) + 1);
            }
        }

        String select = "";
        int max = 0;
        // 가장 많이 신청된 간식 이름과 개수 구하기
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                select = entry.getKey();
                System.out.println("select = " + select);
            }
        }
        System.out.println("=============");
        System.out.println("max = " + max);
        System.out.println("select = " + select);

        // empty가 아닐 경우에 탕비실에 추가
        if (!select.isEmpty()) pantry.add(select, price, stock);

        return price * 10;

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

    // 신청서를 리셋하는 메서드
    public void resetRequest() {
        requests = new String[MAX_REQUEST];
        numRequests = 0;
    }

    // 이름의 개수를 리턴하는 메서드
    public int searchByName(String name) {
        int num = 0;
        for (String request : requests) {
            if (name.equals(request)) num++;
        }
        return num;
    }

    public int getNumRequests() {
        return numRequests;
    }

    public void setNumRequests(int numRequests) {
        this.numRequests = numRequests;
    }
}