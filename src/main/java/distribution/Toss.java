package distribution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Toss {

    public static void main(String... args) {
        Map<Integer, Integer> tossesMap = new HashMap<Integer, Integer>();
        Random random = new Random();
        int timesNo = 1000;
        int x;

        for (int k = 0; k < timesNo; k++) {
            System.out.println("--- Time: " + k + " ---");
            int i = 0; //attempts counter
            do {
                x = random.nextInt(2);
                i++;
                System.out.println("on random " + i + " x=" + x);
            }
            //1 - heads, 0 - tails (toss until tails)
            while (x == 1);
            System.out.println("Tailed on attempt = " + i);

            // add (or increase) an attempt number in map
            if (tossesMap.containsKey(i)) {
                tossesMap.put(i, tossesMap.get(i) + 1);
            } else {
                tossesMap.put(i, 1);
            }
        }

        //results
        System.out.println("--- RESULT: percentages of all the length strikes ---");
        for (Map.Entry<Integer, Integer> pair : tossesMap.entrySet()){
            double percentages = (pair.getValue() * 100 / (double)timesNo);
            System.out.println("Tails after " + pair.getKey() + " : " + String.format("%.1f", percentages) + "%" );
        }
    }
}
