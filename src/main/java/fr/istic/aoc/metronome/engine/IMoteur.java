package fr.istic.aoc.metronome.engine;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteurEnum;
import fr.istic.aoc.metronome.command.TypeEventMarquage;

public interface IMoteur {
    Integer getBPM();
    void setBPM(Integer bpm);

    Integer getBPMesure();
    void setBPMesure(Integer bpm);
    void addCommand(CommandMoteurEnum commandEnum, Command command);
}
