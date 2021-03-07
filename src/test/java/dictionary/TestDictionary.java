package dictionary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DictionaryPageObject;

import java.io.*;

public class TestDictionary {
    String driverPath = "Drivers/chromedriver88.exe";
    String filePath = "Words/words.txt";
    WebDriver driver;
    DictionaryPageObject dictionaryObj;


    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions().setHeadless(false); // setHeadless(true) allows to run automation without displaying UI
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
      driver = new ChromeDriver(options);
        driver.get("https://www.dictionary.com/");

    }

    @Test(priority=0)
    public void test() throws IOException, InterruptedException {
        //create DictionaryPageObject object
        dictionaryObj = new DictionaryPageObject(driver);
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder allMeanings = new StringBuilder();
        String line ="";
        while((line = br.readLine() )!=null) {
            System.out.println(line);
            dictionaryObj.setSearchWordInSearchBar(line);
            dictionaryObj.clickSearchIcon();

            Thread.sleep(5000);
            allMeanings.append( dictionaryObj.getMeaning());
            allMeanings.append("\n");
            dictionaryObj.clearSearchBar();

        }
        System.out.println(allMeanings);
        FileWriter writer = new FileWriter("D:\\meanings.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write(allMeanings.toString());
    }

}
