package fr.istic.aoc.metronome.controller;

public interface IControlleur {
    /** update the bpm of the engine */
    public void updateMolette();
    /** Method to start the engine */
    public void startMetronome();
    /** apply the new bpm on the clock */
    public void applyMolette();
    /** Method to stop the engine */
    public void stopMetronome();
    /** Method to increase the measure */
    public void increaseMetronome();
    /** Method to decrease the measure */
    public void decreaseMetronome();
}
