package common.platform;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class ProviderDriver<T> {
    @SuppressWarnings("unchecked")
    public T getDriver(Actor actor) {
        return (T)  ((WebDriverFacade) BrowseTheWeb.as(actor).getDriver()).getProxiedDriver();
    }
}
