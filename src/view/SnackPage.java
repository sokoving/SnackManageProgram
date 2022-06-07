package view;


import snack.controller.SnackPantry;
import snack.model.vo.Snack;
import snackRequest.controller.SnackRequest;

import java.util.Scanner;

public class SnackPage {
    Scanner sc = new Scanner(System.in);

    private SnackPantry pantry;
    private SnackRequest request;
    private int budget = 100000;

    public SnackPage(SnackPantry pantry, SnackRequest request) {
        this.pantry = pantry;
        this.request = request;
    }

    // 2. 간식 관리자 메뉴
    public void SnackManagerMenu() {
        while (true) {
            System.out.println("======================================");
            System.out.println("# 간식관리자의 페이지입니다.");
            System.out.println("1. 탕비실 재고 관리");
            System.out.println("2. 간식 신청서 관리");
            System.out.println("3. 간식 구입");
            System.out.println("4. 간식비 조회");
            System.out.println("9. 이전 페이지로 돌아가기");

            String menu = inputStr("\n메뉴 번호: ");
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 탕비실 재고 관리
                    managePantryStock();
                    break;
                case 2:
                    // 간식 신청서 관리
                    manageSnackRequest();
                    break;
                case 3:
                    // 간식 구입
                    manualbuySnack();
                    break;
                case 4:
                    // 간식비 관리
                    manageSnackBudget();
                    break;

                case 9:
                    // 이전 페이지로 돌아가기
                    System.out.println("이전 페이지로 돌아가기");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch
        } // end while

    }


    //---------------- case1 1. 탕비실 재고 관리 ----------------//
    private void managePantryStock() {
        while (true) {
            System.out.println("\n# 탕비실 재고 관리 페이지입니다.");
            System.out.println("======================================");
            pantry.printSnackPantry();
            System.out.println("======================================");
            System.out.println("1. 재고 데이터 수정");
            System.out.println("2. 재고 데이터 삭제");
            System.out.println("3. 간식 추가 구매");
            System.out.println("4. 간식 반품하기");
            System.out.println("9. 이전 페이지로 돌아가기");

            String menu = inputStr("\n메뉴 번호: ");
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 1. 재고 데이터 수정
                    updateStockData();
                    break;
                case 2:
                    // 2. 재고 데이터 삭제
                    removeStockData();
                    break;
                case 3:
                    //3. 재고 추가 구매(상품 이름을 받고(재고 이름과 일치할 때까지) 수량을 받아 더하고, 버젯에 반영)
                    refillStock();
                    break;
                case 4:
                    //4. 간식 반품하기
                    returnStock();
                    break;

                case 9:
                    // 이전 페이지로 돌아가기
                    System.out.println("이전 페이지로 돌아가기");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch
        } // end while
    }// ena case1

    // 1-1 재고 데이터 수정
    private void updateStockData() {
        if (pantry.getCount() <= 0) {
            System.out.println("수정할 간식 데이터가 없습니다.");
            return;
        }
        System.out.println("\n# 수정할 간식 데이터의 이름을 입력해 주세요. ");
        String targetName = inputStr(">> ");
        int targetIdx = pantry.findIndexByName(targetName);
        // 수정 시작
        if (targetIdx >= 0) {
            Snack[] snacks = pantry.getSnacks();
            // 입력받아 수정하기
            System.out.printf("이름: %s ", snacks[targetIdx].getName());
            snacks[targetIdx].setName(inputStr(" >> "));
            System.out.printf("가격: %d원 ", snacks[targetIdx].getPrice());
            snacks[targetIdx].setPrice(inputInt(" >> "));
            System.out.printf("수량: %d개 ", snacks[targetIdx].getStock());
            snacks[targetIdx].setStock(inputInt(" >> "));
            // 결과 메시지 출력
            System.out.printf("[수정] 간식 이름: %s / 간식 가격 : %d / 간식 재고: %d\n",
                    snacks[targetIdx].getName(), snacks[targetIdx].getPrice(), snacks[targetIdx].getStock());
        } else {
            System.out.println("수정할 간식 데이터가 없습니다.");
        }
    }

    // 1-2. 재고 데이터 삭제
    private void removeStockData() {
        // 배열에 존재하는 데이터가 없을 때
        if (pantry.getCount() <= 0) {
            System.out.println("삭제할 간식 데이터가 없습니다.");
            return;
        }
        System.out.println("\n# 삭제할 간식 데이터의 이름을 입력해 주세요. ");
        String targetName = inputStr(">> ");
        int targetIdx = pantry.findIndexByName(targetName);
        // idx 존재할 경우 삭제 시작
        if (targetIdx >= 0) {
            Snack dellSnack = pantry.removeSnackById(targetIdx);
            // 결과 메시지 출력
            System.out.printf("[삭제] 간식 이름: %s / 간식 가격 : %d / 간식 재고: %d\n",
                    dellSnack.getName(), dellSnack.getPrice(), dellSnack.getStock());

        } else {
            System.out.println("삭제할 간식 데이터가 없습니다.");
        }
    }

