package lesson1.polymorphism;

public class MainPolymorphism {
    public static void main(String[] args) {
        Square square = new Square(4);
        Triangle triangle = new Triangle(4, 5, 30);
        Circle circle = new Circle(15);

        square.area();
        circle.area();
        triangle.area();

    }
}
