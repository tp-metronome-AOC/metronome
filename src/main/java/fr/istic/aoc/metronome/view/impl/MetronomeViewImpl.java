package fr.istic.aoc.metronome.view.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.controller.IControlleur;
import fr.istic.aoc.metronome.view.IView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by leiko on 23/10/15.
 */
public class MetronomeViewImpl extends Observable implements Initializable, IView {

    private final int BPM_SELECTOR_MIN = 60;
    private final int BPM_SELECTOR_MAX = 180;

    private final static String AUDIOFILE_TEMPS    = "file:./src/main/resources/kick.wav";
    private final static String AUDIOFILE_MESURE   = "file:./src/main/resources/snare.wav";

    private static AudioClip AUDIO_CLIP_TEMPS;
    private static AudioClip AUDIO_CLIP_MESURE;

    IControlleur controlleur;

    /*
    Controls
    */
    @FXML
    public Slider sdr_tempoSelector;

    @FXML
    public Label lbl_bpm;

    @FXML
    public Label lbl_signature;

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

        try {
            AUDIO_CLIP_TEMPS = new AudioClip(new URL(AUDIOFILE_TEMPS).toString());
            AUDIO_CLIP_MESURE = new AudioClip(new URL(AUDIOFILE_MESURE).toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        sdr_tempoSelector.valueProperty().addListener((arg0, arg1, arg2) -> {
            setChanged();
            notifyObservers((Command) () -> controlleur.updateMolette());
        });

        sdr_tempoSelector.setOnMouseReleased(event -> {
            setChanged();
            notifyObservers((Command) () -> controlleur.applyMolette());
        });

        bt_start.setOnAction(event -> {setChanged();
           notifyObservers((Command) () -> controlleur.startMetronome());
        });

        bt_stop.setOnAction(event -> {
            setChanged();
            notifyObservers((Command) () -> controlleur.stopMetronome());
        });

        bt_increase.setOnAction(event -> {
            setChanged();
            notifyObservers((Command) () -> controlleur.increaseMetronome());
        });

        bt_decrease.setOnAction(event -> {
            setChanged();
            notifyObservers((Command) () -> controlleur.decreaseMetronome());
        });


        led_led1.setFill(Color.GREEN);

        sdr_tempoSelector.setMin(BPM_SELECTOR_MIN);
        sdr_tempoSelector.setMax(BPM_SELECTOR_MAX);
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void marquerTemps() {
        led_led2.setFill(Paint.valueOf("tomato"));
        playSound(AUDIO_CLIP_TEMPS);
        pause();
        led_led2.setFill(Paint.valueOf("DARKRED"));
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void marquerMesure() {
        led_led1.setFill(Paint.valueOf("limegreen"));
        playSound(AUDIO_CLIP_MESURE);
        pause();
        led_led1.setFill(Paint.valueOf("DARKGREEN"));
    }

    /**
     *  {@inheritDoc}
     */
    public void setControlleur(IControlleur controlleur) {
        this.controlleur = controlleur;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public double getPositionMolette() {
        return sdr_tempoSelector.getValue();
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void setPositionMoletteToMiddle() {
        sdr_tempoSelector.setValue( (sdr_tempoSelector.getMax() + sdr_tempoSelector.getMin()) / 2 );
    }



    /**
     *  {@inheritDoc}
     */
    @Override
    public void setValueBpm(Integer value) {
        lbl_bpm.setText(value.toString());
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void setValueSignature(Integer bpMesure) {
        lbl_signature.setText(String.valueOf(bpMesure)+"/4" + "    ");
    }

    private void playSound(AudioClip clip)
    {
        clip.play();
    }

    private void pause(){
        try {
            Thread.sleep(100);
        }catch(Exception e){

        }
    }
}
