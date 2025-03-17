
public class Player {
//
//    private int number;
    private Board playerGride;
    private Board trackingGrid;

    public Player( int boardSize) {
//        this.number = number;
        playerGride = new Board(boardSize);
        trackingGrid = new Board(boardSize);
    }

    public void printTrackingGrid() {
       trackingGrid.printGrid();
    }

    public Board getTrackingGrid() {
        return trackingGrid;
    }
    public Board getPlayerGrid() {
        return playerGride;
    }

    public void printPlayerGrid() {
        playerGride.printGrid();
    }






}
