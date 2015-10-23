package fr.istic.aoc.metronome.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * Created by leiko on 23/10/15.
 */
public class MetronomeViewImpl implements Initializable{

    /*
    Controls
    */
    @FXML
    public Slider sdr_tempoSelector;

    @FXML
    public Label lbl_bpm;

    @FXML
    public Circle led_led1;

    @FXML
    public Circle led_led2;

    @FXML
    public Button bt_start;

    @FXML
    public Button bt_stop;

    @FXML
    public Button bt_increase;

    @FXML
    public Button bt_decrease;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sdr_tempoSelector.setOnDragDetected((event) -> {
            System.out.println(event.toString());
        });

        sdr_tempoSelector.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                lbl_bpm.textProperty().setValue(
                        String.valueOf((int) sdr_tempoSelector.getValue()));

            }
        });

        led_led1.setFill(Color.GREEN);
    }
}
