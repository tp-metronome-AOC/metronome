package fr.istic.aoc.metronome;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.CommandMoteur;
import fr.istic.aoc.metronome.engine.IMoteur;
import fr.istic.aoc.metronome.engine.impl.Clock;
import fr.istic.aoc.metronome.engine.impl.Moteur;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by ramage on 17/11/15.
 */
public class MoteurTest {

    @InjectMocks
    private Moteur moteur;

    @Mock
    private Clock clock;

    @Before
    public void setUp(){
        moteur = new Moteur();
        MockitoAnnotations.initMocks(this);
        moteur.addCommand(CommandMoteur.UpdateBpm, new Command() {
            @Override
            public void execute() {

            }
        });
    }

    @Test
    public void testIncr(){
        //default bpm mesure
        assertEquals(4,moteur.getBPMesure().intValue());
        moteur.incr();
        assertEquals(5,moteur.getBPMesure().intValue());
        moteur.incr();
        assertEquals(6,moteur.getBPMesure().intValue());
        moteur.incr();
        assertEquals(7,moteur.getBPMesure().intValue());
        moteur.incr();
        //max bpm mesure is 7
        assertEquals(7,moteur.getBPMesure().intValue());
    }

    @Test
    public void testDecr(){
        //default bpm mesure
        assertEquals(4,moteur.getBPMesure().intValue());
        moteur.decr();
        assertEquals(3,moteur.getBPMesure().intValue());
        moteur.decr();
        assertEquals(2,moteur.getBPMesure().intValue());
        moteur.decr();
        //min bpm mesure
        assertEquals(2,moteur.getBPMesure().intValue());
    }

    @Test
    public void testStart(){
        moteur.setBPM(100);
        moteur.start();
        Mockito.verify(clock).activateAfterDelay(caluclateDelay(moteur.getBPM()));
    }

    private int caluclateDelay(int bpm){
       return (int)(60/(double)bpm*1000);
    }

}
