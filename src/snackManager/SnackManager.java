package snackManager;

import snack.controller.SnackPantry;
import snackRequest.controller.SnackRequest;
import view.SnackPage;

public class SnackManager {

    SnackPantry pantry;
    SnackRequest request;
    SnackPage snackPage;


    //    ----생성자-----
    public SnackManager(SnackPantry pantry, SnackRequest request, SnackPage snackPage) {
        this.pantry = pantry;
        this.request = request;
        this.snackPage = snackPage;
    }

//    ----메서드-----

    // 간식 이름, 가격, 수량을 입력받아 구매하고 내역을 문자열로 리턴하는 메서드
    public String buySnack(String snackName, int snackPrice, int snackStock) {
        // 예산이 가격 * 수량보다 크다 > 버젯에서 구입 금액을 빼고 펜트리에 넣기
        String msg;
        int totalPrice = snackPrice*snackStock;
        int budget = snackPage.getBudget();
        if ( budget >= totalPrice ){
            snackPage.setBudget(budget-totalPrice);
            pantry.add(snackName, snackPrice, snackStock);
            msg = String.format("[입고] %s : %d원 | %d개", snackName, snackPrice, snackStock);
        } else {
            msg = null;
        }
        return msg;
    }
/*
    private void buySnack() {
        // 예산이 가격 * 수량보다 적으면
        // 팬트리에 그 스낵을 넣고
        // 버젯에서 구입 금액을 뺀다
        if ( budget >= snackPrice*snackStock){
            budget -= snackPrice*snackStock;
            pantry.add(snackName, snackPrice, snackStock);
        } else {
            System.out.println("간식비 잔고가 부족합니다.");
        }
    }
 */
}