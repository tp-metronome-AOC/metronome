package fr.istic.aoc.metronome.adapter.component.impl;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.TypeEventMarquage;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by ramage on 04/01/16.
 */
public class Horloge {

    private List<Command> pollsCommand = new ArrayList<Command>();
    private ScheduledExecutorService s;

    public Horloge(){
          s = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
              @Override
              public Thread newThread(Runnable r) {
                  Thread thread = new Thread(r);
                  thread.setDaemon(true);
                  return thread;
              }
          });
    }

    public void start(){
        s.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        for (Command poll:pollsCommand){
                            poll.execute();
                        }
                    }
                };
                Platform.runLater(runnable);
            }
        },0,30,TimeUnit.MILLISECONDS);
    }

    public void addPoll(Command command){
        pollsCommand.add(command);
    }
}
