package fr.istic.aoc.metronome.controller.impl;

import fr.istic.aoc.metronome.adapter.Adapter;
import fr.istic.aoc.metronome.adapter.IAdapter;
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
public class Controlleur implements IControlleur {

    private IAdapter adapter;
    private IMoteur moteur;

    public Controlleur(IView pView) {
        adapter = new Adapter(pView,this);

        moteur = new Moteur();
        /** Engine Initialization Command.*/
        moteur.addCommand(CommandMoteur.UpdateBpm, () -> adapter.setValueBpm(moteur.getBPM()));
        moteur.addCommand(CommandMoteur.UpdateSignature, () -> adapter.setValueSignature(moteur.getBPMesure()));
        moteur.addCommand(CommandMoteur.MarquerTemps, () -> adapter.marquerTemps());
        moteur.addCommand(CommandMoteur.MarquerMesure, () -> adapter.marquerMesure());

        // Initialize molette
        initMolette();

        // Initialize signature
        initSignature();
    }

    private void initMolette(){
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
    public void updateMolette(double valueMolette) {
        moteur.setBPM((int)valueMolette);
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

}
