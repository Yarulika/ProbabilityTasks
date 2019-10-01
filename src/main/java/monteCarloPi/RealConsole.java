package monteCarloPi;

import java.util.Scanner;

public class RealConsole implements Console {
    Scanner scanner = new Scanner(System.in);

    public String readLine(){
        return scanner.nextLine();
    }

    public void writeLine(String writeString){
        System.out.println(writeString);
    }

}
