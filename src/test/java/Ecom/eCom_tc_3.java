package Ecom;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshetty.BaseTest;

import java.time.Duration;

public class eCom_tc_3 extends BaseTest {

    @Test
    public void AddItem() throws InterruptedException {
        String str="Argentina";
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        String xpathExpression = String.format("//android.widget.TextView[@text='%s']", str);
        driver.findElement(By.xpath(xpathExpression)).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Prashant");
        driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        int product_size= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0; i<product_size;i++)
        {
            String ProductName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(ProductName.equalsIgnoreCase("Jordan 6 Rings"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        String Prod_name=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(Prod_name,"Jordan 6 Rings");
        Thread.sleep(5000);
    }
}
