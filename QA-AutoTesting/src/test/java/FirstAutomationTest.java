import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstAutomationTest {
    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "http://www.google.com";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeClass
    public void setupTest (){
        //Create a new ChromeDriver
        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }
    //-----------------------------------Tests-----------------------------------
    @Test(
            priority = 1
    )
    public void GoogleSearchTest() throws InterruptedException {
        Thread.sleep(5000);
        WebElement rejectAllButton = this.driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div"));
        rejectAllButton.click();
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("smite guru site");
        searchTextBox.submit();
        Thread.sleep(15000);
        WebElement testLink =
                driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/div/div/div/div[1]/span")
                );
        Assert.assertEquals(testLink.getText(), "SmiteGuru");
        System.out.print(testLink.getText());
    }

    @Test(
            priority = 2
    )
    public void SiteLoadTest() throws InterruptedException {
        Thread.sleep(2000);
        WebElement siteLink = this.driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/div/div/div/div[2]/cite"));
        Thread.sleep(1000);
        siteLink.click();
        Thread.sleep(3000);
        WebElement mainSiteCookieConsent = this.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/button[1]"));
        mainSiteCookieConsent.click();
        Thread.sleep(3000);

        Assert.assertTrue(this.driver.getTitle().contains("SmiteGuru"), "Wrong page title!");
        System.out.println("smite.guru successfully reached.");

    }

    @Test(
            priority = 3
    )
    public void SearchPlayerAccountTest() throws InterruptedException {
        Thread.sleep(2000);

        WebElement playerNameSearchTextBox = this.driver.findElement(By.xpath("//*[@id=\"cw\"]/div/div[1]/div/div/div/form/div[1]/input"));
        playerNameSearchTextBox.sendKeys(new CharSequence[]{"CoolKidLPF"});
        playerNameSearchTextBox.submit();
        Thread.sleep(9000);
        WebElement playerNamesFoundTextBox = this.driver.findElement(By.xpath("//*[@id=\"cw\"]/section/div[2]/div/p"));
        String searchResultText = playerNamesFoundTextBox.getText();

        Assert.assertEquals(searchResultText, "1 matches found.");
        System.out.print(searchResultText);

    }

    @Test(
            priority = 4
    )
    public void LoadBuildsTabTest() throws InterruptedException {
        WebElement mainSiteCookieConsent = this.driver.findElement(By.xpath("//*[@id=\"w\"]/header/div[4]/div[2]/ul/li[1]"));
        mainSiteCookieConsent.click();
        Thread.sleep(3000);

        WebElement buildsTabTitleTextBox = this.driver.findElement(By.xpath("//*[@id=\"cw\"]/section/div[1]/div/div/h1"));
        Assert.assertEquals(buildsTabTitleTextBox.getText(), "Builds");
        System.out.print("Builds Page Loaded");
    }


    @Test(
            priority = 5
    )
    public void ImageSourceTest() throws InterruptedException {

        Thread.sleep(3000);

        //rest.assured not usable due to site anti bot mechanisms, returns error code 403 forbidden on image source load request

        WebElement imageElement = driver.findElement(By.xpath("//*[@id=\"cw\"]/section/div[2]/div/div[4]/a[1]/img"));
        Assert.assertTrue(imageElement.isDisplayed(), "Image is not visible on page");
        System.out.println("Image is displayed correctly");
    }

    @Test(
            priority = 6
    )
    public void WrongSteamCredentialsLoginTest() throws InterruptedException {
        Thread.sleep(8000);
        WebElement userLoginBtn = driver.findElement(By.xpath("//*[@id=\"login-bar\"]/div/a[1]/span"));
        userLoginBtn.click();
        Thread.sleep(7000);
        WebElement steamLoginBtn = driver.findElement(By.xpath("//*[@id=\"cw\"]/section/div/div/div[2]/div[3]/a/span"));
        steamLoginBtn.click();
        Thread.sleep(7000);

        WebElement usernameInputTextBox = driver.findElement(By.xpath("//*[@id=\"responsive_page_template_content\"]/div[1]/div[1]/div/div/div/div[2]/div/form/div[1]/input"));
        usernameInputTextBox.sendKeys("a");
        WebElement passwordInputTextBox = driver.findElement(By.xpath("//*[@id=\"responsive_page_template_content\"]/div[1]/div[1]/div/div/div/div[2]/div/form/div[2]/input"));
        passwordInputTextBox.sendKeys("a");
        usernameInputTextBox.submit();
        Thread.sleep(7000);

        WebElement loginFailedTextBox = driver.findElement(By.xpath("//*[@id=\"responsive_page_template_content\"]/div[1]/div[1]/div/div/div/div[2]/div/form/div[5]"));
        Assert.assertEquals(loginFailedTextBox.getText(), "Please check your password and account name and try again.");
        System.out.println("Login works correctly");


        // "//*[@id="responsive_page_template_content"]/div[1]/div[1]/div/div/div/div[2]/div/form/div[1]/input"

        // "//*[@id="responsive_page_template_content"]/div[1]/div[1]/div/div/div/div[2]/div/form/div[2]/input"

        // "//*[@id="responsive_page_template_content"]/div[1]/div[1]/div/div/div/div[2]/div/form/div[4]/button"

        // "//*[@id="responsive_page_template_content"]/div[1]/div[1]/div/div/div/div[2]/div/form/div[5]"

        // "Please check your password and account name and try again."



    }


    //-----------------------------------Test TearDown-----------------------------------
    @AfterClass
    public void teardownTest (){
        //Close browser and end the session
        driver.quit();
    }
}
