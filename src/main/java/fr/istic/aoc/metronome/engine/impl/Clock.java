package fr.istic.aoc.metronome.engine.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import fr.istic.aoc.metronome.engine.IClock;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Clock implements IClock{

    private int intervalInMs = 0;

    private HashMap<TypeEventMarquage,Command> mapEventCommand = new HashMap<TypeEventMarquage,Command>();
    private ScheduledExecutorService s;
    private ScheduledFuture<?> sf;


    public void setCommand(TypeEventMarquage event,Command command){
        mapEventCommand.put(event,command);
    };

    public Clock(){
        if(s!=null){s.shutdown();}
        s = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void activateAfterDelay(Integer time) {
        if(sf != null) {
            sf.cancel(false);
        }

        sf = s.scheduleAtFixedRate(
                (Runnable) () -> mapEventCommand.get(TypeEventMarquage.TICK).execute(),0,time, TimeUnit.MILLISECONDS);
    }
}
