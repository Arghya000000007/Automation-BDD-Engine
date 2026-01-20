package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import java.io.File;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import utils.TestContextSetup;
import org.apache.commons.io.FileUtils;

public class Hooks {
    TestContextSetup testContextSetup;

    // 🔥 Inject the existing TestContextSetup created by PicoContainer
    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Before
    public void setup() {
        // Do NOT create new TestContextSetup()
        System.out.println("Hooks Before: Browser already initialized");
    }

    @After
    public void tearDown() throws InterruptedException {
        testContextSetup.testBase.tearDownDriver();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) {
        WebDriver driver = testContextSetup.driver;
        if (scenario.isFailed()) {
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Create custom screenshot name with scenario name + timestamp
                String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_")
                        + "_" + testContextSetup.genericUtils.timestamp() + ".png";

                // Also attach to the report
                byte[] screenshot = FileUtils.readFileToByteArray(srcFile);
                scenario.attach(screenshot, "image/png", screenshotName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
