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
}
