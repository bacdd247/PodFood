package screenplay;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task, CanBeSilent {
    private Authenticate authenticateted(Actor actor)   { return Authenticate.as(actor); }

    @Override
    public <T extends Actor> void performAs(T actor)    {
        Authenticate authenticate = authenticateted(actor);
        String userName = authenticate.getUserName();
        String passWord = authenticate.getPassWord();
        actor.attemptsTo(
                Click.on(),
                Click.on(),
                Enter.theValue(userName).into(),
                Enter.theValue(passWord).into(),
                Click.on()
        );
    }

    public static Login withUser()  {
        return instrumented(Login.class);
    }

    @Override
    public boolean isSilent()   { return true; }
}
