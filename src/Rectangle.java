public class Rectangle implements Shape {
    private String fillColor;
    private String borderColor;
    private double width;
    private double height;

    public Rectangle(String fillColor, String borderColor, double width, double height) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}