    // 1-3 재고 추가 구매
    private void refillStock() {
        System.out.println("\n# 재구매할 상품의 이름을 입력해 주세요. ");
        String targetName = inputStr(" >> ");
        int targetIdx = pantry.findIndexByName(targetName);
        // 입력받은 문자와 배열의 과자 이름 중 하나와 동일할 때
        if (targetIdx >= 0) {
            Snack refillSnack = pantry.getSnacks()[targetIdx];
            int refillPrice = refillSnack.getPrice() * 10;
            // 예산이 구매대금보다 클 때
            if (budget >= refillPrice) {
                int refillStock = refillSnack.getStock();
                refillStock += 10;
                budget -= refillPrice;
                pantry.getSnacks()[targetIdx].setStock(refillStock);
                System.out.println("[추가 구매] " + pantry.getSnacks()[targetIdx].inform());
            } else {
                System.out.println("잔액 부족으로 간식 구매에 실패하였습니다.");
            }
        } else {
            System.out.println("추가 구매 대상이 아닙니다.");
        }
    }

    // 1-4. 간식 반품하기
    private void returnStock() {
        System.out.println("\n# 반품할 상품의 이름을 입력해 주세요. ");
        String targetName = inputStr(" >> ");
        int targetIdx = pantry.findIndexByName(targetName);
        // 입력받은 문자와 배열의 과자 이름 중 하나와 동일할 때
        if (targetIdx >= 0) {
            System.out.println("전체 반품은 0, 일부 반품은 수량을 입력해 주세요. ");
            // 수량을 입력받아
            int returnStock = Integer.parseInt(inputStr(" >> "));
            int targetStock = pantry.getSnacks()[targetIdx].getStock();
            int targetPrice = pantry.getSnacks()[targetIdx].getPrice();
            // 전체 환불
            if (returnStock <= 0) {
                System.out.printf("%s %d개를 전체 반품합니다. \n", targetName, targetStock);
                budget += targetStock * targetPrice;
                pantry.getSnacks()[targetIdx].setStock(0);
            }
            // 부분 환불
            else if (returnStock <= targetStock) {
                System.out.printf("%s %d개를 반품합니다. \n", targetName, returnStock);
                budget += returnStock * targetPrice;

                pantry.getSnacks()[targetIdx].setStock(targetStock - returnStock);
            }
            // 환불 실패
            else {
                System.out.println("수량 입력이 잘못되었습니다. ");
            }
            // 과자 이름이 목록에 없을 때
        } else {
            System.out.println("반품 대상이 아닙니다.");
        }

    }

    //---------------- case 2. 간식 신청서 관리 ----------------//
    private void manageSnackRequest() {
        while (true) {
            System.out.println("\n# 간식 신청서 관리 페이지입니다.");
            System.out.println("======================================");
            if(request.getNumRequests() <= 0){
                System.out.println("[현재 신청 간식이 없습니다.]");
            } else {
                request.printRequests();
            }
            System.out.println("======================================");
            System.out.println("1. 신청 간식 수동 구매");
            System.out.println("2. 신청 간식 자동 구매");
            System.out.println("3. 신청서 리셋하기");
            System.out.println("9. 이전 페이지로 돌아가기");

            String menu = inputStr("\n메뉴 번호: ");
            switch (Character.getNumericValue(menu.charAt(0))) {
                case 1:
                    // 1. 신청 간식 수동 구매
                    manualAcceptRequest();
                    break;
                case 2:
                    // 2. 신청 간식 자동 구매
                    autoAcceptRequest();
                    break;
                case 3:
                    // 3. 신청서 삭제하기
                    clearRequest();
                    break;
                case 9:
                    // 이전 페이지로 돌아가기
                    System.out.println("이전 페이지로 돌아가기");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.\n 다시 입력하세요.");
            } // end switch
        } // end while
    }

    // 2-1 신청 간식 수동 구매
    private void manualAcceptRequest() {
        if (request.getNumRequests() <= 0) {
            System.out.println("현재 신청 간식이 없습니다.");
            return;
        }

        System.out.println("\n# 구매할 간식의 이름을 입력해 주세요. ");
        String targetName = inputStr(">> ");
        int targetNum = request.searchByName(targetName);
        // 이름이 신청서에 없을 때
        if (targetNum <= 0) {
            System.out.printf("%s(은)는 신청받지 않은 간식입니다. \n", targetName);
            System.out.println("그래도 구입하시겠습니까? [Y/N] ");
            while (true) {
                String answer = inputStr(" >> ");
                switch (answer.toUpperCase().charAt(0)) {
                    case 'Y':
                        buySnackByPrice(targetName);
                        return;
                    case 'N':
                        System.out.println("이전 페이지로 돌아갑니다.");
                        return;
                    default:
                        System.out.println("Y와 N 둘 중 하나를 입력해 주세요.");
                }
            }
        }
        // 이름이 신청서에 있을 때
        else {
            System.out.printf("%s(은)는 현재 %d 번 신청되었습니다. \n", targetName, targetNum);
            System.out.println("구입하시겠습니까? [Y/N] ");
            while (true) {
                String answer = inputStr(" >> ");
                switch (answer.toUpperCase().charAt(0)) {
                    case 'Y':
                        buySnackByPrice(targetName);
                        return;
                    case 'N':
                        return;
                    default:
                        System.out.println("Y와 N 둘 중 하나를 입력해 주세요.");
                }
            }
        }
    }

