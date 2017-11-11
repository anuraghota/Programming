import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JarvisMarchConvexHull
{
    static class Point
    {
        int x;
        int y;
        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> findConvexHull(Point[] points)
    {
        Point start = points[0];
        for(int i = 1; i < points.length; i++)
        {
            if(points[i].x < start.x)
            {
                start = points[i];
            }
        }

        Point current = start;
        Set<Point> result = new HashSet<Point>();
        result.add(current);
        List<Point> collinearPoints = new ArrayList<Point>();
        while(true)
        {
            Point nextTarget = points[0];
            for(int i = 1; i < points.length; i++) {
                if (points[i] == current) {
                    continue;
                }

                int crossProduct = crossProduct(current, nextTarget, points[i]);
                if (crossProduct > 0) {
                    nextTarget = points[i];
                    collinearPoints = new ArrayList<Point>();
                } else if (crossProduct == 0) {
                    int distance = distance(current, nextTarget, points[i]);
                    if (distance < 0) {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else {
                        collinearPoints.add(points[i]);
                    }
                } else {
                    //Do Nothing
                }
            }

            for (Point p : collinearPoints) {
                result.add(p);
            }

            if (nextTarget == start) {
                break;
            }

            result.add(nextTarget);
            current = nextTarget;
        }

        for(Point p: result)
        {
            System.out.printf("(%d,%d)\n",p.x,p.y);
        }
        return new ArrayList<>(result);
    }

    // Returns <0 if b is closer to a than c, ==0 if b and c are equidistant, >0 if b is further.
    public static int distance(Point a, Point b, Point c)
    {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;

        return Integer.compare(y1*y1 + x1*x1, y2*y2 + x2*x2);
    }

    public static int crossProduct(Point a, Point b, Point c)
    {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;

        return y2*x1 - y1*x2;
    }

    public static void main(String args[])
    {
        Point p1 = new Point(-2,4);
        Point p2 = new Point(0,4);
        Point p3 = new Point(1,3);
        Point p4 = new Point(4,4);
        Point p5 = new Point(6,2);
        Point p6 = new Point(4,-2);
        Point p7 = new Point(2,-1);
        Point p8 = new Point(-1,-4);

        Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8};
        findConvexHull(points);
    }
}
