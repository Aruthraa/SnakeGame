package SnakeGame;

import java.util.LinkedList;

public class SnakeBody {
    public static LinkedList<Point> body = new LinkedList<Point>();
    public SnakeBody() {
        body.add(new Point(0, 0));
        body.add(new Point(0, 1));
    }
    public Point move_snake(char dir) {
        Point head = body.getLast();
        if(dir == 'U') {
            body.add(new Point(head.x-1, head.y));
        } else if (dir == 'D') {
            body.add(new Point(head.x+1, head.y));
        } else if (dir == 'R') {
            body.add(new Point(head.x, head.y+1));
        } else if (dir == 'L') {
            body.add(new Point(head.x, head.y-1));
        } else {
            body.add(new Point(-1, -1));
        }
        return body.getLast();
    }
}
