package rahulshetty;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        //AndroidDriver , IOSDriver
        //appium code -> Appium server-> mobile
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Neosoft//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("PrashantPhone");
        options.autoGrantPermissions();
        //options.setAutomationName("UIAutomator2");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("ANDROID");
        //options.setDeviceName("CPH2239");
        //options.setApp("src//test//java//Resources//ApiDemos-debug.apk");
        //options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\General-Store.apk");
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void LongPressedEvent(WebElement Element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) Element).getId(), "duration",2000
        ));
    }
    public void ScrollTillEndAction(){
        boolean canScrollMore;
        do {
            canScrollMore= (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }
    public void SwipeEventAction(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }
    public void DragAndDropAction(WebElement element , int X, int Y){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", X,
                "endY", Y
        ));
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
        service.stop();
    }
}
