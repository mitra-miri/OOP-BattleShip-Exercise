public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid(grid);
    }

//    public int getSize() {
//        return size;
//    }

    public void initializeGrid(char[][] grid) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '~';
            }
        }
    }

    public void printGrid(char[][] grid) {

        System.out.print("  ");

        for(char i = 'A'; i <= 'J' ; i++) {
            System.out.print("  "+i+" ");
        }

        System.out.println();
        System.out.print("  ");


        for (int i = 0; i < size ; i++) {
            System.out.print("+---");
        }
        System.out.println("+");


        for (int i = 0; i < size; i++) {

            System.out.print("  ");

            for (int j = 0; j < size; j++) {
                System.out.print("| " +grid[i][j]+ " ");
            }
            System.out.println("|");


            System.out.print("  ");


            for (int l = 0; l < size ; l++) {
                System.out.print("+---");
            }
            System.out.println("+");


        }
    }

}

