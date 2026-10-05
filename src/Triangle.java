public class Triangle implements Shape {
    private String fillColor;
    private String borderColor;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String fillColor, String borderColor,
                    double sideA, double sideB, double sideC) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        // Формула Герона
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
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