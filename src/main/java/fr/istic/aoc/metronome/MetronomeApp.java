package fr.istic.aoc.metronome;

import fr.istic.aoc.metronome.controller.IControlleur;
import fr.istic.aoc.metronome.controller.impl.Controlleur;
import fr.istic.aoc.metronome.engine.impl.Clock;
import fr.istic.aoc.metronome.engine.impl.Moteur;
import fr.istic.aoc.metronome.view.IView;
import fr.istic.aoc.metronome.view.MetronomeViewImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Metronome App
 */
public class MetronomeApp extends Application {

    public static void main(String[] args) {
        // launch JavaFX application
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/metronome.fxml").openStream());
        IView view = (MetronomeViewImpl) loader.getController();
        new Controlleur(view);
        stage.setTitle("Metronome");
        stage.setScene(new Scene(root, 450, 200));
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("quit");
    }
}
