package fr.istic.aoc.metronome.engine;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;

public interface IClock {
    void setCommand(TypeEventMarquage event,Command command);
    void activatePeriodically(Integer time);
}
