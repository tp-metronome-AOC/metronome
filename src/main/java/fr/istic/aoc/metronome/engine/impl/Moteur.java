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

    //indicates if the engine is started
    private boolean started;

    private int currentTime = 0;

    public Moteur() {
        bpm = 10;
        bpmMesure = 4;
        clock = new Clock();
        clock.setCommand(TypeEventMarquage.TICK, () -> tick());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getBPM() {
        return bpm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBPM(Integer bpm) {
        this.bpm = bpm;
        mapCommand.get(CommandMoteur.UpdateBpm).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyBPM() {
        //when the bpm changed, we  synchronize with the clock
        if(started) {
            applyInterval();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getBPMesure() {
        return bpmMesure;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        started=true;
        currentTime = 0;
        applyInterval();
    }

    /**
     * Applies the new interval to the clock
     */
    private void applyInterval() {
        int intervalInMs = (int) (60/(double)bpm*1000);
        clock.startClock(intervalInMs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        started=false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCommand(CommandMoteur commandMoteur,Command command){
        mapCommand.put(commandMoteur,command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initBpMesure() {
        mapCommand.get(CommandMoteur.UpdateSignature).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incr() {
        bpmMesure++;
        if(bpmMesure>7){
            bpmMesure = 7;
        }
        mapCommand.get(CommandMoteur.UpdateSignature).execute();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decr() {
        bpmMesure--;
        if(bpmMesure<2){
            bpmMesure = 2;
        }
        mapCommand.get(CommandMoteur.UpdateSignature).execute();

    }
}
