import Logger.LoggerImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by derek_modarski on 4/15/15.
 */
public class CreateEmailEventHandler implements EventHandler<ActionEvent> {

    private final TextField emailTF;
    private final TextField firstNameTF;
    private final TextField lastNameTF;
    private final EmailValidator emailValidator;
    private final Logger.Logger logger;

    public CreateEmailEventHandler(TextField emailTF, TextField firstNameTF, TextField lastNameTF) {
        this.emailTF = emailTF;
        this.firstNameTF = firstNameTF;
        this.lastNameTF = lastNameTF;

        this.emailValidator = new EmailValidator();
        this.emailValidator.setLogger(this.logger = new LoggerImpl());
    }

    @Override
    public void handle(ActionEvent event) {
        String firstName = this.firstNameTF.getText();
        String lastName = this.lastNameTF.getText();
        String email = this.emailTF.getText();

        if (this.emailValidator.isValid(email)) {
            this.logger.log(email, firstName, lastName);
        }

    }
}
