import Logger.LoggerImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    private EmailValidator emailValidator;

    @Before
    public void setUp() throws Exception {
        this.emailValidator = new EmailValidator();
        this.emailValidator.setLogger(new LoggerImpl());
    }

    @Test
    public void ItValidatesAStandardEmail() {
        assertTrue(this.emailValidator.isValid("VALID@EMAIL.COM"));
    }

    @Test
    public void ItValidatesALowerCaseEmail() {
        assertTrue(this.emailValidator.isValid("valid@email.com"));
    }

    @Test public void ItValidatesMuseum() {
        assertTrue(this.emailValidator.isValid("valid@email.museum"));
    }

    @Test
    public void ItDoesntValidateInvalidEmails() {
        String[] badEmails = {
                "please @gmail.com",
                "invalid@invalid",
                "invalid@invalid.thisisnotavaliddomain",
                ";;;",
                "noatsign",
                "no.com"
        };

        for(String badEmail : badEmails) {
            assertFalse(this.emailValidator.isValid(badEmail));
        }
    }

    @Test
    public void ItDoesntValidateEmailsInTheBlacklist() {
        this.emailValidator.setBlacklist(new String[] {"PLEASE@GMAIL.COM"});
        assertFalse(this.emailValidator.isValid("please@gmail.com"));
    }
}
