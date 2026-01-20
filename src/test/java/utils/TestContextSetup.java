package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String LandingPageProductName;
	public WebDriverWait wait;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public ConfigFileReader configFileReader;
	
    public TestContextSetup() {
        testBase = new TestBase();
        configFileReader = new ConfigFileReader();
        driver = testBase.webDrivermanager(configFileReader.getBrowser());

        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        pageObjectManager = new PageObjectManager(driver, wait);
        genericUtils = new GenericUtils(driver);

        System.out.println("Driver + Page Objects initialized");
    }

   
	
//	public void initPageObjects() {
//        // Initialize after driver + wait are created
//		testBase = new TestBase();
//		driver = testBase.webDrivermanager();
//		wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
//        pageObjectManager = new PageObjectManager(driver, wait);
//        genericUtils = new GenericUtils(driver);
//        
//    }
	
}
