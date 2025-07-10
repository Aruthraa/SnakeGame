package SnakeGame;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SnakeBoard {
    // static char[][] board = {
    //     {'.','.','.','.','.','.','.','.'},
    //     {'.','.','.','.','.','.','.','.'},
    //     {'.','.','.','.','.','.','.','.'},
    //     {'.','.','.','.','.','.','.','.'},
    //     {'.','.','.','.','.','.','.','.'},
    //     {'.','.','.','.','.','.','.','.'},
    //     {'.','.','.','.','.','.','.','.'},
    //     {'.','.','.','.','.','.','.','.'}
    // };
    static char[][] board = {
        {'.','.','.','.'},
        {'.','.','.','.'},
        {'.','.','.','.'},
        {'.','.','.','.'}
    };
    public ArrayList<Point> brd_points = new ArrayList<Point>();
    static Food f;
    static SnakeBody body;
    public SnakeBoard() {
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                brd_points.add(new Point(i, j));
            }
        }
        brd_points.remove(0);
        brd_points.remove(1);
        this.f = new Food();
        board[f.food.x][f.food.y] = 'f';
        this.body = new SnakeBody();
        for (Point p : body.body) {
            board[p.x][p.y] = '*';
        }
    }
    static boolean isValid(Point hd) {
        if(hd.x < 0 || hd.x > 3 || hd.y < 0 || hd.y > 3 || board[hd.x][hd.y] == '*') {
            return false;
        }
        return true;
    }
    public boolean mod_board(char dir) {
        Point new_head = body.move_snake(dir);
        boolean validity = isValid(new_head);
        if(!validity) {
            return false;
        }
        brd_points.remove(new_head);
        if(board[new_head.x][new_head.y] != 'f') {
            for(Point p:brd_points){
                System.out.println(p.x + " " + p.y);
            }
            Point tail = body.body.getFirst();
            brd_points.add(tail);
            board[tail.x][tail.y] = '.';
            body.body.removeFirst();
        } else {
            // brd_points.remove(f.food);
            Point fd_point = f.gen_food(brd_points,brd_points.size());
            board[fd_point.x][fd_point.y] = 'f';
        }
        board[new_head.x][new_head.y] = '*';
        return true;
    }
    public void print_board() {
        System.out.println("Snake game ! \n");
        for (char[] row : board) {
            for (char chr : row) {
                System.out.print(chr + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
