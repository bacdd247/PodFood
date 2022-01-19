package screenplay;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeScreen {
    private HomeScreen() {
        throw new IllegalStateException("Utility class");
    }

    public static final Target HOME_MENU = Target.the("home menu")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Home')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACCOUNT_MENU = Target.the("account menu")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Account')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ALL_CATE = Target.the("all category")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'All')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target SEARCH_BOX = Target.the("search box")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Search')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target SEARCH_FIELD = Target.the("search field")
            .locatedForAndroid(By.xpath("//android.widget.EditText"))
            .locatedForIOS(By.xpath(""));

    public static final Target PRODUCT_IN4 = Target.the("product information")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'" + "" +"')]"))
            .locatedForIOS(By.xpath(""));
}
