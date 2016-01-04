package fr.istic.aoc.metronome.adapter;

/**
 * Created by ramage on 04/01/16.
 */
public interface IAdapter {
    void marquerTemps();

    void setValueSignature(Integer bpMesure);

    void setValueBpm(Integer bpm);

    void marquerMesure();
}
