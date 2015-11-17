package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;
import jdk.nashorn.internal.objects.NativeArray;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock implements IClock{

    private int intervalInMs = 0;

    private HashMap<TypeEventMarquage,Command> mapEventCommand = new HashMap<TypeEventMarquage,Command>();
    private ScheduledExecutorService s;
    public void setCommand(TypeEventMarquage event,Command command){
        mapEventCommand.put(event,command);
    };

    @Override
    public void activatePeriodically(Integer time) {
        if(s!=null){s.shutdown();}
        s = Executors.newScheduledThreadPool(1);
        s.scheduleAtFixedRate((Runnable) () -> mapEventCommand.get(TypeEventMarquage.MARQUERTEMPS).execute(),0,time, TimeUnit.MILLISECONDS);
    }
}
