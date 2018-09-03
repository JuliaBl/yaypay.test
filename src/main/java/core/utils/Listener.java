package core.utils;

import io.qameta.allure.TmsLink;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.lang.reflect.Method;
import static core.logger.Logger.LOGGER;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        try {
            Method testMethod;
            if (result.getParameters().length > 0) {
                for (Object param : result.getParameters()) {
                    LOGGER.info("Test : " + result.getMethod().getMethodName() + "[" + param + "]" + " is started");
                }
            } else {
                testMethod = result.getInstance().getClass().getMethod(result.getMethod().getMethodName());
                LOGGER.info("Test : " + testMethod.getName() + " is started");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            Method method;
            if (result.getParameters().length > 0) {
                String methodName = result.getMethod().getMethodName();
                method = result.getInstance().getClass().getMethod(methodName, String.class);
                if (method.isAnnotationPresent(TmsLink.class)) {
                    LOGGER.info("Test case in jira: " + method.getAnnotation(TmsLink.class).value() + " PASSED");
                }
            } else {
                method = result.getInstance().getClass().getMethod(result.getMethod().getMethodName());
                if (method.isAnnotationPresent(TmsLink.class)) {
                    LOGGER.info("Test case in jira: " + method.getAnnotation(TmsLink.class).value() + " PASSED");
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Method method;
            if (result.getParameters().length > 0) {
                String methodName = result.getMethod().getMethodName();
                method = result.getInstance().getClass().getMethod(methodName, String.class);
                if (method.isAnnotationPresent(TmsLink.class)) {
                    LOGGER.info("Test case in jira: " + method.getAnnotation(TmsLink.class).value() + " FAILED");
                }
            } else {
                method = result.getInstance().getClass().getMethod(result.getMethod().getMethodName());
                if (method.isAnnotationPresent(TmsLink.class)) {
                    LOGGER.info("Test case in jira: " + method.getAnnotation(TmsLink.class).value() + " FAILED");
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            Method method;
            if (result.getParameters().length > 0) {
                String methodName = result.getMethod().getMethodName();
                method = result.getInstance().getClass().getMethod(methodName, String.class);
                if (method.isAnnotationPresent(TmsLink.class)) {
                    LOGGER.info("Test case in jira: " + method.getAnnotation(TmsLink.class).value() + " SKIPPED");
                }
            } else {
                method = result.getInstance().getClass().getMethod(result.getMethod().getMethodName());
                if (method.isAnnotationPresent(TmsLink.class)) {
                    LOGGER.info("Test case in jira: " + method.getAnnotation(TmsLink.class).value() + " SKIPPED");
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}