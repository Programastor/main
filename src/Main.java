//2. Создать массив из 5 товаров.
public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Продукт-1", "01.02.2025",
                "Фабрика_1", "Россия", 100, true);
        productsArray[1] = new Product("Продукт-2", "15.02.2025",
                "Фабрика_2", "Беларусь", 250, false);
        productsArray[2] = new Product("Продукт-3", "20.02.2025",
                "Фабрика_3", "Казахстан", 175, true);
        productsArray[3] = new Product("Продукт-4", "05.03.2025",
                "Фабрика_4", "Россия", 320, false);
        productsArray[4] = new Product("Продукт-5", "10.03.2025",
                "Фабрика_5", "Китай", 410, true);

        for (Product product : productsArray) {
            product.printInfo();
        }
    }
}