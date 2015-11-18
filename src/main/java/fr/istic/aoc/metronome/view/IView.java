package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.controller.IControlleur;

import java.util.Observer;

public interface IView {

    /** method called by the controller, to indicate a time is throw by the clock */
    void marquerTemps();

    /** method called by the controller, to indicate a measure is throw by the engine */
    void marquerMesure();

    /** add an observer to the view */
    void addObserver(Observer o);

    /** set the controller at the view */
    void setControlleur(IControlleur controlleur);

    /** Return the position value of the molette */
    double getPositionMolette();

    /** Set the position at the middle of the molette */
    void setPositionMoletteToMiddle();

    /** set the bpm value */
    void setValueBpm(Integer value);
}
