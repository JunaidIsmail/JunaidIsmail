import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlerts {

    @Test
    public void AcceptAlert() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//li[1]/button")).click();
        driver.switchTo().alert().accept();

        String resultText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals("You successfully clicked an alert", resultText);
        driver.close();
    }

    @Test
    public void DismissAlert() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//li[2]/button")).click();
        driver.switchTo().alert().dismiss();

        String resultText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals("You clicked: Cancel", resultText);
        driver.close();
    }

    @Test
    public void EnterTextInPrompt() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//li[3]/button")).click();
        driver.switchTo().alert().sendKeys("Entering Text in Prompt");
        driver.switchTo().alert().accept();

        String resultText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals("You entered: Entering Text in Prompt", resultText);
        driver.close();
    }
}
