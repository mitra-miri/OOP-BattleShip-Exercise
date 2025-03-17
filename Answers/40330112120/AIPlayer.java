import java.util.List;
import java.util.ArrayList;
import java.util.Random;



public class AIPlayer extends Player {

    private List<String> HITS = new ArrayList<>();

    Coordinate coordinate = new Coordinate();

    public AIPlayer(int boardSize) {
        super(boardSize);

    }



    public String move() {

        int x;
        int y;
        Random rand = new Random();




        if(!(HITS.isEmpty())) {
            String firstHit = HITS.get(HITS.size() - 1);
            String secondHit = HITS.get(HITS.size() - 2);
            if (HITS.size() > 1 && firstHit.charAt(0) == secondHit.charAt(0)) {
                if (firstHit.charAt(1) < super.getTrackingGrid().getSize() && firstHit.charAt(1) > 0) {
                    if (coordinate.isValidInput(("" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') + 1)), super.getTrackingGrid().getGrid())) {
                        return "" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') + 1);
                    } else if (coordinate.isValidInput(("" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') - 1)), super.getTrackingGrid().getGrid())) {
                        return "" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') - 1);

                    }
                    if (firstHit.charAt(1) == (super.getTrackingGrid().getSize() - 1)) {
                        if (coordinate.isValidInput(("" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') - 1)), super.getTrackingGrid().getGrid())) {
                            return "" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') - 1);
                        }
                    }
                    if (firstHit.charAt(1) == 0) {
                        if (coordinate.isValidInput(("" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') + 1)), super.getTrackingGrid().getGrid())) {
                            return "" + firstHit.charAt(0) + ((firstHit.charAt(1) - '0') + 1);
                        }
                    }

                }
            }
            do {
                x = rand.nextInt(super.getTrackingGrid().getSize());
                y = rand.nextInt(super.getTrackingGrid().getSize());
            } while (coordinate.isValidInput(("" + (char) ('A' + x) + y), super.getTrackingGrid().getGrid()));

            return "" + (char) ('A' + x) + y;
        }
        do {
            x = rand.nextInt(super.getTrackingGrid().getSize());
            y = rand.nextInt(super.getTrackingGrid().getSize());
        } while (coordinate.isValidInput(("" + (char) ('A' + x) + y), super.getTrackingGrid().getGrid()));

        makeMove();
        return "" + (char) ('A' + x) + y;


    }

    public void makeMove(){
        String move = move();
        HITS.add(move);



    }


}
