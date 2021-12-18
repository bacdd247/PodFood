package screenplay;

public class CannotAuthenticateException extends RuntimeException {
    public CannotAuthenticateException(String actorName)    {
        super("The actor " + " does not have the ability to sign in to application");
    }
}
