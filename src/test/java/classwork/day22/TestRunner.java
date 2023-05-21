package classwork.day22;

import org.junit.runner.JUnitCore;

public class TestRunner {

    public static void main(String[] args) {

        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new MyJUnIut4Listener());
        jUnitCore.run(TestRail.class);
        jUnitCore.run(TestRailTwo.class);
        jUnitCore.run(TestRailThree.class);
        jUnitCore.run(TestRailFour.class);

    }
}
