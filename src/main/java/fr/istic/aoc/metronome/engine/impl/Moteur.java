package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteurEnum;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;
import fr.istic.aoc.metronome.engine.IMoteur;

import java.util.HashMap;
import java.util.Map;

public class Moteur implements IMoteur {

    private Integer bpm;
    private Integer bpmMesure;
    private IClock clock;
    private Map<CommandMoteurEnum,Command> mapCommand = new HashMap<CommandMoteurEnum,Command>();

    public Moteur() {
        bpm = 10;
        bpmMesure = 4;
        clock = new Clock();

        clock.setCommand(TypeEventMarquage.MARQUERTEMPS, new Command() {
            @Override
            public void execute() {
                mapCommand.get(CommandMoteurEnum.MarquerTemps).execute();
            }
        });
        clock.activatePeriodically(1);

    }

    @Override
    public Integer getBPM() {
        return bpm;
    }

    @Override
    public void setBPM(Integer bpm) {
        this.bpm = bpm;
        mapCommand.get(CommandMoteurEnum.UpdateBpm).execute();
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
    public void addCommand(CommandMoteurEnum commandEnum,Command command){
        mapCommand.put(commandEnum,command);
    }
}
