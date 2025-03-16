
public class Player extends Ship {

    private String name;
    private Board playerGride;
    private Board trackingGrid;

    public Player(String name , int boardSize) {
        this.name = name;
        playerGride = new Board(boardSize);
        trackingGrid = new Board(boardSize);
    }

    public void printTrackingGrid() {
       trackingGrid.printGrid();
    }




}
