import org.testng.annotations.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionsDemoTest {


    @Test
    public void testNumberOfLinesWithCharacter(){
        List<String> stringList = new ArrayList<>(4);
        stringList.add("человек");
        stringList.add("студент");
        stringList.add("черепаха лежит на солнце");
        stringList.add("очки");

        char symbol = 'ч';

        int expected = 2;
        int result = CollectionsDemo.NumberOfLinesWithCharacter(stringList, symbol);

        assertEquals(expected, result);
    }

    @Test
    public void testListOfNamesakes(){
        Human human1 = new Human("Мартиросян", "Миша", "Араратович", 23);
        Human human2 = new Human("Киселев", "Олег", "Александрович", 20);
        Human human3 = new Human("Киселев", "Данил", "Николаевич", 21);
        Human human4 = new Human("Быков", "Данил", "Евгеньевич", 21);
        Human human5 = new Human("Колистратова", "Юлия", "Евгеньевна", 22);

        List<Human> peopleList = new ArrayList<>(5);
        peopleList.add(human1);
        peopleList.add(human2);
        peopleList.add(human3);
        peopleList.add(human4);
        peopleList.add(human5);

        Human human = new Human("Киселев", "Виктор", "Александрович", 20);

        List<Human> expected = new ArrayList<>(2);
        expected.add(human2);
        expected.add(human3);

        List<Human> result = CollectionsDemo.listOfNamesakes(peopleList, human);

        assertEquals(expected, result);
    }

    @Test
    public void testCopyOfListWithoutPerson(){
        Human human1 = new Human("Мартиросян", "Миша", "Араратович", 23);
        Human human2 = new Human("Киселев", "Олег", "Александрович", 20);
        Human human3 = new Human("Киселев", "Данил", "Николаевич", 21);
        Human human4 = new Human("Быков", "Данил", "Евгеньевич", 21);
        Human human5 = new Human("Колистратова", "Юлия", "Евгеньевна", 22);

        List<Human> peopleList = new ArrayList<>(5);
        peopleList.add(human1);
        peopleList.add(human2);
        peopleList.add(human3);
        peopleList.add(human4);
        peopleList.add(human5);

        Human human = new Human("Мартиросян", "Миша", "Араратович", 23);
        List<Human> expected = new ArrayList<>(4);
        expected.add(human2);
        expected.add(human3);
        expected.add(human4);
        expected.add(human5);

        List<Human> result = CollectionsDemo.copyOfListWithoutPerson(peopleList, human);

        assertEquals(expected, result);
    }

    @Test
    public void testListOfSetsWithoutIntersectio(){
        List<Set<Integer>> expected = new ArrayList<>();
        List<Set<Integer>> setList = new ArrayList<>(4);
        Set<Integer> integerSet = new HashSet<>(4);
        Set<Integer> integerSet1 = new HashSet<>(4);
        Set<Integer> integerSet2 = new HashSet<>(4);
        Set<Integer> integerSet3 = new HashSet<>(4);

        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);

        integerSet1.add(5);
        integerSet1.add(6);
        integerSet1.add(7);
        integerSet1.add(8);

        integerSet2.add(9);
        integerSet2.add(10);
        integerSet2.add(11);
        integerSet2.add(12);

        integerSet3.add(1);
        integerSet3.add(2);
        integerSet3.add(3);
        integerSet3.add(4);

        expected.add(integerSet1);
        expected.add(integerSet2);

        setList.add(integerSet1);
        setList.add(integerSet2);
        setList.add(integerSet3);

        List<Set<Integer>> result = CollectionsDemo.listOfSetsWithoutIntersection(setList, integerSet);

        assertEquals(expected, result);
    }

    @Test
    public void testPeopleWithMaxAge(){
        Human human1 = new Human("Колистратов", "Евгений", "Николаевич", 45);
        Human human2 = new Human("Колистратова", "Татьяна", "Александровна", 40);
        Human human3 = new Human("Воробьева", "Наталья", "Васильевна", 45);
        Human human4 = new Human("Воробьева", "Анастасия", "Дмитриевна", 31);
        Student student1 = new Student("Колистратова", "Юлия", "Евгеньевна", 22, "ФМИТ");
        Student student2 = new Student("Никитин", "Петр", "Витальевич", 20, "ФМИТ");
        Student student3 = new Student("Колистратов", "Илья", "Евгеньевич", 18, "Землеустройство");

        List<Human> list = new ArrayList<>(8);
        list.add(human1);
        list.add(human2);
        list.add(human3);
        list.add(human4);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        Set<Human> result = CollectionsDemo.peopleWithMaxAge(list);
        Set<Human> expected = new HashSet<>(5);
        expected.add(human1);
        expected.add(human3);

        assertEquals(expected, result);
    }

    @Test
    public void testPeopleWithAGivenID(){
        Map<Integer, Human> integerHumanMap= new HashMap<>();
        Human human1 = new Human("Мартиросян", "Миша", "Араратович", 23);
        Human human2 = new Human("Киселев", "Олег", "Александрович", 20);
        Human human3 = new Human("Киселев", "Данил", "Николаевич", 21);
        Human human4 = new Human("Быков", "Данил", "Евгеньевич", 21);
        Human human5 = new Human("Колистратова", "Юлия", "Евгеньевна", 22);

        integerHumanMap.put(123, human1);
        integerHumanMap.put(256, human2);
        integerHumanMap.put(438, human3);
        integerHumanMap.put(102, human4);
        integerHumanMap.put(596, human5);

        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(256);
        integerSet.add(365);
        integerSet.add(102);

        Set<Human> result = CollectionsDemo.peopleWithAGivenID(integerHumanMap, integerSet);
        Set<Human> expected = new HashSet<>();
        expected.add(human2);
        expected.add(human4);

        assertEquals(expected,result);
    }

    @Test
    public void testAdultIdentifiers(){
        Map<Integer, Human> integerHumanMap= new HashMap<>();
        Human human1 = new Human("Мартиросян", "Миша", "Араратович", 23);
        Human human2 = new Human("Киселев", "Олег", "Александрович", 15);
        Human human3 = new Human("Киселев", "Данил", "Николаевич", 18);
        Human human4 = new Human("Быков", "Данил", "Евгеньевич", 13);
        Human human5 = new Human("Колистратова", "Юлия", "Евгеньевна", 22);

        integerHumanMap.put(123, human1);
        integerHumanMap.put(256, human2);
        integerHumanMap.put(438, human3);
        integerHumanMap.put(102, human4);
        integerHumanMap.put(596, human5);

        List<Integer> result = CollectionsDemo.adultIdentifiers(integerHumanMap);
        List<Integer> expected = new ArrayList<>();
        expected.add(123);
        expected.add(438);
        expected.add(596);

        result.removeAll(expected);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMatchingIDToAge(){
        Map<Integer, Human> integerHumanMap= new HashMap<>();
        Human human1 = new Human("Мартиросян", "Миша", "Араратович", 23);
        Human human2 = new Human("Киселев", "Олег", "Александрович", 15);
        Human human3 = new Human("Киселев", "Данил", "Николаевич", 18);
        Human human4 = new Human("Быков", "Данил", "Евгеньевич", 13);
        Human human5 = new Human("Колистратова", "Юлия", "Евгеньевна", 22);

        integerHumanMap.put(123, human1);
        integerHumanMap.put(256, human2);
        integerHumanMap.put(438, human3);
        integerHumanMap.put(102, human4);
        integerHumanMap.put(596, human5);

        Map<Integer, Integer> result = CollectionsDemo.matchingIDToAge(integerHumanMap);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(123, 23);
        expected.put(256, 15);
        expected.put(438, 18);
        expected.put(102, 13);
        expected.put(596, 22);

        assertEquals(expected, result);
    }

    @Test
    public void testListOfPeopleOfThisAge(){
        Set<Human> humans = new HashSet<>();
        Human human1 = new Human("Мартиросян", "Миша", "Араратович", 22);
        Human human2 = new Human("Киселев", "Олег", "Александрович", 15);
        Human human3 = new Human("Киселев", "Данил", "Николаевич", 18);
        Human human4 = new Human("Быков", "Данил", "Евгеньевич", 15);
        Human human5 = new Human("Колистратова", "Юлия", "Евгеньевна", 22);

        humans.add(human1);
        humans.add(human2);
        humans.add(human3);
        humans.add(human4);
        humans.add(human5);

        Map<Integer, List<Human>> result = CollectionsDemo.listOfPeopleOfThisAge(humans);

        List<Human> list1 = new ArrayList<>();
        List<Human> list2 = new ArrayList<>();
        List<Human> list3 = new ArrayList<>();

        list1.add(human1);
        list1.add(human5);

        list2.add(human4);
        list2.add(human2);

        list3.add(human3);

        Map<Integer, List<Human>> expected = new HashMap<>();
        expected.put(22, list1);
        expected.put(15, list2);
        expected.put(18, list3);

        assertEquals(expected, result);
    }

}
