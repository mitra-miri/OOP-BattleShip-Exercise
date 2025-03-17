public class Coordinate {

    private int row;
    private int col;


    public  boolean isValidInput(String input, char[][] trackingGrid) {

        if (input.length() != 2 || input.charAt(0) < 'A' || input.charAt(0) > 'J' || input.charAt(1) < '0' || input.charAt(1) > '9') {
            return false;
        }
        this.row = ((int) input.charAt(0)) - 65;
        this.col = Character.getNumericValue(input.charAt(1));

        if (trackingGrid[row][col] == '*' || trackingGrid[row][col] == '-' ) return false;
        return true;

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
