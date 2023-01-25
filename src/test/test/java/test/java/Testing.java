import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Testing1 {

    AndroidDriver driver;
    String baseUrl;

    @Test
    public void setUp() throws Exception{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:appPackage", "org.chromium.webview_shell");
        desiredCapabilities.setCapability("appium:appActivity", "org.chromium.webview_shell.WebViewBrowserActivity");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:platformName", MobilePlatform.ANDROID);
        desiredCapabilities.setCapability("appium:deviceName", "Nexus6");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        baseUrl = "https://app.zomepower.com";
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        WebElement uName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/" +
                "android.widget.LinearLayout/android.webkit.WebView/" +
                "android.webkit.WebView/android.view.View" +
                "/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[1]"));
        WebElement passWd = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/" +
                "android.widget.LinearLayout/android.webkit.WebView/" +
                "android.webkit.WebView/android.view.View" +
                "/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[2]"));
        WebElement loginBtn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
                ".LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
                "android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/" +
                "android.view.View/android.view.View[3]/android.widget.Button"));
        uName.sendKeys("testbed-prod-5");
        passWd.sendKeys("testbed-prod-5");
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        WebElement addTemp =driver.findElement(By.xpath("//android.widget.Button[@text='+']"));
        WebElement setTemp =driver.findElement(By.xpath("//android.widget.Button[@text='Set temperature']"));
        System.out.println("Navigated to website");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


        //WebElement addTemp = driver.findElement(By.xpath("//android.widget.Button[@text='+']"));
        addTemp.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



        // WebElement setTemp = driver.findElement(By.xpath("//android.widget.Button[@text='Set temperature']"));
        System.out.println("Set Temp button found");
        setTemp.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }



}
