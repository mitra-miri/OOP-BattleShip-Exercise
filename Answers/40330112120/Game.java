import java.util.Scanner;

public class Game {





    public  void start() {
        boolean playAgain;
        do {
            playGame();
            playAgain = askReplay();
        } while (playAgain);
    }

    private boolean askReplay() {
        System.out.println("Play again? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equalsIgnoreCase("yes");
    }

    private void playGame() {

        System.out.println("Enter the size of the grid: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        System.out.println("multi player(0) or single player(1)");
        Scanner scanner = new Scanner(System.in);
        int player = scanner.nextInt();

        if (player == 0) {
            Player player1 = new Player(size);
            Player player2 = new Player(size);

            System.out.println("Manual placement of player 1 ships(Enter 0)\n" +"Automatic placement of player 1 ships(Enter 1)");
            int ship = scanner.nextInt();

            if(ship == 1) {
                int numberOfCells = 2;
                char shipName = 'A';
                ShipPlacer shipPlacer = new ShipPlacer();
                for (int i = 0; i < 4+(size-10); i++) {
                    Ship SHIP = new Ship(shipName,numberOfCells);

                    shipPlacer.placeShipRandomly(player1.getPlayerGrid(), SHIP);

                    numberOfCells = numberOfCells + 1;
                    shipName = (char)((int)shipName +1);
                }
            }else {
                int numberOfCells = 2;
                char shipName = 'A';
                ShipPlacer shipPlacer = new ShipPlacer();
                for (int i = 0; i < 4+(size-10); i++) {
                    Ship SHIP = new Ship(shipName, numberOfCells);

                    shipPlacer.placeShipManual(player1,player1.getPlayerGrid(), SHIP);

                    numberOfCells = numberOfCells + 1;
                    shipName = (char) ((int) shipName + 1);
                }
            }

            System.out.println("Manual placement of player 2 ships(Enter 0)\n" +"Automatic placement of player 2 ships(Enter 1)");
            int ship2 = scanner.nextInt();

            if(ship2 == 1) {
                int numberOfCells = 2;
                char shipName = 'A';
                ShipPlacer shipPlacer = new ShipPlacer();
                for (int i = 0; i < 4+(size-10); i++) {
                    Ship SHIP = new Ship(shipName,numberOfCells);

                    shipPlacer.placeShipRandomly(player2.getPlayerGrid(), SHIP);

                    numberOfCells = numberOfCells + 1;
                    shipName = (char)((int)shipName +1);
                }
            }else {
                int numberOfCells = 2;
                char shipName = 'A';
                ShipPlacer shipPlacer = new ShipPlacer();
                for (int i = 0; i < 4+(size-10); i++) {
                    Ship SHIP = new Ship(shipName, numberOfCells);

                    shipPlacer.placeShipManual(player2,player2.getPlayerGrid(), SHIP);

                    numberOfCells = numberOfCells + 1;
                    shipName = (char) ((int) shipName + 1);
                }
            }

            boolean player1Turn = true;

            while (!isGameOver (player2.getPlayerGrid())&& !isGameOver(player1.getPlayerGrid())) {
                if (player1Turn) {
                    System.out.println("Player 1's turn:");
                    player1.printTrackingGrid();
                    playerTurn(player2.getPlayerGrid().getGrid(), player1.getTrackingGrid().getGrid(), player1.getTrackingGrid().getSize());
                } else {
                    System.out.println("Player 2's turn:");
                    player2.printTrackingGrid();
                    playerTurn(player1.getPlayerGrid().getGrid(), player2.getTrackingGrid().getGrid(), player1.getTrackingGrid().getSize());
                }
                player1Turn = !player1Turn;
            }
        }

        if (player == 1) {
            Player player1 = new Player( size);
            AIPlayer player2 = new AIPlayer(size);

            System.out.println("Manual placement of player 1 ships(Enter 0)\n" +"Automatic placement of player 1 ships(Enter 1)");
            int ship = scanner.nextInt();

            if(ship == 1 ) {
                int numberOfCells = 2;
                char shipName = 'A';
                ShipPlacer shipPlacer = new ShipPlacer();
                for (int i = 0; i < 4+(size-10); i++) {
                    Ship SHIP = new Ship(shipName,numberOfCells);

                    shipPlacer.placeShipRandomly(player1.getPlayerGrid(), SHIP);

                    shipName = (char)((int)shipName +1);
                }
            }else {
                int numberOfCells = 2;
                char shipName = 'A';
                ShipPlacer shipPlacer = new ShipPlacer();
                for (int i = 0; i < 4+(size-10); i++) {
                    Ship SHIP = new Ship(shipName, numberOfCells);

                    shipPlacer.placeShipManual(player1,player1.getPlayerGrid(), SHIP);

                    numberOfCells = numberOfCells + 1;
                    shipName = (char) ((int) shipName + 1);
                }


            }
            int numberOfCellsAI = 2;
            char shipNameAI = 'A';
            ShipPlacer shipPlacer = new ShipPlacer();
            for (int i = 0; i < 4+(size-10); i++) {
                Ship SHIP = new Ship(shipNameAI, numberOfCellsAI);

                shipPlacer.placeShipRandomly(player2.getPlayerGrid(), SHIP);

                numberOfCellsAI = numberOfCellsAI + 1;
                shipNameAI = (char) ((int) shipNameAI + 1);
            }




            boolean player1Turn = true;

            while (!isGameOver(player2.getPlayerGrid())&& !isGameOver(player1.getPlayerGrid())) {
                if (player1Turn) {
                    System.out.println("Player 1's turn:");
                    player1.printTrackingGrid();
                    playerTurn(player2.getPlayerGrid().getGrid(), player1.getTrackingGrid().getGrid(), player1.getTrackingGrid().getSize());
                } else {
                    System.out.println("Player 2's turn:");
                    player2.printTrackingGrid();
                    AITurn(player1.getPlayerGrid().getGrid(), player2.getTrackingGrid().getGrid(), player1.getTrackingGrid().getSize());
                }
                player1Turn = !player1Turn;
            }

        }


    }


        public void playerTurn(char[][] opponentGrid, char[][] trackingGrid, int GRID_SIZE ) {

            Scanner scan1 = new Scanner(System.in);
            String input;
            System.out.print("Enter your guess (example: A1): ");
            input = scan1.nextLine();

            Coordinate coordinate = new Coordinate();
            if (!coordinate.isValidInput(input , trackingGrid)) {
                System.out.println("Invalid input!");
            }else if (opponentGrid[coordinate.getRow()][coordinate.getCol()] != '~'
                      && opponentGrid[coordinate.getRow()][coordinate.getCol()] != '-'
                      && opponentGrid[coordinate.getRow()][coordinate.getCol()] != '*') {
                char shipHit = opponentGrid[coordinate.getRow()][coordinate.getCol()];
                System.out.println("Hit!");
                trackingGrid[coordinate.getRow()][coordinate.getCol()] = '*';
                opponentGrid[coordinate.getRow()][coordinate.getCol()] = '*';
                if (shipsSunk(shipHit, opponentGrid, GRID_SIZE)) {
                    System.out.println("Sunk!");
                }
            } else {
                System.out.println("Miss!");
                trackingGrid[coordinate.getRow()][coordinate.getCol()] = '-';
                opponentGrid[coordinate.getRow()][coordinate.getCol()] = '-';
            }
        }

    public void AITurn(char[][] opponentGrid, char[][] trackingGrid, int GRID_SIZE ) {


        Coordinate coordinate = new Coordinate();
         if (opponentGrid[coordinate.getRow()][coordinate.getCol()] != '~'
                && opponentGrid[coordinate.getRow()][coordinate.getCol()] != '-'
                && opponentGrid[coordinate.getRow()][coordinate.getCol()] != '*') {
            char shipHit = opponentGrid[coordinate.getRow()][coordinate.getCol()];
            System.out.println("Hit!");
            trackingGrid[coordinate.getRow()][coordinate.getCol()] = '*';
            opponentGrid[coordinate.getRow()][coordinate.getCol()] = '*';
            if (shipsSunk(shipHit, opponentGrid, GRID_SIZE)) {
                System.out.println("Sunk!");
            }
        } else {
            System.out.println("Miss!");
            trackingGrid[coordinate.getRow()][coordinate.getCol()] = '-';
            opponentGrid[coordinate.getRow()][coordinate.getCol()] = '-';
        }
    }

        public boolean shipsSunk(char SHIP, char[][] board , int GRID_SIZE) {
            int sum = 0;
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (board[i][j] == SHIP) {
                        sum = sum + 1;
                    }
                }
            }
            if (sum == 0) {
                return true;
            }
            else return false;
        }


    public boolean isGameOver( Board board) {
        int sum = 0;
        char[][] grid = board.getGrid();
       for( char[] i : grid){
           for(char j : i){
               if(j!= '~' && j != '-' && j != '*'){
                   sum = sum + 1;
               }
           }
       }
       if (sum == 0) {return true;}
       return false;
    }



}
