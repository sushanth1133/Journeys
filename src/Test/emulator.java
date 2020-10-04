package Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.Dimension;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class emulator {

	AndroidDriver<AndroidElement> driver;

	@Test(priority = 1)
	public void openAppTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sentiance.journeys");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.sentiance.journeys.MainActivity");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@Test(priority = 2)
	public void registrationPageTest() throws MalformedURLException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@index='0']").click();
		TouchAction touch = new TouchAction(driver);
		Thread.sleep(2000);
		swipemethod();
		Thread.sleep(2000);
		swipemethod();
		driver.findElement(By.xpath("//android.widget.TextView[@text='CONTINUE']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='first name']")).sendKeys("Sushanth");
		driver.findElement(By.xpath("//android.widget.EditText[@text='last name']")).sendKeys("Bichkunda");
		driver.findElement(By.xpath("//android.widget.EditText[@text='company']")).sendKeys("NCPL Inc");
		driver.findElement(By.xpath("//android.widget.EditText[@text='select your region...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='North, Central and South America']"))
				.click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='work email address']"))
				.sendKeys("bichkunda@sushanth.ca");
		driver.findElement(By.xpath("//android.widget.EditText[@text='password']")).sendKeys("Helloworld1!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@index='0']")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void alreadyHaveAnAccountPageTest() throws MalformedURLException, InterruptedException {

		driver.findElement(By.xpath("//android.widget.TextView[@text='Already have an account?']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("bichkunda@sushanth.ca");
		driver.findElement(By.xpath("//android.widget.EditText[@text='••••••••••••']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='••••••••••••']")).sendKeys("Helloworld1!");
		driver.findElement(By.xpath("//android.view.View[@index='0']")).click();
		driver.findElement(By.xpath("//android.view.View[@index='0']")).click();
		driver.findElementByXPath("//android.view.ViewGroup[@index='2']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='PROVIDE PERMISSONS']").click();
		driver.findElementByXPath("//android.widget.Button[@text='Allow all the time']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='NEXT']").click();

	}

	@Test(priority = 4)
	public void profileTest() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Stats']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Locations']")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void timelineTest() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='parking, parking']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void parkingLocations() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Feedback']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Home']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='SUBMIT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Map']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void settingsTest() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@index='4']")).click();
		Thread.sleep(3000);
	}

	public void swipemethod() {
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms
		int edgeBorder = 10;
		PointOption pointOptionStart, pointOptionEnd;
		Dimension dims = driver.manage().window().getSize();
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
		switch (3) {
		case 1: // center of footer
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case 2: // center of header
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case 3: // center of left side
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
			break;
		case 4: // center of right side
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: " + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(driver).press(pointOptionStart)
					// a bit more reliable when we add small wait
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}

	}

}