    // 2-2. 신청 간식 자동 구매
    private void autoAcceptRequest() {
        System.out.println("\n# 가장 많은 신청을 받은 품목을 구매합니다.");
        System.out.println("계속하시겠습니까? [Y/N] ");
        while (true) {
            String answer = inputStr(" >> ");
            switch (answer.toUpperCase().charAt(0)) {
                case 'Y':
                    int money = request.closeRequest();
                    budget -= money;
                    return;
                case 'N':
                    return;
                default:
                    System.out.println("Y와 N 둘 중 하나를 입력해 주세요.");
            }
        }
    }

    // 2-3 신청서 삭제하기
    private void clearRequest() {
        System.out.println("\n # 신청받은 항목을 전체 지웁니다.");
        System.out.println("계속하시겠습니까? [Y/N] ");
        while (true) {
            String answer = inputStr(" >> ");
            switch (answer.toUpperCase().charAt(0)) {
                case 'Y':
                    request.resetRequest();
                    return;
                case 'N':
                    return;
                default:
                    System.out.println("Y와 N 둘 중 하나를 입력해 주세요.");
            }
        }
    }

    //---------------- case 3. 간식 구입 ----------------//
    private void manualbuySnack() {
        System.out.println("\n# 간식을 구입하는 페이지입니다.");
        System.out.println("구입을 계속하시겠습니까? [Y/N] ");
        while (true) {
            String answer = inputStr(" >> ");
            switch (answer.toUpperCase().charAt(0)) {
                case 'Y':
                    buySnack();
                    return;
                case 'N':
                    System.out.println("이전 페이지로 돌아갑니다.");
                    return;
                default:
                    System.out.println("Y와 N 둘 중 하나를 입력해 주세요.");
            }
        }
    }

    //---------------- case 4. 간식비 관리----------------//
    private void manageSnackBudget() {
        System.out.println("\n# 간식비를 관리하는 페이지입니다.");
        System.out.println("간식비 잔액: " + budget);
        System.out.println("탕비실 현금: " + pantry.getMoney());
        System.out.println("탕비실의 현금을 회수하시겠습니까? [Y/N] ");
        while (true) {
            String answer = inputStr(" >> ");
            switch (answer.toUpperCase().charAt(0)) {
                case 'Y':
                    System.out.println("회수 전 잔고 : " + budget);
                    budget += pantry.getMoney();
                    pantry.setMoney(0);
                    System.out.println("회수 후 잔고 : " + budget);
                    return;
                case 'N':
                    System.out.println("이전 페이지로 돌아갑니다.");
                    return;
                default:
                    System.out.println("Y와 N 둘 중 하나를 입력해 주세요.");
            }
        }
    }



    //  간식 구매하는 메서드
    private void buySnack() {
        // 간식 이름, 가격, 수량을 입력받아 구매한 결과 출력
        System.out.println("간식비 잔고: " + budget);
        String snackName = inputStr("간식 이름: ");
        int snackPrice = inputInt("간식 가격: ");
        int snackStock = inputInt("간식 수량: ");
        if (budget >= snackPrice * snackStock) {
            pantry.add(snackName, snackPrice, snackStock);
            budget -= snackPrice * snackStock;
            System.out.printf("[구매] 간식 이름: %s / 간식 가격 : %d / 간식 재고: %d\n",
                    snackName, snackPrice, snackStock);
        } else {
            System.out.println("잔액 부족으로 간식 구매에 실패하였습니다.");
        }
    }

    // 간식 가격과 수량을 입력받아 구매
    private void buySnackByPrice(String snackName) {
        System.out.println("간식비 잔고: " + budget);
        int snackPrice = inputInt("간식 가격: ");
        int snackStock = inputInt("간식 수량: ");
        if (budget >= snackPrice * snackStock) {
            pantry.add(snackName, snackPrice, snackStock);
            budget -= snackPrice * snackStock;
            System.out.printf("[구매] 간식 이름: %s / 간식 가격 : %d / 간식 재고: %d\n",
                    snackName, snackPrice, snackStock);
        } else {
            System.out.println("잔액 부족으로 간식 구매에 실패하였습니다.");
        }
    }


    // 문자열 입력 받기
    private String inputStr(String msg) {
        System.out.printf(msg);
        return sc.next();
    }

    // 숫자 입력받기
    private int inputInt(String msg) {
        System.out.printf(msg);
        return sc.nextInt();
    }
}