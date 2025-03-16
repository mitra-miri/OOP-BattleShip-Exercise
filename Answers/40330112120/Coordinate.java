public class Coordinate {

    private int row;
    private int col;

    public Coordinate (int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static boolean isValidInput(String input, char[][] trackingGrid) {

        if (input.length() != 2 || input.charAt(0) < 'A' || input.charAt(0) > 'J' || input.charAt(1) < '0' || input.charAt(1) > '9') {
            return false;
        }
        int ROW = ((int) input.charAt(0)) - 65;
        int COL = Character.getNumericValue(input.charAt(1));
        if (trackingGrid[ROW][COL] == '*' || trackingGrid[ROW][COL] == '-') return false;
        return true;
    }

}
