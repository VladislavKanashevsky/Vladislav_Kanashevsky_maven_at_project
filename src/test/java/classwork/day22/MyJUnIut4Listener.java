package classwork.day22;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class MyJUnIut4Listener extends RunListener {

    boolean isFailde;

    public void testStarted(Description description) throws Exception {
        System.out.println("Executing test : " + description.getDisplayName());
        String id = description.getAnnotation(TestCaseId.class).id();
        System.out.println("Test ID is : " + id);
    }

    public void testFinished(Description description) throws Exception {
        if (!isFailde) {
            String id = description.getAnnotation(TestCaseId.class).id();
            TestRailReporter.reportResult("2208", id, new Result(5));
        }
        System.out.println("Finishing test : " + description.getDisplayName());
        isFailde = false;
    }
    public void testFailure(Failure failure) throws Exception {
        isFailde = true;
        System.out.println("Failure test : " + failure.getDescription().getDisplayName());
        String id = failure.getDescription().getAnnotation(TestCaseId.class).id();
        TestRailReporter.reportResult("2208", id, new Result(5));
    }
}
