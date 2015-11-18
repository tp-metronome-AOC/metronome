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
        moteur.addCommand(CommandMoteur.UpdateBpm, () -> view.setValueBpm(moteur.getBPM()));
        moteur.addCommand(CommandMoteur.UpdateSignature, () -> view.setValueSignature(moteur.getBPMesure()));
        moteur.addCommand(CommandMoteur.MarquerTemps, () -> view.marquerTemps());
        moteur.addCommand(CommandMoteur.MarquerMesure, () -> view.marquerMesure());

        // Initialize molette
        initMolette();

        // Initialize signature
        initSignature();
    }

    public void initMolette(){
        view.setPositionMoletteToMiddle();
        updateMolette();
        applyMolette();
    }

    public void initSignature() {
        moteur.initBpMesure();
    }

    public void applyMolette() {
        moteur.applyBPM();
    }

    public void updateMolette() {
        moteur.setBPM((int) view.getPositionMolette());
    }

    @Override
    public void startMetronome() {moteur.start();}

    @Override
    public void stopMetronome() {moteur.stop();}

    @Override
    public void increaseMetronome() {
        moteur.incr();
    }

    @Override
    public void decreaseMetronome() {
        moteur.decr();
    }

    @Override
    public void update(Observable o, Object arg) {
        ((Command) arg).execute();
    }
}
