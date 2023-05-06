package classwork.day19.cucumber;

import org.junit.Test;

public class DemoJunitTest {

    DemoSteps demoSteps = new DemoSteps();

    @Test
    public void MyDemo() {
        demoSteps.iOpenDemoGSite();
        demoSteps.iFillInTheForm("bugaga");
        demoSteps.iNeedToSeeSomething();
    }

    @Test
    public void MyDemoTwo() {
        demoSteps.iOpenDemoGSite();
        demoSteps.iFillInTheForm("vuga");
        demoSteps.iNeedToSeeSomething();
    }

}
