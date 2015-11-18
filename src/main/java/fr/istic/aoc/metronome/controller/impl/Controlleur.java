package fr.istic.aoc.metronome.controller.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteur;
import fr.istic.aoc.metronome.controller.IControlleur;
import fr.istic.aoc.metronome.engine.IMoteur;
import fr.istic.aoc.metronome.engine.impl.Moteur;
import fr.istic.aoc.metronome.view.IView;

import java.util.Observable;
import java.util.Observer;

/**
 * Application main controller
 */
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
        moteur.addCommand(CommandMoteur.UpdateSignature, () -> view.setValueSignature(moteur.getBPMesure()));
        moteur.addCommand(CommandMoteur.MarquerTemps, () -> view.marquerTemps());
        moteur.addCommand(CommandMoteur.MarquerMesure, () -> view.marquerMesure());

        // Initialize molette
        initMolette();

        // Initialize signature
        initSignature();
    }

    private void initMolette(){
        view.setPositionMoletteToMiddle();
        updateMolette();
        applyMolette();
    }

    /** Initialisation of the measure */
    private void initSignature() {
        moteur.initBpMesure();
    }

    /**
     *  {@inheritDoc}
     */
    public void applyMolette() {
        moteur.applyBPM();
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
