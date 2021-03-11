package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Testcase: "+result.getName()+" Execution started.");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Status: PASSED");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Status: FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Status: IGNORED");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("TESTING STARTED");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TEST EXECUTION FINISHED");
    }
}
