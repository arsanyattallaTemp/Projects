package test.java;

import io.appium.java_client.AppiumBy;
import org.apache.commons.codec.binary.Base64;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;



public class Testing {

    WebDriver driver;


@Test
    public void test() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:appPackage", "org.chromium.webview_shell");
        desiredCapabilities.setCapability("appium:appActivity", "org.chromium.webview_shell.WebViewBrowserActivity");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:platformName", MobilePlatform.ANDROID)   ;
        desiredCapabilities.setCapability("appium:deviceName", "Nexus6");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        UiAutomator2Options options = new UiAutomator2Options();
        options.setNativeWebScreenshot(true);

        

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);


    driver.get("https://app.zomepower.com");
        System.out.println("success");
        Thread.sleep(10000);
    Thread.sleep(10000);


    //((CanRecordScreen) driver).startRecordingScreen();

    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/" +
                    "android.widget.LinearLayout/android.webkit.WebView/" +
                    "android.webkit.WebView/android.view.View" +
                    "/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[1]"))
            .sendKeys("testbed-prod-3");
    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/" +
                "android.widget.LinearLayout/android.webkit.WebView/" +
                "android.webkit.WebView/android.view.View" +
                "/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[2]"))
                .sendKeys("testbed-prod-3");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
                ".LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
                "android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/" +
                "android.view.View/android.view.View[3]/android.widget.Button")).click();
    Thread.sleep(9000);
    Thread.sleep(9000);

    //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button[2]")).click();
    WebElement set = driver.findElement(By.xpath("//android.widget.Button[@text='Set temperature']"));
   // set.click();

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

        for (int i = 0; i < 2; i++) {
            touchAction.tap(PointOption.point(932, 1440))
                    .perform();
        }
        touchAction.tap(PointOption.point(704, 2486))
                .perform();
       // Thread.sleep(5000);

    //Random rand = new Random();
    //int upperbound = 25;
    //int int_random = rand.nextInt(upperbound);
    //String base64String = ((CanRecordScreen) driver).stopRecordingScreen();
    //byte[] data = Base64.decodeBase64(base64String);
    //String destinationPath = "src\\"+int_random+".mp4";
   //Path path = Paths.get(destinationPath);
    //FileUtils.writeByteArrayToFile(new File(path.toUri()), data);






    }
}
