package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.engine.IClock;
import fr.istic.aoc.metronome.engine.IMoteur;

public class Moteur implements IMoteur {

    private Integer bpm;
    private Integer bpmMesure;
    private IClock clock;

    public Moteur() {
        bpm = 10;
        bpmMesure = 4;
        clock = new Clock();
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
}
