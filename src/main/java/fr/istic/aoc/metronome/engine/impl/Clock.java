package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;
import jdk.nashorn.internal.objects.NativeArray;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Clock implements IClock{


    private Map<TypeEventMarquage,Command> mapEventCommand = new HashMap<TypeEventMarquage,Command>();
    private ScheduledExecutorService schedule;

    public void setCommand(TypeEventMarquage event,Command command){
        mapEventCommand.put(event,command);
    }

    @Override
    public void activatePeriodically(Integer time) {
        schedule = Executors.newScheduledThreadPool(1);
        schedule.scheduleAtFixedRate((Runnable) () -> mapEventCommand.get(TypeEventMarquage.MARQUERTEMPS).execute(),0,time,TimeUnit.SECONDS);
    }

    ;
}
