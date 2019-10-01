package monteCarloPi;

import java.util.Random;

public class Pi {

    public static void main(String... args) {
        Console console = new RealConsole();
        console.writeLine("=== Estimating Pi using the Monte Carlo Method ===");

        String answer;
        do {
            int numberDotsTotal = getTotalNumberOfPoints(console);
            console.writeLine("Estimated Pi: " + calculatePi(numberDotsTotal));
            console.writeLine("Estimate ones again? Type: yes (or anything to finish)");
            answer = console.readLine().toLowerCase();
        }
        while (answer.equals("yes"));
    }

    public static double calculatePi(int numberDotsTotal) {
        double radius = 0.5d;
        int numberDotsInner = 0;
        for (int i = 0; i < numberDotsTotal; i++) {
            Random rnd = new Random();
            double rndX = -radius + rnd.nextDouble();
            double rndY = -radius + rnd.nextDouble();
            double distance = Math.pow((Math.pow(rndX, 2) + Math.pow(rndY, 2)), 0.5);
            if (distance <= radius) {
                numberDotsInner++;
            }
        }
        double pi = (4.0 * numberDotsInner / numberDotsTotal);
        return pi;
    }

    public static int getTotalNumberOfPoints(Console console) {
        while (true) {
            console.writeLine("Fill in total number of points to estimate Pi:");
            try {
                int checkNo = Integer.parseInt(console.readLine());
                if (checkNo > 0) {
                    return checkNo;
                } else {
                    console.writeLine("Number has to be more than zero");
                }
            } catch (NumberFormatException ex) {
                console.writeLine("Not a valid non‐negative integer value");
            }
        }
    }
}
