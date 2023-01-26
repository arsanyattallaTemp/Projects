import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Testing1 {

    AndroidDriver driver;
    String baseUrl;

    //AndroidDriver wait = new AndroidDriver(driver, Duration.ofSeconds(20));
    public void waitForElementToDisplay(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    @Test
    public void setUp() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:appPackage", "org.chromium.webview_shell");
        desiredCapabilities.setCapability("appium:appActivity", "org.chromium.webview_shell.WebViewBrowserActivity");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:platformName", MobilePlatform.ANDROID);
        desiredCapabilities.setCapability("appium:deviceName", "Nexus6");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        baseUrl = "https://develop.zomepower.com";
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
        System.out.println("Navigated to website");
        
        uName.sendKeys("testbeddev3");
        passWd.sendKeys("Testbeddev3!");
        loginBtn.click();
        
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement addTemp = driver.findElement(By.xpath("//android.widget.Button[@text='+']"));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        addTemp.click();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        try {
            WebElement setTemp = driver.findElement(By.xpath("//android.widget.Button[@text='Set temperature']"));
            setTemp.click();
            System.out.println("Set Temp button found");


        } catch (Exception e) {
            System.out.println("Device is off");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


}
