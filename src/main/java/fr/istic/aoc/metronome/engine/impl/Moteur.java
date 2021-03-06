package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteur;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;
import fr.istic.aoc.metronome.engine.IMoteur;

import java.util.HashMap;
import java.util.Map;

public class Moteur implements IMoteur  {

    private Integer bpm;
    private Integer bpmMesure;
    private IClock clock;
    private Map<CommandMoteur,Command> mapCommand = new HashMap<CommandMoteur,Command>();
    //indicate if the engine is started
    private boolean started;

    private int currentTime = 0;

    public Moteur() {
        bpm = 10;
        bpmMesure = 4;
        clock = new Clock();
        clock.setCommand(TypeEventMarquage.TICK, () -> tick());
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
    public void applyBPM() {
        //when the bpm changed, we  synchronize with the clock
        if(started) {
            applyInterval();
        }
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
        if(started) {
            // If we are on a strong time
            if (currentTime % bpmMesure == 0) {
                mapCommand.get(CommandMoteur.MarquerMesure).execute();
            } else {
                mapCommand.get(CommandMoteur.MarquerTemps).execute();
            }
            // Increase the current time
            currentTime++;
        }
    }

    @Override
    public void start() {
        started=true;
        currentTime = 0;
        applyInterval();
    }

    private void applyInterval() {
        int intervalInMs = (int) (60/(double)bpm*1000);
        clock.startClock(intervalInMs);
    }

    @Override
    public void stop() {
        started=false;
    }

    @Override
    public void addCommand(CommandMoteur commandMoteur,Command command){
        mapCommand.put(commandMoteur,command);
    }

    @Override
    public void initBpMesure() {
        mapCommand.get(CommandMoteur.UpdateSignature).execute();
    }

    @Override
    public void incr() {
        bpmMesure++;
        if(bpmMesure>7){
            bpmMesure = 7;
        }
        mapCommand.get(CommandMoteur.UpdateSignature).execute();

    }

    @Override
    public void decr() {
        bpmMesure--;
        if(bpmMesure<2){
            bpmMesure = 2;
        }
        mapCommand.get(CommandMoteur.UpdateSignature).execute();

    }
}
