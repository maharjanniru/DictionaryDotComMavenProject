package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DictionaryPageObject {
    WebDriver driver;

    By searchBar = By.xpath("//*[@id=\"searchbar_input\"]");

    By searchIcon = By.id("search-submit");

    public DictionaryPageObject(WebDriver driver){
        this.driver =driver;
    }

    //set word
    public void setSearchWordInSearchBar(String word){
        driver.findElement(searchBar).sendKeys(word);
    }




}
