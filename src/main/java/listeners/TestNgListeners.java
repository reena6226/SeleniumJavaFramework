package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListeners implements ITestListener{

    public void onTestStart(ITestResult result) {
        System.out.println("******Test Started******* : "+result.getName());
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("******Test Success******* : "+result.getName());
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("******Test Failure******* : "+result.getName());
    }

    public void onTestSkipped(ITestResult result) {

        System.out.println("******Test Skipped******* : "+result.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {

        System.out.println("******Test Finish******* : "+context.getName());
    }

}
