public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid(grid);
    }

    public int getSize() {
        return size;
    }

    public void initializeGrid(char[][] grid) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '~';
            }
        }
    }

    public boolean canplaceShip(Ship ship, int row, int col ,boolean horizontal, int numberOfCell) {
        if (horizontal) {
            if (col + numberOfCell > size) return false;
            for (int j = col; j < col + numberOfCell; ++j) {
                if (grid[row][j] != '~') return false;
            }
        } else {
            if (row + numberOfCell > size) return false;
            for (int i = row; i < row + numberOfCell; ++i) {
                if (grid[i][col] != '~') return false;
            }
        }
        return true;
    }

    public boolean placeShip(Ship ship,int row, int col, boolean horizontal) {
        if(canplaceShip(ship,row,col,horizontal, ship.getSize())) {
            if (horizontal) {
                for (int j = col; j < col + ship.getSize(); ++j) {
                    grid[row][j] = ship.getName();
                }
            } else {
                for (int i = row; i < row + ship.getSize(); ++i) {
                    grid[i][col] = ship.getName();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void printGrid(){

        System.out.print("    ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print("+---");
        }
        System.out.println("+");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print("| " + grid[i][j] + " ");
            }
            System.out.println("|");
            System.out.print("  ");
            for (int l = 0; l < size; l++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }
    public char[][] getGrid() {
        return grid;
    }


}

