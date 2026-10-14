import java.util.*;

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
        printStudents(students, 2); // Иванов перешел на 2 курс
        printStudents(students, 3); // Сидоров перешел на 3 курс
        //
}