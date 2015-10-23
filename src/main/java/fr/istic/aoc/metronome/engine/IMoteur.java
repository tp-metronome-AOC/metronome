package fr.istic.aoc.metronome.engine;

public interface IMoteur {
    Integer getBPM();
    void setBPM(Integer bpm);

    Integer getBPMesure();
    void setBPMesure(Integer bpm);
}
