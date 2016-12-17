package ebooks.blocks;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by Vlados on 17.12.2016.
 */
public class SearchResultInISBN_Directory {
    WebDriver webDriver;
    JavascriptExecutor js;

    public SearchResultInISBN_Directory(WebDriver driver){
        webDriver = driver;
        js = (JavascriptExecutor) webDriver;
    }

    public WebElement openBook(String titleBook) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 7) {
                break;
            }
            js.executeScript("window.scrollBy(20,200)", "");
            Thread.sleep(3000);
        }

        List<WebElement> list = webDriver.findElements(By.cssSelector("a[class='a_title']"));

        for (WebElement lists : list) {
            if (lists.getText().contains(titleBook)){
                return lists;
            }
        }

        return null;
    }

}
