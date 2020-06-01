package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class LocatorMethods {
    public static AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;

    private static final Properties locatorId = new Properties();
    private static final Properties locatorType = new Properties();
    private static final Properties apps=new Properties();

    @Before
    public static void setUp(){
        try {
            initProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel API 28");
        caps.setCapability("appPackage","com.google.android.dialer");
        caps.setCapability("appActivity","com.android.dialer.main.impl.MainActivity");

        try {
            URL url = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(url,caps);
            wait = new WebDriverWait(driver, 10);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
    public static void initProperties() throws IOException {
//        InputStream inputStream=getClass().getClassLoader().getResourceAsStream("locatorId.properties");
//        locatorId.load(inputStream);
        InputStream inputStream= LocatorMethods.class.getClassLoader().getResourceAsStream("locatorId.properties");
        locatorId.load(inputStream);

//        InputStream inputStream2=getClass().getClassLoader().getResourceAsStream("locatorType.properties");
//        locatorType.load(inputStream2);
        InputStream inputStream2= LocatorMethods.class.getClassLoader().getResourceAsStream("locatorType.properties");
        locatorType.load(inputStream2);

        InputStream inputStream3=LocatorMethods.class.getClassLoader().getResourceAsStream("apps.properties");
        apps.load(inputStream3);


    }

    @After
    public void end(){
        driver.quit();
    }

    public static MobileElement waitForPresence(By path){
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(path));
    }

    public static MobileElement locateElement(String typeOrId){
        String id = locatorId.getProperty(typeOrId);
        String type = locatorType.getProperty(typeOrId);

        MobileElement element;

        switch (type){
            case "xpath":
                element = waitForPresence(By.xpath(id));
                break;
            case "id":
                element = waitForPresence(By.id(id));
                break;
            case "desc":
                element = waitForPresence(new MobileBy.ByAccessibilityId(id));
                break;
            case "name":
                element = waitForPresence(By.name(id));
                break;
            case "linktext":
                element = waitForPresence(By.linkText(id));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return element;
    }
}
