import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Testing a Form");

        GridPane gridPane = createGripPane(Pos.CENTER, 10, 10);

        addTitle(gridPane);
        TextField userTextField = addEmailControl(gridPane);
        TextField firstNameTextField = addFirstNameControl(gridPane);
        TextField lastNameTextField = addLastNameControl(gridPane);
        addErrorControl(gridPane);

        Button btn = addCreateButton(gridPane);
        btn.setOnAction(new CreateEmailEventHandler(userTextField, firstNameTextField, lastNameTextField));

        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    GridPane createGripPane(Pos alignment, int hgap, int vgap) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(alignment);
        gridPane.setHgap(hgap);
        gridPane.setVgap(vgap);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        return gridPane;
    }

    private void addTitle(GridPane gridPane) {
        Text sceneTitle = new Text("Create User");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0, 2, 1);
    }

    private TextField addEmailControl(GridPane gridPane) {
        Label userName = new Label("Email:");
        gridPane.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);
        return userTextField;
    }

    private TextField addFirstNameControl(GridPane gridPane) {
        Label firstName = new Label("First Name:");
        gridPane.add(firstName, 0, 2);

        TextField firstNameTextField = new TextField();
        gridPane.add(firstNameTextField, 1, 2);
        return firstNameTextField;
    }

    private TextField addLastNameControl(GridPane gridPane) {
        Label lastName = new Label("Last Name:");
        gridPane.add(lastName, 0, 3);

        TextField lastNameTextField = new TextField();
        gridPane.add(lastNameTextField, 1, 3);
        return lastNameTextField;
    }

    private void addErrorControl(GridPane gridPane) {
        Text error = new Text();
        gridPane.add(error, 1, 6);
    }

    private Button addCreateButton(GridPane gridPane) {
        Button btn = new Button("Create");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        gridPane.add(hbBtn, 1, 4);
        return btn;
    }

}
