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