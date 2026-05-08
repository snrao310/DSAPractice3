import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DetectSquaresLeetCode {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            Point p = (Point) o;
            if (this.x == p.x && this.y == p.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    class CountSquares {

        HashMap<Point, Integer> points;

        public CountSquares() {
            points = new HashMap<>();
        }

        public void add(int[] point) {
            Point p = new Point(point[0], point[1]);
            points.put(p, points.getOrDefault(p, 0) + 1);

        }

        public int count(int[] point) {
            int px = point[0], py = point[1], res = 0;
            for (Point p : points.keySet()) {
                int x = p.x, y = p.y;
                if (x != px && y != py && Math.abs(x - px) == Math.abs(y - py)) {
                    int numSquares = points.get(new Point(x, y)) * points.getOrDefault(new Point(px, y), 0)
                            * points.getOrDefault(new Point(x, py), 0);
                    res += numSquares;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        CountSquares countSquares = new DetectSquaresLeetCode().new CountSquares();
        countSquares.add(new int[] { 3, 10 });
        countSquares.add(new int[] { 11, 2 });
        countSquares.add(new int[] { 3, 2 });
        System.out.println(countSquares.count(new int[] { 11, 10 }));
        System.out.println(countSquares.count(new int[] { 14, 8 }));
        countSquares.add(new int[] { 11, 2 });
        System.out.println(countSquares.count(new int[] { 11, 10 }));
    }

}
