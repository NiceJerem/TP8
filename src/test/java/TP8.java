import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TP8 {

    WebDriver driver;
    @Before
    public void beforeTest()
    {
        driver = new ChromeDriver();
        driver.get("http://toolsqa.com");
    }

    @Test
    public void t1() {

        WebElement divMenu = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[8]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(divMenu);
        actions.build().perform();
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement iframeMenu = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[8]/ul/li[7]/a/span[1]/span/span"));
        wait.until(ExpectedConditions.visibilityOf(iframeMenu));
        actions.moveToElement(iframeMenu);
        actions.click();
        actions.build().perform();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IF1"));
        String H1_iframe1= driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/h1")).getText();
        Assert.assertThat(H1_iframe1, Is.is("Practice Automation Form"));

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IF2"));
        String H1_iframe2= driver.findElement(By.xpath("//*[@id=\"post-9\"]/header/h1")).getText();
        Assert.assertThat(H1_iframe2, Is.is("Home"));

        driver.switchTo().defaultContent();
        WebElement H1 =driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        //wait.until(ExpectedConditions.visibilityOf(H1));
        String h1Text = H1.getText();
        Assert.assertThat(h1Text, Is.is("Sample Iframe page"));
        System.out.println(" Le text du H1 :"+h1Text);
    }


}
