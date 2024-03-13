package rahulshetty;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest{
    @Test
    public void ScrollDemoTest() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAccessibilityId("Views")).click();
        // where to scroll known prior
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        //where to scroll No prior idea
        ScrollTillEndAction();

    }

}
