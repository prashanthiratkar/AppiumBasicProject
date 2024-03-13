package Ecom;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Text;
import rahulshetty.BaseTest;

import java.util.List;

public class eCom_tc_1 extends BaseTest {

    @Test
    public void FillForm() throws InterruptedException {
        String str="Argentina";
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        String xpathExpression = String.format("//android.widget.TextView[@text='%s']", str);
        driver.findElement(By.xpath(xpathExpression)).click();
        /*List <WebElement> options=driver.findElements(By.className("android.widget.TextView"));
        System.out.println("number of option: " +options.size());
        for(WebElement e:options)
        {
            String val=e.getText();

            if(val.equalsIgnoreCase("India"))
            {
                e.click();
                break;
            }
        }*/
        //driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Prashant");
        driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String Toast_message= driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("text");
        Assert.assertEquals(Toast_message, "Please enter your name");
    }
}
