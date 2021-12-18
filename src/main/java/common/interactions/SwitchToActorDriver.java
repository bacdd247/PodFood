package common.interactions;

import common.platform.AppiumObject;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

@AllArgsConstructor
public class SwitchToActorDriver extends AppiumObject implements Interaction {
    private Actor actorName;

    @Override
    public <T extends Actor> void performAs(T actor)  { getDriver(actorName); }

    public static SwitchToActorDriver call(Actor actorName) {
        return new SwitchToActorDriver(actorName);
    }
}
