package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.controller.IControlleur;

import java.util.Observer;

public interface IView {

    void marquerTemps();

    void marquerMesure();

    void addObserver(Observer o);

    void setControlleur(IControlleur controlleur);

    double getPositionMolette();

    double getMiddleMoletteValue();

    void setValueBpm(Integer value);
}
