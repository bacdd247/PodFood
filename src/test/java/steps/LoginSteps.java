package steps;

import common.interactions.SwitchToActorDriver;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.steps.ScenarioSteps;
import screenplay.Authenticate;
import screenplay.Login;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps extends ScenarioSteps {
    @Given("^that (.*) is on the home screen$")
    public void open_app_see_home_screen(String actorName)  {
        OnStage.theActorCalled(actorName).attemptsTo(
                SwitchToActorDriver.call(OnStage.theActorCalled(actorName))
        );

        OnStage.theActorInTheSpotlight().attemptsTo(

        );
    }

    @Given("^(?:he|she|they|we) login with userId: (.*) password: (.*)$")
    public void login_with_user(String userName, String passWord)   {
        theActorInTheSpotlight().whoCan(Authenticate.with(userName, passWord))
                .attemptsTo(Login.withUser());
    }
}
