package fr.istic.aoc.metronome.adapter;

import fr.istic.aoc.metronome.adapter.component.impl.Materiel;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.controller.IControlleur;
import fr.istic.aoc.metronome.view.IView;

/**
 * Created by ramage on 18/11/15.
 */
public class Adapter implements IAdapter {

    private IControlleur controller;
    Materiel materiel;

    private boolean oldStateStart;
    private boolean oldStateStop;
    private boolean oldStateIncrease;
    private boolean oldStateDecrease;
    private double oldPositionMolette;

    public Adapter(IView view, IControlleur pController){
        controller=pController;
        //ajout d'une commande sur le clavier
        Materiel.getHorloge().addPoll(
                () -> {
                    boolean resultPressed=Materiel.getClavier().touchePresse(1);
                    if(oldStateStart && !resultPressed){
                        controller.startMetronome();
                    }
                    oldStateStart = resultPressed;
                    resultPressed=Materiel.getClavier().touchePresse(2);
                    if(oldStateStop && !resultPressed){
                        controller.stopMetronome();
                    }
                    oldStateStop = resultPressed;
                    resultPressed=Materiel.getClavier().touchePresse(3);
                    if(oldStateIncrease && !resultPressed){
                        controller.increaseMetronome();
                    }
                    oldStateIncrease = resultPressed;

                    resultPressed=Materiel.getClavier().touchePresse(4);
                    if(oldStateDecrease && !resultPressed){
                        controller.decreaseMetronome();
                    }
                    oldStateDecrease = resultPressed;


                }
        );

        Materiel.getHorloge().addPoll(() -> {
            double resultPosition = Materiel.getMolette().position();
            if (resultPosition != oldPositionMolette)
            {
                oldPositionMolette = resultPosition;
                controller.updateMolette(resultPosition);
                controller.applyMolette();
            }
        });
    }


    public void setValueBpm(Integer valueBpm) {
        Materiel.getAfficheur().afficherTempo(valueBpm);
    }

    @Override
    public void marquerMesure() {
        Materiel.getAfficheur().allumerLED(1);
    }

    @Override
    public void marquerTemps() {
        Materiel.getAfficheur().allumerLED(2);
    }

    public void setValueSignature(Integer valueSignature) {
        Materiel.getAfficheur().afficherSignature(valueSignature);
    }
}
