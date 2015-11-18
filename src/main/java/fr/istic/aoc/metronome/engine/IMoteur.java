package fr.istic.aoc.metronome.engine;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteur;
import fr.istic.aoc.metronome.command.TypeEventMarquage;

public interface IMoteur {
    /**
     * Gets the moteur BPM
     * @return The bpm
     */
    Integer getBPM();

    /**
     * Sets the moteur BPM
     * @param bpm The new bpm
     */
    void setBPM(Integer bpm);

    /**
     * Makes the moteur apply the setted BPM and change the clock tempo
     */
    void applyBPM();

    /**
     * Returns the BPMesure
     * @return the BPMesure
     */
    Integer getBPMesure();

    /**
     * Sends a tick
     */
    void tick();

    /**
     * Starts the moteur
     */
    void start();

    /**
     * Stops the moteur
     */
    void stop();

    /**
     * Adds a command to the moteur
     * @param commandMoteur The command name to add
     * @param command The command code to execute
     */
    void addCommand(CommandMoteur commandMoteur, Command command);

    /**
     * Initializes the BPMesure and the signature display
     */
    void initBpMesure();

    /**
     * Increases of one the BPMesure
     */
    void incr();

    /**
     * Decreases of one the BPMesure
     */
    void decr();
}
