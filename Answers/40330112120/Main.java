import java.util.Scanner;

public class Main {
    public static void main(String[]  args) {
        System.out.println("Enter the size of the grid: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        Game game = new Game(size);
        game.start();

    }
}