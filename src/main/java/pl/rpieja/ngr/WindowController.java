package pl.rpieja.ngr;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class WindowController {

    @FXML
    ToggleGroup tg;

    @FXML
    ChoiceBox neighbourhoodTypeChoice;

    @FXML
    Canvas canvas;

    @FXML
    Button generateGridButton;

    @FXML
    TextField gridSizeX, gridSizeY, tickRate, drawRadius;

    @FXML
    RadioButton rand, randWithRadius, even, handPicked;

    GraphicsContext gc;

    EventHandler<ActionEvent> eventHandler =
            new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    if(randWithRadius.isSelected())
                        drawRadius.setDisable(false);
                    else
                        drawRadius.setDisable(true);
                }
            };

    @FXML
    public void initialize() {

        tg = new ToggleGroup();

        neighbourhoodTypeChoice.setItems(FXCollections.observableArrayList(
                "Von Neumann",
                "Moore",
                "Hexagonal left",
                "Hexagonal right",
                "Hexagonal random",
                "Pentagonal random"
        ));

        gridSizeX.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,7}?")) {
                gridSizeX.setText(oldValue);
            }
        });

        gridSizeY.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,7}?")) {
                gridSizeY.setText(oldValue);
            }
        });

        tickRate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,7}?")) {
                tickRate.setText(oldValue);
            }
        });

        drawRadius.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,7}?")) {
                drawRadius.setText(oldValue);
            }
        });

        neighbourhoodTypeChoice.getSelectionModel().selectFirst();
        randWithRadius.addEventHandler(ActionEvent.ANY, eventHandler);
        rand.addEventHandler(ActionEvent.ANY, eventHandler);
        even.addEventHandler(ActionEvent.ANY, eventHandler);
        handPicked.addEventHandler(ActionEvent.ANY, eventHandler);
        if(randWithRadius.isSelected())
            drawRadius.setDisable(false);
        else
            drawRadius.setDisable(true);

        generateGridButton.setOnMouseClicked(event -> generateGrid());

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void generateGrid(){
        int gridX = 0, gridY = 0;
        try {
            gridX = Integer.valueOf(gridSizeX.getText());
            gridY = Integer.valueOf(gridSizeY.getText());
        }
        catch (Exception e){
            System.err.println("Error parsing grid values\n");
        }
        System.out.println("Grid Size:\nx: " + gridX + "\ny: " + gridY+"\n");
    }



}
