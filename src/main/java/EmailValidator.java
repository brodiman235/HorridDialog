import Logger.*;
import java.util.HashMap;

public class EmailValidator {
    public static final String ValidEmailRegularExpression = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.([A-Z]{2,4}|MUSEUM)$";
    private HashMap<String, String> blacklist;
    private Logger logger;

    public EmailValidator() {
        this.blacklist = new HashMap<String, String>();
        this.logger = new NullLogger();
    }

    public void setBlacklist(String[] blacklist) {
        this.blacklist = new HashMap<String, String>();
        for (String invalidEmail : blacklist) {
            this.blacklist.put(invalidEmail.toUpperCase(), invalidEmail);
        }
    }

    public boolean isValid(String email) {
        if (emailIsInBlacklist(email)) {
            logger.log(email, "*", "*");
            return false;
        }

        return emailFormatIsValid(email);
    }

    private boolean emailFormatIsValid(String email) {
        return email.toUpperCase().matches(ValidEmailRegularExpression);
    }

    private boolean emailIsInBlacklist(String email) {
        return blacklist.containsKey(email.toUpperCase());
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
