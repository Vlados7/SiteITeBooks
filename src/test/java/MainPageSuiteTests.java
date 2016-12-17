
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import partials.MainPageSiteTests;
import partials.SearchFormTests;

/**
 * Created by Vlados on 15.11.2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainPageSiteTests.class,
        SearchFormTests.class
})

public class MainPageSuiteTests {

}
