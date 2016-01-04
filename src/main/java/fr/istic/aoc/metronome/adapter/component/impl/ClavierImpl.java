package fr.istic.aoc.metronome.adapter.component.impl;

import fr.istic.aoc.metronome.adapter.component.Clavier;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.view.IView;

/**
 * Created by ramage on 04/01/16.
 */
public class ClavierImpl implements Clavier {

    private IView view;

    public ClavierImpl(IView pView){
        view=pView;
    }

    @Override
    public boolean touchePresse(int i) {
        switch(i){
            case 1: return view.getStateButtonStart();
            case 2: return view.getStateButtonStop();
            case 3: return view.getStateButtonIncrease();
            case 4: return view.getStateButtonDecrease();
            default: return false;
        }
    }
}
