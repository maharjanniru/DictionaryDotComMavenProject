package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DictionaryPageObject {
    WebDriver driver;

//    @FindBy(xpath="//*[@id=\"searchbar_input\"]")
//    WebElement searchBar;
    By searchBar = By.xpath("//*[@id=\"searchbar_input\"]");

    By searchIcon = By.id("search-submit");

    @FindBy(xpath="//*[@id=\"base-pw\"]/main/section/section/div[1]")
    WebElement meaningSection;


    public DictionaryPageObject(WebDriver driver){

        this.driver =driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    //set word
    public void setSearchWordInSearchBar(String word){
        driver.findElement(searchBar).sendKeys(word);
    }

    public void clickSearchIcon(){
        driver.findElement(searchIcon).click();
    }

    public void clearSearchBar(){
       driver.findElement(searchBar).clear();
    }

    public String  getMeaning(){
        return meaningSection.getText();
    }





}
