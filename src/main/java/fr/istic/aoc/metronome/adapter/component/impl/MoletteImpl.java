package fr.istic.aoc.metronome.adapter.component.impl;

import fr.istic.aoc.metronome.adapter.component.Molette;
import fr.istic.aoc.metronome.view.IView;

/**
 * Created by ramage on 04/01/16.
 */
public class MoletteImpl implements Molette {

    private IView view;

    public MoletteImpl(IView pView){
        view=pView;
    }

    @Override
    public double position() {
        return view.getPositionMolette();
    }
}
