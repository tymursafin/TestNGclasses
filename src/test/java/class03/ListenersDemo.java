package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Good job, body!");
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("thumbs down");
    }

}
