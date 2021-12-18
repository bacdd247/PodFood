package common.global;


import org.apache.log4j.Logger;

public class TransactionInfo {
    public TransactionInfo() {
        //Constructor
    }
    public static String USER_ID = "";
    public static String PASSWORD = "";
    private static Logger logger;
    public static final Logger LOGGER = logger == null ? Logger.getLogger(TransactionInfo.class) : logger;


}
