package rahulshetty;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class appiumBasics extends BaseTest{
    @Test
    public void WifiSettingName() throws InterruptedException {

        //actual automation
        //xpath, id, accessibilityId, classname, androidUIAutomator.
        //Thread.sleep(30000);
        driver.findElement(new AppiumBy.ByAccessibilityId("Preference")).click();
        //set wifi Name Preference
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String ActualText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(ActualText,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Prashant wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }

}
