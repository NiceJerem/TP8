import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        String idDivMenu = "nav-link-shopall";
        WebElement divMenu = driver.findElement(By.id(idDivMenu));
        Actions actions = new Actions(driver);
        actions.moveToElement(divMenu);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        actions.build().perform();
        WebElement span = driver.findElement(By.cssSelector("span[data-nav-panelkey=\"VideogamesConsolesPanel\"]"));
        wait.until( ExpectedConditions.visibilityOf(span));
        actions.moveToElement(span);
        actions.build().perform();
        WebElement link = driver.findElement( By.xpath("//span[text()=\"Nintendo Switch\"]"));
        link.click();
    }


}
