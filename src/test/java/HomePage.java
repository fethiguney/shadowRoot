import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class HomePage {


    @Test
    public void shadowRootTest() {

        Driver.getDriver().get("https://itytest.ccngroup.com.tr/Era/");

        WebElement shadowHost = Driver.getDriver().findElement (By.xpath ("(//dxbl-form-layout-item[@class='dxbl-col-md-12 dxbl-col dxbl-fl-item'])[2]"));
        SearchContext shadowRootOne = expandRootElement (shadowHost);

        WebElement nestedShadowHost = shadowRootOne.findElement (By.xpath ("(//dxbl-input-editor[@class='dxbl-text-edit'])[1]"));
        SearchContext shadowRootTwo = expandRootElement (nestedShadowHost);

        shadowRootTwo.findElement(By.xpath("(//input[@class='dxbl-text-edit-input'])[1]")).
                sendKeys("admin");

    }

    public SearchContext expandRootElement (WebElement element) {
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) Driver.getDriver()).executeScript (
                "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }







}
