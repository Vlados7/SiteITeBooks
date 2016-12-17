package partials;

import ebooks.WebApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * Created by Vlados on 17.12.2016.
 */
public class MainPageSiteTests {
    WebDriver webDriver;
    WebDriverWait wait;
    WebApplication app;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 30);
        js = (JavascriptExecutor) webDriver;
        webDriver.get("http://it-ebooks.info/");

        app = new WebApplication(webDriver);
    }

    @After
    public void cleanUp(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }

    // Check on the entrance to the book description
    @Test
    public void testTopDownloadBooksBlockOpenWithImage(){
        WebElement topdownload = app.mainPage().topDownloadeBooksImage("Head First jQuery");
        topdownload.click();
        app.waitPages().waitForBookResultPage();
        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals("Head First jQuery"));
    }

    @Test
    public void testTopDownloadBooksBlockOpenWithTitle(){
        WebElement topdownload = app.mainPage().topDownloadeBooksTitle("Head First jQuery");
        topdownload.click();
        app.waitPages().waitForBookResultPage();
        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals("Head First jQuery"));
    }

    @Test
    public void testLastUploadedBooksBlockOpenWithImage(){
        WebElement lastupload = app.mainPage().lastUploadedBooksImage("Nginx");
        lastupload.click();
        app.waitPages().waitForBookResultPage();
        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals("Nginx"));
    }

    @Test
    public void testLastUploadedBooksBlockOpenWithTitle(){
        WebElement lastupload = app.mainPage().lastUploadedBooksTitle("Nginx");
        lastupload.click();
        app.waitPages().waitForBookResultPage();
        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals("Nginx"));
    }

    //Footer
    @Test
    public void testFooterITEBooksInfoBlock(){
        app.footer().clickLink("IT-eBooks.Info");
        app.waitPages().waitBlockFooterForPageInfo();
        assertTrue(webDriver.getCurrentUrl().contains("http://it-ebooks.info/"));
    }

    @Test
    public void testFooterITEBooksApiBlock(){
        app.footer().clickLink("IT-eBooks API");
        app.windowHandle().SwitchToWindows();
        app.waitPages().waitBlockFooterForPageAPI();
        assertTrue(webDriver.getCurrentUrl().contains("http://it-ebooks-api.info/"));
    }

    @Test
    public void testFooterITEBooksSearchBlock(){
        app.footer().clickLink("IT-eBooks Search");
        app.windowHandle().SwitchToWindows();
        app.waitPages().waitBlockFooterForPageSearch();
        assertTrue(webDriver.getCurrentUrl().contains("http://it-ebooks-search.info/"));
    }

}
