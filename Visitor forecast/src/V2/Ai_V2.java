package V2;

import java.security.Key;
import java.time.Year;
import java.util.*;

public class Ai_V2 {
    public final static String inputAMessage = "[안내] A값을 입력해 주세요";
    public final static String inputBMessage = "[안내] B값을 입력해 주세요";


    public static void startMessage() {
        System.out.println("\n [인공지능 프로그램 V2]");
        System.out.println("=".repeat(25));

    }

    public static ArrayList<Integer> priceInput() {
        ArrayList<Integer> price = new ArrayList<>();
        String input1 = "";
        String exit;
        int inputPrice = 0;
        int boolean1 = -1;

        System.out.print("[System]예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원) :");
        do {
            input1 = Input.input();

            if (IsValid.isValid(input1)) {
                inputPrice = Integer.parseInt(input1);
                price.add(inputPrice);
                System.out.println("[안내] 광고비를 추가하시겠습니까? \nY/N");
                do {
                    String exitInput = Input.input().toUpperCase();
                    switch (exitInput) {
                        case "Y":
                            boolean1 = -2;
                            System.out.println("[안내] 추가할 광고비를 입력해주세요");
                            inputPrice = Integer.parseInt(input1);
                            price.add(inputPrice);
                            break;
                        case "N":
                            boolean1 = -1;
                            break;
                        default:
                            System.out.println("Y/N 중 입력해주세요.");
                            boolean1 = -2;
                            break;
                    }
                } while (!(boolean1 == -1));

            } else {
                System.out.println("[안내] 정확한 가격을 입력하여 주세요.");
                boolean1 = -2;
            }
        }
        while (!(boolean1 == -1));

        return price;
    }


    public static int input(String str) {
        String input1 = "";
        String input2 = "";
        int inputNuma = 0;
        int inputNumb = 0;

        do {
            System.out.println(str);
            input1 = Input.input();

            if (IsValid.isValid(input1)) {
                inputNuma = Integer.parseInt(input1);
            } else {
                System.out.println("[안내] 정확한 가격을 입력하여 주세요.");
            }
        }
        while (!IsValid.isValid(input1));
        return inputNuma;
//        아래메서드 실행하면 트루 펄스값을 반환 숫자가 맞다면 false를 아니라면 true를 반환

    }

    //추가가능하도록 입력받은 어레이리스트에서 인덱스와 벨류(가격)값을 가져온 후 해시맵으로 만들면서 벨류값을 예측값 (a * price ) + b 으로 넣어준다
    public static HashMap<Integer, Integer> aiPredictionMap(int inputA, int inputB, ArrayList<Integer> priceArrayList) {
        HashMap<Integer, Integer> priceMap1 = new HashMap<>();
        Iterator<Integer> iterator = priceArrayList.iterator();

        int index = 0;
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            priceMap1.put(index, inputA * value + inputB);
            index++;
        }
        return priceMap1;
    }

    public static void aiPredictionMessege(HashMap<Integer, Integer> aiPredictionMap) {
        System.out.println("\n[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.");

        for (int i = 0; i < aiPredictionMap.size(); i++) {
            System.out.printf(i + 1 + "번째 예측 " + "%d회 방문\n", aiPredictionMap.get(i));
        }
    }


    public static void printPriceList(ArrayList<Integer> priceList) {
        Iterator<Integer> iterator = priceList.iterator();
        System.out.println("[안내] 입력된 광고비 목록:");
        int index = 0;
        while (iterator.hasNext()) {
            System.out.printf("%d번 %d원 ", index++ +1, iterator.next());
        }
    }

}