import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DenemeTesti {
    final String cihazAdi = "Galaxy A7 (2018)";
    final String platformAdi = "Android";
    final String platformVersion = "10.0";
    final String automation = "UiAutomator2";

  //  AppiumDriver<MobileElement> driver; // hem ios hem de androidlerde driver olarak kullanılabiliyor
   AndroidDriver <AndroidElement> driver ;//driver; sadece android işlemcilerde kullanılabiliyor

    @BeforeTest
    public void deneme1() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformAdi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Zafer\\IdeaProjects\\Appium_T-108\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void carpma ()  {
        driver.findElementByAccessibilityId("8").click();

        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiplizieren").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("ist gleich").click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        System.out.println(result);
       int expectedResult =1600;
       int actualResult = Integer.parseInt(result);
        Assert.assertEquals(actualResult,expectedResult);



    }
}
