package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IMoteur;

import javax.activation.CommandMap;
import java.util.HashMap;

public class Moteur implements IMoteur {

    Integer bpm;
    Integer bpmMesure;
    HashMap<TypeEventMarquage,Command> mapCommandMarquage = new HashMap<TypeEventMarquage,Command>();

    public Moteur(){
        bpm = 0;
        bpmMesure = 4;
    }

    @Override
    public Integer getBPM() {
        return bpm;
    }

    @Override
    public void setBPM(Integer bpm) {
        this.bpm=bpm;
    }

    @Override
    public Integer getBPMesure() {
        return bpmMesure;
    }

    @Override
    public void setBPMesure(Integer bpm) {
        this.bpmMesure = bpm;
    }

    public void setCommand(TypeEventMarquage event,Command command){
        mapCommandMarquage.put(event,command);
    }
}
