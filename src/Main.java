public class Main {
    public static void main(String[] args) {
        System.out.println("=== Задание 1: Животные ===");

        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");

        dogBobik.run(150);
        dogBobik.swim(5);
        dogBobik.run(600);

        catMurzik.run(150);
        catMurzik.swim(5);
        catMurzik.run(250);

        System.out.println();

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Рыжик");
        cats[2] = new Cat("Васька");
        cats[3] = new Cat("Снежок");
        cats[4] = new Cat("Тиша");

        Bowl bowl = new Bowl(30);

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        System.out.println();

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " — сыт: " + cat.isFull());
        }

        System.out.println();

        bowl.addFood(50);

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 10);
            }
        }

        System.out.println();

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());

        System.out.println("\n=== Задание 2: Геометрические фигуры ===");

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

interface Shape {
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

class Animal {
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    static int animalCount = 0;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance && distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (лимит: " + maxRunDistance + " м.)");
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " не умеет плавать.");
            return;
        }
        if (distance <= maxSwimDistance && distance > 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (лимит: " + maxSwimDistance + " м.)");
        }
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Cat extends Animal {
    boolean isFull = false;
    static int catCount = 0;

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    public boolean eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " съел " + amount + " еды. Сытость: " + isFull);
            return true;
        } else {
            System.out.println(name + " не хватило еды в миске. Сытость: " + isFull);
            return false;
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}

class Dog extends Animal {
    static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Bowl {
    int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        food = Math.max(0, food - amount);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + food);
        }
    }
}

class Circle implements Shape {
    String fillColor;
    String borderColor;
    double radius;

    public Circle(String fillColor, String borderColor, double radius) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
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

class Rectangle implements Shape {
    String fillColor;
    String borderColor;
    double width;
    double height;

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

class Triangle implements Shape {
    String fillColor;
    String borderColor;
    double sideA;
    double sideB;
    double sideC;

    public Triangle(String fillColor, String borderColor, double sideA, double sideB, double sideC) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
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