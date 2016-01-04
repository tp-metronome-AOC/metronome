package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.controller.IControlleur;

import java.util.Observer;

public interface IView {

    /** method called by the controller, to indicate a time is throw by the clock */
    void marquerTemps();

    /** method called by the controller, to indicate a measure is throw by the engine */
    void marquerMesure();


    /** Return the position value of the molette */
    double getPositionMolette();

    /** Set the position at the middle of the molette */
    void setPositionMoletteToMiddle();

    /** set the bpm value */
    void setValueBpm(Integer value);

    /** set the signature on the view */
    void setValueSignature(Integer bpMesure);

    boolean getStateButtonStart();

    boolean getStateButtonStop();

    boolean getStateButtonIncrease();

    boolean getStateButtonDecrease();
}
