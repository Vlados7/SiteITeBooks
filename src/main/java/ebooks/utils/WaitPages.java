package ebooks.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vlados on 20.11.2016.
 */
public class WaitPages {
    WebDriver webDriver;
    WebDriverWait wait;

    public WaitPages (WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void waitForBookResultPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4")));
    }

    public void waitForSearchResultPageITeBooks(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }

    public void waitForSearchResultPageGoogle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[id='cse-logo']")));
    }

    public void waitForSearchResultPageGoogleIneBooksTitle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1[itemprop='name']")));
    }

    public void waitForSearchResultPageGoogleIneBooks(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1"))).getText().contains("eBooks");
    }

    public void waitForSearchResultPageISBN_Directory(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='main']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main")));
    }
    //
    public void waitForPageBuyInISBN_Directory(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[itemprop='image']")));
    }

    public void waitForPageWhereBuy(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='result_div']")));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main")));
    }

    public void waitBlockFooterForPageInfo(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }

    public void waitBlockFooterForPageAPI(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("ol")));
    }

    public void waitBlockFooterForPageSearch(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("f12")));
    }




}
