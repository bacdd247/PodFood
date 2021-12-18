package screenplay;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountScreen {
    private AccountScreen(){ throw new IllegalStateException("AccountScreen class"); }

    public static final Target LOGIN_MENU = Target.the("login menu")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Login')]"))
            .locatedForIOS(By.xpath(""));
}
