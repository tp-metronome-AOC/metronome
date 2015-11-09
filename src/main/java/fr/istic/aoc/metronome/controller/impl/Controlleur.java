package fr.istic.aoc.metronome.controller.impl;

import fr.istic.aoc.metronome.controller.IControlleur;

import java.util.Observable;
import java.util.Observer;

public class Controlleur implements IControlleur, Observer {

    @Override
    public void marquerTemps() {

    }

    @Override
    public void marquerMesure() {

    }

    public void onBpmChanged() {
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.toString());
    }
}
