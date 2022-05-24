import java.util.Objects;

    //Создайте класс Human с полями: фамилия, имя, отчество, возраст и методами:
    //конструкторы, геттеры/сеттеры, equals и hashCode.
    //Напишите метода класса ListDemo, который получает на вход список объектов типа Human
    //и еще один объект типа Human. Результат — список однофамильцев заданного человека
    //среди людей из входного списка.

public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private int age;

    public Human(String surname, String name, String patronymic, int age){
        if(age < 0) throw new IllegalArgumentException("Отрицательный параметр age");
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(surname, human.surname) && Objects.equals(name, human.name) && Objects.equals(patronymic, human.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, age);
    }

}
