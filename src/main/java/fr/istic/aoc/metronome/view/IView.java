package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.controller.IControlleur;

import java.util.Observable;
import java.util.Observer;

public interface IView {

    void marquerTemps();
    void marquerMesure();
    void addObserver(Observer o);
    void setControlleur(IControlleur controlleur);
}
