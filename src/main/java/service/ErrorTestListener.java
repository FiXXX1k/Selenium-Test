package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ErrorTestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(ErrorTestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {}

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("УСПЕХ: " + iTestResult.getInstanceName().toUpperCase() + " тест: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Attachment.attachScreenshot("PAGE-SCREENSHOT");
        Attachment.attachAsText("INFO",
                "Тест завершился неудачно: " + result.getInstanceName() +
                        "\nОшибка при выполнении метода: " + result.getMethod().getMethodName());
        log.info("НЕУДАЧА: " + result.getInstanceName().toUpperCase() + result.getMethod().getMethodName());
        log.info("Описание: " + result.getMethod().getDescription());
        log.info("Скриншот страницы сохранен");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Attachment.attachAsText("INFO",
                "Тест пропущен: " + result.getInstanceName() +
                        "\nОшибка при выполнении метода: " + result.getMethod().getMethodName());
        log.info("Ошибка при выполнении метода " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    @Override
    public void onStart(ITestContext iTestContext) {}

    @Override
    public void onFinish(ITestContext iTestContext) {}
}
