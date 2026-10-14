import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Task1 {

    // Метод, который удаляет студентов со средним баллом < 3
    public static void removeLowPerformingStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove(); // Безопасное удаление через итератор
            }
        }
    }

    // Метод, который переводит студента на следующий курс, если средний балл >= 3
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Метод printStudents
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(" - " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println(" - Нет студентов на данном курсе.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        // Создаем студентов с разными оценками
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Math", 5); grades1.put("Physics", 4); // Средний 4.5
        students.add(new Student("Иванов", 101, 1, grades1));

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Math", 2); grades2.put("Physics", 2); // Средний 2.0
        students.add(new Student("Петров", 101, 1, grades2));

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Math", 3); grades3.put("Physics", 3); // Средний 3.0
        students.add(new Student("Сидоров", 102, 2, grades3));

        System.out.println("--- Исходный список студентов ---");
        for (Student s : students) System.out.println(s);

        // 1. Удаляем неуспевающих
        removeLowPerformingStudents(students);
        System.out.println("\n--- После удаления неуспевающих ---");
        for (Student s : students) System.out.println(s);

        // 2. Переводим на следующий курс
        promoteStudents(students);
        System.out.println("\n--- После перевода на следующий курс ---");
        for (Student s : students) System.out.println(s);

        // 3. Печатаем студентов определенного курса
        printStudents(students, 2);
        printStudents(students, 3);
    }
}