//2. Создать массив из 5 товаров.
void main() {
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
//1.Создать класс "Товар" с полями: название, дата производства, производитель,
// страна происхождения, цена, состояние бронирования покупателем.
public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String countryOfOrigin;
    double price;
    boolean isReserved;

    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.println("Товар: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Забронирован: " + (isReserved ? "Да" : "Нет"));
    }
}
//3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить
// информацию об аттракционах, времени их работы и стоимости.
public class Park {
    String name;

    public Park(String name) {
        this.name = name;
    }

    public class Attraction {
        String attractionName;
        String workingHours;
        double cost;

        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost);
        }
    }
}