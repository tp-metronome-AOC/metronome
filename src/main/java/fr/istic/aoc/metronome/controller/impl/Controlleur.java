package fr.istic.aoc.metronome.controller.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteurEnum;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.controller.IControlleur;
import fr.istic.aoc.metronome.engine.IClock;
import fr.istic.aoc.metronome.engine.IMoteur;
import fr.istic.aoc.metronome.engine.impl.Clock;
import fr.istic.aoc.metronome.engine.impl.Moteur;
import fr.istic.aoc.metronome.view.IView;

import java.util.Observable;
import java.util.Observer;

public class Controlleur implements IControlleur, Observer {

    private IView view;
    private IMoteur moteur;

    public Controlleur(IView pView) {
        view = pView;
        view.addObserver(this);
        view.setControlleur(this);

        moteur = new Moteur();
        IClock clock = new Clock();
        clock.setCommand(TypeEventMarquage.MARQUERMESURE, view::marquerMesure);
        clock.setCommand(TypeEventMarquage.MARQUERMESURE, view::marquerTemps);
        moteur.addCommand(CommandMoteurEnum.UpdateBpm, new Command() {
            @Override
            public void execute() {
                view.setValueBpm(moteur.getBPM());
            }
        });
    }

    public void onBpmChanged() {
    }

    public void updateMolette() {
        moteur.setBPM((int) view.getPositionMolette());
    }

    @Override
    public void update(Observable o, Object arg) {
        ((Command) arg).execute();
    }
}
