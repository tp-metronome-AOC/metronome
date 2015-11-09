package fr.istic.aoc.metronome.view;

import java.util.Observable;
import java.util.Observer;

public interface IView {

    void marquerTemps();
    void marquerMesure();
    void addObserver(Observer o);
}
