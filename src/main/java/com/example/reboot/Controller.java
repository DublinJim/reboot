package com.example.reboot;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       bindBtn.setOnAction(this::bindThis);

        txt1.setFont(Font.font(10));

        btn1.setOnAction(this::makeVolSlider);

        String[] choice = {"Off", "Min", "Max", "Spinal Tap"};
        choiceBox.setValue("Volume");
        choiceBox.getItems().addAll(choice);
        choiceBox.setOnAction(actionEvent -> {
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
        });
    }//init

    private void bindThis(ActionEvent actionEvent) {
//binding rules ..  it must be a Simple node
        SimpleIntegerProperty x = new SimpleIntegerProperty(2);
        SimpleIntegerProperty y = new SimpleIntegerProperty();

        //bind the value of X to Y and add 5 to show the change
        y.bind(x.add(5));

        //output result
        txt1.setText("X = "+x.getValue());
        txt2.setText("y = "+y.getValue());
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
    }
}//end







