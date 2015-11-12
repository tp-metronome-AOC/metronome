package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.controller.IControlleur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by leiko on 23/10/15.
 */
public class MetronomeViewImpl extends Observable implements Initializable, IView {

    private final int BPM_SELECTOR_MIN = 60;
    private final int BPM_SELECTOR_MAX = 180;

    private final String AUDIO_TEMPS    = "resources/snare.wav";
    private final String AUDIO_MESURE   = "resources/kick.wav";

    IControlleur controlleur;

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
        sdr_tempoSelector.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                setChanged();
                notifyObservers((Command) () -> controlleur.updateMolette());
            }
        });

        led_led1.setFill(Color.GREEN);

        sdr_tempoSelector.setMin(BPM_SELECTOR_MIN);
        sdr_tempoSelector.setMax(BPM_SELECTOR_MAX);
    }

    @Override
    public void marquerTemps() {
    }

    @Override
    public void marquerMesure() {

    }

    public void setControlleur(IControlleur controlleur) {
        this.controlleur = controlleur;
    }

    @Override
    public double getPositionMolette() {
        return sdr_tempoSelector.getValue();
    }

    @Override
    public void setValueBpm(Integer value) {
        lbl_bpm.setText(value.toString());
    }

    private  void playSound(String fileName) throws Exception
    {
        // open the sound file as a Java input stream
        InputStream in = new FileInputStream(fileName);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}
