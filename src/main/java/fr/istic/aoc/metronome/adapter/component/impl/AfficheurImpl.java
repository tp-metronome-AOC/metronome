package fr.istic.aoc.metronome.adapter.component.impl;

import fr.istic.aoc.metronome.adapter.component.Afficheur;
import fr.istic.aoc.metronome.view.IView;

/**
 * Created by ramage on 04/01/16.
 */
public class AfficheurImpl implements Afficheur {

    private IView view;

    public AfficheurImpl(IView pView){
        view=pView;
    }

    @Override
    public void allumerLED(int numLED) {
        if(numLED == 1){
            view.marquerMesure();
        }else{
            view.marquerTemps();
        }
    }

    @Override
    public void afficherTempo(int valeurTempo) {
        view.setValueBpm(valeurTempo);
    }

    @Override
    public void afficherSignature(int signature) {
        view.setValueSignature(signature);
    }
}
