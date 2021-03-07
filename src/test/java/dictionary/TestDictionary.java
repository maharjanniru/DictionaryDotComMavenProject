package dictionary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DictionaryPageObject;

public class TestDictionary {
    String driverPath = "Drivers/chromedriver88.exe";
    WebDriver driver;
    DictionaryPageObject dictionaryObj;


    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions().setHeadless(false); // setHeadless(true) allows to run automation without displaying UI
//        options.addArguments("start-maximized");
//        options.addArguments("disable-infobars");
      driver = new ChromeDriver(options);
        driver.get("https://www.dictionary.com/");

    }

    @Test(priority=0)
    public void test(){
        //create DictionaryPageObject object
        dictionaryObj = new DictionaryPageObject(driver);

    }

}
