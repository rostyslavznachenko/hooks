import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {
    /**
     * testing pull request builder plugin
     * */
    @Test
    public void testingHooksIntegrationWithJenkins() {
        System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().setSize(new Dimension(1920,1080));
        browser.get("https://www.google.com/");
        WebElement searchInput = new WebDriverWait(browser, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib")));
        String searchValue = "testing hooks";
        String valueToFailTest = "failed";
        searchInput.sendKeys(Keys.chord(searchValue, Keys.ENTER));
        System.out.println(browser.getTitle());
        Assert.assertTrue(browser.getTitle().contains(searchValue));
        browser.quit();
    }
}
