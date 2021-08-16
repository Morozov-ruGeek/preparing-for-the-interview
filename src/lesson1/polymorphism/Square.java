package lesson1.polymorphism;

public class Square implements Figure {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public void area() {
        int s;
        s = (int) Math.pow(this.side, 2);
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "Square: \n" +
                "side=" + side;
    }
}
