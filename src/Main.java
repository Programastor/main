public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("Красный", "Чёрный", 5),
                new Rectangle("Синий", "Жёлтый", 4, 6),
                new Triangle("Зелёный", "Белый", 3, 4, 5)
        };

        for (Shape shape : shapes) {
            shape.printInfo();
            System.out.println();
        }
    }
}