package fr.istic.aoc.metronome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Metronome App
 *
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

        stage.setTitle("Metronome");
        stage.setScene(new Scene(root, 300, 150));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("quit");
    }
}
