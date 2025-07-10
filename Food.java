package SnakeGame;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Food {
    public static Point food;
    public Food() {
        food = new Point(2, 1);
    }
    public Point gen_food(ArrayList<Point> brd_points,int size) {
        for(Point p:brd_points){
            System.out.println(p.x + " " + p.y);
        }
        int ind = (int)(Math.random()*size);
        this.food = brd_points.get(ind);
        return this.food;
    }
}
