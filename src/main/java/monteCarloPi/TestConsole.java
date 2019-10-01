package monteCarloPi;

import java.util.List;

/**
 *  Implemented for mocking in tests stdin/stdout
 */
public class TestConsole implements Console {
    private List<String> testOutput;

    public TestConsole(List<String> testOutput) {
        this.testOutput = testOutput;
    }

    public String readLine(){
        String line = testOutput.get(0);
        System.out.println("Read: " + line);
        testOutput.remove(0);
        return line;
    }

    public void writeLine(String writeString){
        System.out.println("Write: " + writeString);
    }
}
