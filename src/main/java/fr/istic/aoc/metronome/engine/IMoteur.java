package fr.istic.aoc.metronome.engine;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteur;
import fr.istic.aoc.metronome.command.TypeEventMarquage;

public interface IMoteur {
    Integer getBPM();
    void setBPM(Integer bpm);

    Integer getBPMesure();
    void setBPMesure(Integer bpm);

    void tick();


    void start();
    void stop();
    void addCommand(CommandMoteur commandMoteur, Command command);
    void incr();
    void decr();
}
