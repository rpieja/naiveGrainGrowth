package pl.rpieja.ngr;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;

public class WindowController {
    @FXML
    ChoiceBox neighbourhoodTypeChoice;

    @FXML
    Canvas canvas;

    GraphicsContext gc;

    @FXML
    public void initialize() {
        neighbourhoodTypeChoice.setItems(FXCollections.observableArrayList(
                "Von Neumann",
                "Moore",
                "Hexagonal left",
                "Hexagonal right",
                "Hexagonal random",
                "Pentagonal random"
        ));

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

    }
}
