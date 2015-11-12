package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;
import fr.istic.aoc.metronome.engine.IMoteur;

import java.util.Observable;

public class Moteur extends Observable implements IMoteur  {

    private Integer bpm;
    private Integer bpmMesure;
    private IClock clock;

    public Moteur() {
        bpm = 10;
        bpmMesure = 4;
        clock = new Clock();

        clock.setCommand(TypeEventMarquage.MARQUERTEMPS, this::tickTemps);
        clock.setCommand(TypeEventMarquage.MARQUERMESURE, this::tickMesure);
    }

    @Override
    public Integer getBPM() {
        return bpm;
    }

    @Override
    public void setBPM(Integer bpm) {
        this.bpm = bpm;
    }

    @Override
    public Integer getBPMesure() {
        return bpmMesure;
    }

    @Override
    public void setBPMesure(Integer bpm) {
        this.bpmMesure = bpm;
    }

    @Override
    public void tickTemps() {
        hasChanged();
        notifyObservers();
    }

    @Override
    public void tickMesure() {
        hasChanged();
        notifyObservers();
    }

    @Override
    public void start() {
        int intervalInMs = 60/bpm*1000;
        clock.init(intervalInMs);

        clock.setInterval(() -> {
            this.tickMesure();
        }, intervalInMs);
    }

    @Override
    public void stop() {

    }


}
