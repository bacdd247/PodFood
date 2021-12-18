package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks extends BaseStep{
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void clean_the_stage(){
        Serenity.clearCurrentSession();
    }

    @After("@FixSaving")
    public void clean_the_stage_ff(){
        Serenity.clearCurrentSession();
    }
}
