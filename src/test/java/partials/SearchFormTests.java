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
public class SearchFormTests {
    WebDriver webDriver;
    WebDriverWait wait;
    WebApplication app;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 30);
        js = (JavascriptExecutor) webDriver;
        webDriver.get("http://it-ebooks.info/");

        app = new WebApplication(webDriver);
    }

//    @After
    public void cleanUp(){
        if (webDriver!=null){
            webDriver.quit();
        }
    }

    // Search block on radio buttons
    @Test
    public void testSearchBookToTitle_Author_ISBN(){
        String query = "Automation";
        String type = "author";
        app.searchBlock().enterSearchQuery(query);
        app.searchBlock().searchTypeRadio(type).click();
        app.searchBlock().searchButton().click();
        app.waitPages().waitForSearchResultPageITeBooks();

        assertTrue(webDriver.getCurrentUrl().contains("http://it-ebooks.info/search/?q=" + query + "&type=" + type));
        assertTrue(webDriver.findElement(By.className("top")).findElements(By.tagName("tr")).size() == 10);
    }

    @Test
    public void testSearchBookToGoogle() throws InterruptedException {
        String query = "php";
        app.searchBlock().enterSearchQuery(query);
        app.searchBlock().searchTypeRadio("google").click();
        app.searchBlock().searchButton().click();
        app.waitPages().waitForSearchResultPageGoogle();

        assertTrue(webDriver.getCurrentUrl().contains("https://cse.google.com/cse?cx=013493258683483688568:xhfa6ctm1ki&q="
                + query + "#gsc.tab=0&gsc.q=" + query + "&gsc.page=1"));

        Thread.sleep(1000);
        String title = "Programming PHP, 3rd Edition";
        WebElement searchBook = app.searchResultInGoogle().OpenBook(title);
        searchBook.click();
        if (title.contains("eBooks")){
            app.waitPages().waitForSearchResultPageGoogleIneBooks();
            assertTrue(webDriver.findElement(By.className("top")).findElements(By.tagName("tr")).size() == 11);
        }else {
            app.waitPages().waitForSearchResultPageGoogleIneBooksTitle();
            assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().contains(title));
        }
    }

    @Test
    public void testSearchBookToIsbndirectory() throws InterruptedException {
        String query = "java";
        app.searchBlock().enterSearchQuery(query);
        app.searchBlock().searchTypeRadio("isbndirectory").click();
        Thread.sleep(1000);
        app.searchBlock().searchButton().click();
        app.windowHandle().SwitchToWindows();
        app.waitPages().waitForSearchResultPageISBN_Directory();

        assertTrue(webDriver.getCurrentUrl().contains("http://isbn.directory/search/" + query));
    }

    @Test
    public void testOpenBookToIsbndirectory() throws InterruptedException {
        String query = "java";
        app.searchBlock().enterSearchQuery(query);
        app.searchBlock().searchTypeRadio("isbndirectory").click();
        Thread.sleep(1000);
        app.searchBlock().searchButton().click();
        app.windowHandle().SwitchToWindows();
        app.waitPages().waitForSearchResultPageISBN_Directory();

        String titleBook = "Java 8 in Action";
        WebElement foundBook = app.searchResultInISBN_directory().openBook(titleBook);
        foundBook.click();
        app.waitPages().waitForPageBuyInISBN_Directory();
        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().contains(titleBook));
    }

    // Open book with search page
    @Test
    public void testOpenBookWithImg(){
        // Radio button: Title, Author, ISBN
        String query_search_page = "Pro PHP Application Performance";
        String query = "php";
        String type = "title";
        app.searchBlock().enterSearchQuery(query);
        app.searchBlock().searchTypeRadio(type).click();
        app.searchBlock().searchButton().click();
        app.waitPages().waitForSearchResultPageITeBooks();
        app.searchResultsPage().openBookClickImg(query_search_page);
        app.waitPages().waitForBookResultPage();

        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals(query_search_page));

        app.bookPage().buyBook(query_search_page);
        app.windowHandle().SwitchToWindows();
        app.waitPages().waitForPageWhereBuy();

        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals(query_search_page));
    }

    @Test
    public void testOpenBookWithTitle(){
        // Radio button: Title, Author, ISBN
        String query_search_page = "Pro PHP Application Performance";
        String query = "php";
        String type = "isbn";
        app.searchBlock().enterSearchQuery(query);
        app.searchBlock().searchTypeRadio(type).click();
        app.searchBlock().searchButton().click();
        app.waitPages().waitForSearchResultPageITeBooks();
        app.searchResultsPage().openBookClickTitle(query_search_page);
        app.waitPages().waitForBookResultPage();

        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals(query_search_page));

        app.bookPage().buyBook(query_search_page);
        app.windowHandle().SwitchToWindows();
        app.waitPages().waitForPageWhereBuy();

        assertTrue(webDriver.findElement(By.cssSelector("h1[itemprop='name']")).getText().equals(query_search_page));
    }
}
