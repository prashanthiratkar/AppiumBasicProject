package rahulshetty;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MisceallanousAppiumAction extends BaseTest{
    @Test
    public void Misceallanous() throws InterruptedException {
        //adb shell dumpsys window | find "mCurrentFocus"  -window
        //adb shell dumpsys window | grep -E 'mCurrentFocus|mFocusedApp'  -mac
        //Activity activity= new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        //Activity activity= new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        //driver. startActivity(activity);
        driver.findElement(new AppiumBy.ByAccessibilityId("Preference")).click();
        //set wifi Name Preference
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landScape= new DeviceRotation(0,0,90);
        driver.rotate(landScape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String ActualText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(ActualText,"WiFi settings");
        driver.setClipboardText("Prashant wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));


    }

}
