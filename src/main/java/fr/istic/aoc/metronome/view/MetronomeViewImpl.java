package fr.istic.aoc.metronome.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    public Circle led_led1;

    @FXML
    public Button bt_start;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        led_led1.setFill(Color.GREEN);
    }
}
