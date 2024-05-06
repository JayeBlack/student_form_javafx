package com.practice2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btnlogin;

    @FXML
    private TextField password;

    @FXML
    private TextField username;
    @FXML
    private Button btnsave;

    @FXML
    private CheckBox checkbox;

    @FXML
    private ComboBox<String> combo = new ComboBox<>();

    @FXML
    private RadioButton female;

    @FXML
    private TextField firstname;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField hall;

    @FXML
    private TextField index;

    @FXML
    private RadioButton male;

    @FXML
    private TextField othername;

    @FXML
    private TextField surname;

    @FXML
    private CheckBox type_checkbox;

    @FXML
    private TextField typename;




    FileChooser file = new FileChooser();


    @FXML
    void onsave(ActionEvent event) throws FileNotFoundException {
        file.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files(*.txt)", "*.txt"));

        File selectedfile =file.showSaveDialog(new Stage());
        String sname = "Surname: "+ surname.getText()+ "\n";
        String fname = "First Name: "+ firstname.getText()+"\n";
        String oname = "Other Name(s): "+ othername.getText()+"\n";
        String i_number = "Index Number: "+ index.getText()+"\n";
        String Gender;
        String c_combo = "Level of Study: "+combo.getSelectionModel().getSelectedItem()+"\n";
        String c_box = "Programming languages studied: "+checkbox.getText()+"\n";
        String for_hall = "Hall of Residence: "+hall.getText()+"\n";

        String for_more_lang = "Other Type Name: "+typename.getText()+"\n";
        if(male.isSelected()){
            Gender = "Gender: Male\n";
        }
        else if(female.isSelected()){
            Gender = "Gender: Female\n";
        }
        else {
            Gender = "Gender: Not specified\n";
        }

        String userdetails = sname + fname + oname+i_number+Gender+ c_combo+c_box+for_more_lang+for_hall;
        PrintWriter output = new PrintWriter(selectedfile);
        output.println(userdetails);
        output.close();
        surname.setText("");
        firstname.setText("");
        othername.setText("");
        index.setText("");
        male.selectedProperty().set(false);
        female.selectedProperty().set(false);
        combo.getSelectionModel().select(0);
        checkbox.selectedProperty().set(false);
        type_checkbox.selectedProperty().set(false);
        hall.setText("");

    }

    @FXML
    void onlogin(ActionEvent event) throws IOException {
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        if (username.getText().equals("admin") && password.getText().equals("1234")) {
            message.setContentText("You have successfully logged in");
            message.setTitle("Message");
            message.show();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("form.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 650);
            Stage stage = new Stage();
            stage.setTitle("Form Registration");
            stage.setResizable(false);
            stage.setScene(scene);
            Stage l_stage = (Stage) btnlogin.getScene().getWindow();
            message.close();
            l_stage.close();
            stage.show();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combo.getItems().addAll("Select Level of Study", "1st Year", "2nd Year", "3rd Year");
        combo.getSelectionModel().select(0);
    }
}
