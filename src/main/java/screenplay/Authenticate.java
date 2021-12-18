package screenplay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

@Getter
@Setter
@AllArgsConstructor
public class Authenticate implements Ability {
    private String userName;
    private String passWord;

    public static Authenticate as(Actor actor)  {
        if (actor.abilityTo(Authenticate.class) == null) {
            throw new CannotAuthenticateException(actor.getName());
        }
        return actor.abilityTo(Authenticate.class);
    }
    public static Authenticate with(String userName, String passWord)   {
        return new Authenticate(userName, passWord);
    }
}
