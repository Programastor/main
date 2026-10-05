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
