import java.util.Random;
import java.util.Scanner;

public class ShipPlacer {


    public  void placeShipRandomly(Board board, Ship ship) {
        Random rand = new Random();
        boolean placed = false;


        while (!placed) {
            int row = rand.nextInt(board.getSize());
            int col = rand.nextInt(board.getSize());
            boolean horizontal = rand.nextBoolean();
            placed = board.placeShip( ship, row, col, horizontal);
        }
    }

    public void placeShipManual(Player player,Board board, Ship ship) {
        player.printPlayerGrid();

        System.out.println("Choose horizontal or vertical scrolling(horizontal = 0 && vertical = 1): ");
        Scanner scanInt = new Scanner(System.in);
        int horizontal = scanInt.nextInt();

        Coordinate coordinate = new Coordinate();
        String choice;
        do{
            System.out.println("Enter ship position(for example A5): ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();

        }while (!coordinate.isValidInput(choice, board.getGrid()));

        boolean placed = false;


        while (!placed) {
            boolean HORIZONTAL = (horizontal==0);
            placed = board.placeShip( ship, coordinate.getRow(), coordinate.getCol(), HORIZONTAL);
        }

    }
}