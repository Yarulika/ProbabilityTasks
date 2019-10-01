package monteCarloPi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PiTest {

    @Test
    public void getTotalNumberOfPoints() {
        List<String> lines = new ArrayList<String>();
        lines.add("hello");
        lines.add(" ");
        lines.add("0,666");
        lines.add("");
        lines.add("!22");
        lines.add("-7");
        lines.add("0");
        lines.add("22");
        Assert.assertEquals(22, Pi.getTotalNumberOfPoints(new TestConsole(lines)));
    }

    @Test
    public void calculatePi() {
        double piOne = Pi.calculatePi(1000);
        double piTwo = Pi.calculatePi(1000000);
        Assert.assertTrue(piOne>3 && piOne<4);
        Assert.assertTrue(Math.abs((Math.PI-piOne)) > Math.abs((Math.PI-piTwo)));
    }
}
