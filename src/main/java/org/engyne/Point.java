package org.engyne;

public class Point {

    private double x;
    private double y;

    public Point(){
        this.x = 0.0;
        this.y = 0.0;
    }
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    double getX(){
        return this.x;
    }
    double getY(){
        return this.y;
    }

    public double getDistance(Point other){

        double dx = other.x - this.x;
        double dy = other.y - this.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
/*
  Point p1 = new Point(0.0, 0.0);
  Point p2 = new Point(3.0, 4.0);
  double distance = p1.getDistance(p2);
 */