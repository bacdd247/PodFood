package common.platform;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import net.serenitybdd.screenplay.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;


public abstract class AppiumObject extends ProviderDriver<AppiumDriver<MobileElement>>{

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AppiumObject.class);

    public void switchToWebView(Actor actor, String webView)    {
        Set<String> contextNames = getDriver(actor).getContextHandles();

        for (String contextName : contextNames) {
            LOGGER.info("The list of Webview: " + contextName);
            if (contextName.equals(webView))    {
                getDriver(actor).context(webView);
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public TouchAction withAction(Actor actor)  {
        return new TouchAction(getDriver(actor));
    }
}
