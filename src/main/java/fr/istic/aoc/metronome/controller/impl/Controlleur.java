package fr.istic.aoc.metronome.controller.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteur;
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
        /** Engine Initialization Command.*/
        moteur.addCommand(CommandMoteur.UpdateBpm, () -> view.setValueBpm(moteur.getBPM()));
        moteur.addCommand(CommandMoteur.MarquerTemps, () -> view.marquerTemps());
        moteur.addCommand(CommandMoteur.MarquerMesure, () -> view.marquerMesure());

        // Initialize molette
        initMolette();
    }

    /** Initialize the position of the molette */
    private void initMolette(){
        view.setPositionMoletteToMiddle();
        updateMolette();
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void updateMolette() {
        moteur.setBPM((int) view.getPositionMolette());
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void startMetronome() {moteur.start();}

    /**
     *  {@inheritDoc}
     */
    @Override
    public void stopMetronome() {moteur.stop();}

    /**
     *  {@inheritDoc}
     */
    @Override
    public void increaseMetronome() {
        moteur.incr();
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void decreaseMetronome() {
        moteur.decr();
    }

    /** execute a command on the engine */
    @Override
    public void update(Observable o, Object arg) {
        ((Command) arg).execute();
    }
}
