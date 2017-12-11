package wsAITest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;
import java.util.*;
import java.util.NoSuchElementException;

public class wsAITest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		// use firefox browser for this test
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\wangx\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.ca/";
	}

	@Test
	public void testAItestFinal() throws Exception {
		// open google web home page
		driver.get("https://www.google.ca/");
		// wait until the page elements are all loaded
		Thread.sleep(5000);
		// find webelement Sign in button and click
		driver.findElement(By.xpath(".//*[@id='gb_70']")).click();
		Thread.sleep(5000);
		// find webelement google account input,clear default value if it exists
		// and send value
		driver.findElement(By.xpath(".//*[@id='identifierId']")).clear();
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("wysdomTesting@gmail.com");
		// find webelement Next button and click
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(5000);
		// find webelement password input, clear default value if it exists and
		// send value
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("AiTesting88");
		Thread.sleep(5000);
		// find webelement Next button and click to enter a page with a “Gmail”
		// link
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content")).click();
		Thread.sleep(5000);
		// find webelement Gmail link and click to enter mailbox interface
		driver.findElement(By.linkText("Gmail")).click();
		Thread.sleep(10000);
		// find the mail with subject of “Forgot your Password?” and click
		List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span"));

		for (WebElement emailsub : email) {
			if (emailsub.getText().equals("Forgot your Password?") == true) {
				emailsub.click();
				break;
			}
		}

		Thread.sleep(10000);
		// find the link in the mail content and click to open an new window
		driver.findElement(By.linkText("https://wysdom.ai/")).click();
		Thread.sleep(10000);
		// switch to the window of wysdom.ai page and get the title of the page
		// and make a checkpoint
		Set<String> windowhandles = driver.getWindowHandles();
		for (String handle : windowhandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Wysdom – AI-based Digital Care");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
