package project.runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project.pages.page_school.School;
import project.tests.junit4.BookingTest;
import project.tests.junit4.DemoqaTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({BookingTest.class, DemoqaTest.class, School.class})

public class JunitRunner {

}
