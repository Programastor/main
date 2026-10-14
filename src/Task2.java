public class Task2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+7-900-111-22-33");
        phoneBook.add("Петров", "+7-900-444-55-66");
        phoneBook.add("Иванов", "+7-900-777-88-99");

        System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров"));
    }
}