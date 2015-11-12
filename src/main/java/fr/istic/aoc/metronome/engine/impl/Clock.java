package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;
import jdk.nashorn.internal.objects.NativeArray;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Clock implements IClock{

    private int intervalInMs = 0;

    private HashMap<TypeEventMarquage,Command> mapEventCommand = new HashMap<TypeEventMarquage,Command>();

    public Clock() {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
        //s.scheduleAtFixedRate();
    }

    public void setCommand(TypeEventMarquage event,Command command){
        mapEventCommand.put(event,command);
    };

    public void init(int intervalInMs) {
        this.intervalInMs = intervalInMs;
    }
}
