package fr.istic.aoc.metronome.engine;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;

public interface IClock {
    /** Adds a command to the clock **/
    void setCommand(TypeEventMarquage event,Command command);


    void startClock(Integer time);
}
