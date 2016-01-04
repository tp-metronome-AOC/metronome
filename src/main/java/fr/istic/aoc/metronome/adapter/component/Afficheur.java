package fr.istic.aoc.metronome.adapter.component;

/**
 * Created by ramage on 04/01/16.
 */
public interface Afficheur {
    void allumerLED(int numLED);

    void afficherTempo(int valeurTempo);

    void afficherSignature(int signature);
}
