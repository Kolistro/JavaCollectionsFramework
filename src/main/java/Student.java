// Создайте класс Student, производный от Human, новое поле — название факультета,
// к нему геттер, сеттер и конструктор.
// Напишите метод класса ListDemo, который получает на вход список, состоящий из объектов типа Human
// и его производных классов.
// Результат — множество людей из входного списка с максимальным возрастом.

public class Student extends Human{
    private String faculty;

    public Student(String surname, String name, String patronymic, int age, String faculty) {
        super(surname, name, patronymic, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
