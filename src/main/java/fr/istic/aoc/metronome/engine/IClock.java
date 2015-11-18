package fr.istic.aoc.metronome.engine;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;

public interface IClock {
    /** Adds a command to the clock
     * @param event The command event name
     * @param command The command
     **/
    void setCommand(TypeEventMarquage event,Command command);

    /** Starts the clock and sets an interval in milliseconds
     * @param timeInMs The interval time in milliseconds
     **/
    void startClock(Integer timeInMs);
}
