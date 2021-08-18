package lesson1.polymorphism;

public class Circle implements Figure {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        final float pi = 3.14f;
        int s;
        s = (int) (Math.pow(this.radius, 2) * pi);
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "Circle: \n" +
                "radius=" + radius;
    }
}
