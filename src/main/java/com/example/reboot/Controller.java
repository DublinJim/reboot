package com.example.reboot;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public AnchorPane rootPane;
    public Button btn1;
    public ChoiceBox<String> choiceBox;
    public Text txt1;
    public Text txt2;
    public CheckBox chk1;
    public Slider sldr1;
    public GridPane b;
    public Button bindBtn;
    public TextArea txtrea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       bindBtn.setOnAction(this::bindThis);
        txt1.setFont(Font.font(10));
        btn1.setOnAction(this::makeVolSlider);
        Tooltip tooltip = new Tooltip("Allow the variable to be set for another node ");
bindBtn.setTooltip(tooltip);
        String[] choice = {"Off", "Min", "Max", "Spinal Tap"};
        choiceBox.setValue("Volume");
        choiceBox.getItems().addAll(choice);

        choiceBox.setOnAction(actionEvent -> getVolValues());


    }//init

    private void getVolValues() {
        String gotChoice = choiceBox.getValue();
        txt1.setText(gotChoice);


        Float volLvl;
        switch (gotChoice) {
            case "Off":
                volLvl = 0.0f;
                break;
            case "Min":
                volLvl = 1.0f;
                break;
            case "Max":
                volLvl = 2.0f;
                break;

            case "Spinal Tap":
                volLvl = 3.0f;
                break;
            default:
                volLvl = 0.4f;
        }

        txt2.setText(String.valueOf(volLvl));
        txtrea.setText("The choice-box has text values which are then used to create double values as seen");
    }

    private void bindThis(ActionEvent actionEvent) {

        SimpleIntegerProperty x = new SimpleIntegerProperty(2);
        SimpleIntegerProperty y = new SimpleIntegerProperty();
        y.bind(x.add(5));

        txt1.setText("X = "+x.getValue());
        txt2.setText("y = "+y.getValue());
        txtrea.setText("Value X is set to 2 and value Y is set to X +5");
    }



    private void makeVolSlider(ActionEvent actionEvent) {
        double val = sldr1.getValue();
        txt1.setText(String.valueOf(val));

    }

    public void setPos() {
        double pos = 232.9;
        if (chk1.isSelected()) {
            txt2.setText("fullscreen");
            pos = 0;
        } else {
            txt2.setText("Fullscreen off");
        }
        txt1.setText(String.valueOf(pos));
        txtrea.setText("Temp values....    A temp variable is set to the original value and on activation of the button it is changes  and then put back as the checkbox in unselected.");
    }
}//end







