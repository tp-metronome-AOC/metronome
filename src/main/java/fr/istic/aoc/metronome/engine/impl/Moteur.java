package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteur;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;
import fr.istic.aoc.metronome.engine.IMoteur;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Moteur implements IMoteur  {

    private Integer bpm;
    private Integer bpmMesure;
    private IClock clock;
    Map<CommandMoteur,Command> mapCommand = new HashMap<CommandMoteur,Command>();

    private int currentTime = 0;

    public Moteur() {
        bpm = 10;
        bpmMesure = 4;
        clock = new Clock();

        clock.setCommand(TypeEventMarquage.MARQUERTEMPS, () -> tick());
    }

    @Override
    public Integer getBPM() {
        return bpm;
    }

    @Override
    public void setBPM(Integer bpm) {
        this.bpm = bpm;
        mapCommand.get(CommandMoteur.UpdateBpm).execute();
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
    public void tick() {
        // Increase the current time
        currentTime++;
        // If we are on a strong time
        if (currentTime%bpmMesure == 0) {
            mapCommand.get(CommandMoteur.MarquerMesure).execute();
        }
        else {
            mapCommand.get(CommandMoteur.MarquerTemps).execute();
        }
    }

    @Override
    public void start() {
        currentTime = 0;
        int intervalInMs = (int)(60/(double)bpm*1000);
        clock.activatePeriodically(intervalInMs);
    }

    @Override
    public void stop() {

    }

    @Override
    public void addCommand(CommandMoteur commandMoteur,Command command){
        mapCommand.put(commandMoteur,command);
    }

}
