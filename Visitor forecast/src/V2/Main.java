package V2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> priceArrayList = new ArrayList<>();
        HashMap<Integer,Integer> priceMap = new HashMap<>();
        int inputA;
        int inputB;


        Ai_V2.startMessage();
        inputA = Ai_V2.input(Ai_V2.inputAMessage);
        inputB = Ai_V2.input(Ai_V2.inputBMessage);
        priceArrayList = Ai_V2.priceInput();
        Ai_V2.printPriceList(priceArrayList);
        priceMap = Ai_V2.aiPredictionMap(inputA,inputB,priceArrayList);
        Ai_V2.aiPredictionMessege(priceMap);













    }
}