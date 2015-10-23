package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.engine.IClock;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Clock implements IClock{

    public Clock() {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
        //s.scheduleAtFixedRate();
    }
}
