package fr.istic.aoc.metronome.adapter.component.impl;

import fr.istic.aoc.metronome.adapter.component.Afficheur;
import fr.istic.aoc.metronome.adapter.component.Clavier;
import fr.istic.aoc.metronome.adapter.component.Molette;
import fr.istic.aoc.metronome.view.IView;

/**
 * Created by ramage on 04/01/16.
 */
public class Materiel {

    static Clavier clavier;
    static Molette molette;
    static Horloge horloge;
    static Afficheur afficheur;

    public Materiel(IView view){
        clavier= new ClavierImpl(view);
        molette= new MoletteImpl(view);
        afficheur= new AfficheurImpl(view);
        horloge = new Horloge();
    }

    public static Clavier getClavier(){
        return clavier;
    }

    public static Molette getMolette(){
        return molette;
    }

    public static Horloge getHorloge(){
        return horloge;
    }

    public static Afficheur getAfficheur(){return afficheur;}
}
