import java.util.Map;

public class Student {
    private String name;
    private int group;
    private int course;
    private Map<String, Integer> grades; // Оценки по предметам

    public Student(String name, int group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;

    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", course=" + course +
                ", avgGrade=" + String.format("%.2f", getAverageGrade()) +
                '}';
    }
}