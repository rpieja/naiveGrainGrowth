package pl.rpieja.ngr;

import javafx.scene.canvas.GraphicsContext;

public class Grid {

    private int gridX, gridY, rows, collumns;
    GraphicsContext gc;

    public Grid(GraphicsContext gc, int gridX, int gridY, int rows, int collumns){
        this.gc=gc;
        this.gridX=gridX;
        this.gridY=gridY;
        this.rows=rows;
        this.collumns=collumns;
    }

    public void printGrid(){

    }
}
