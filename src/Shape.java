public interface Shape {
    double area();

    default double perimeter() {
        return 0;
    }

    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Фигура: " + this.getClass().getSimpleName());
        System.out.println("Площадь: " + area());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}