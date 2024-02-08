package rahulshetty;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends BaseTest{
    @Test
    public void LongPressGestures() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAccessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
        WebElement people =driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        LongPressedEvent(people);
        String pageTitle = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(pageTitle,"Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

    }

}
