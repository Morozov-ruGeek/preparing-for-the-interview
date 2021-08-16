package lesson1.polymorphism;

public class Triangle implements Figure {

    private int firstSide;
    private int secondSide;
    private int angle;


    public Triangle(int firstSide, int secondSide, int angle) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.angle = angle;
    }

    @Override
    public void area() {
        int s;
        s = (int) (1/2 * this.firstSide * this.secondSide * Math.sin(this.angle));
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "Triangle: \n" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", angle=" + angle;
    }
}
