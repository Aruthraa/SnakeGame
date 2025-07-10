package SnakeGame;
import java.util.Scanner;

public class GameCtrl {
    public void initiate_game () {
        SnakeBoard obj = new SnakeBoard();
        obj.print_board();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter direction : ");
            char dir = sc.next().charAt(0);
            if(obj.mod_board(dir)) {
                obj.print_board();
            } else {
                System.out.println("Invalid move Game over :(");
                break;
            }
        }
    }
}
